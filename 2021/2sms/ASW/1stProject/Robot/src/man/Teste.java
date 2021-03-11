package man;

import static robocode.util.Utils.normalRelativeAngleDegrees;

import robocode.*;

public class Teste extends AdvancedRobot {

	int turnDirection = 1, scan = 0;
	boolean peek;
	double midx;
	double midy;

	public void run() {
		while (true) {
			moveToCenter();
		}
	}

	public void moveToCenter() {
		double x = 0.0;
		double y = 0.0;
		double move = 0.0;
		double t = 0.0;
			midx = getBattleFieldWidth() / 2.0;
			midy = getBattleFieldHeight() / 2.0;
			x = midx - getX();
			y = midy - getY();
			move = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			t = Math.abs(Math.toDegrees(Math.atan((Math.toRadians(y) / Math.toRadians(x)))));

			// 1
			if (x < 0 && y < 0) {
				Oeste();
				turnLeft(t);
			}

			// 2
			else if (x >= 0 && y < 0) {
				Este();
				turnRight(t);
			}

			// 3
			else if (x >= 0 && y >= 0) {
				Este();
				turnLeft(t);
			}

			// 4
			else if (x < 0 && y >= 0) {
				Oeste();
				turnRight(t);
			}

			// Meio
			ahead(move);
			while(!peek) turnGunRight(Double.POSITIVE_INFINITY);
	}

	public void Este() {
		double head = getHeading();

		if (head > 270 && getHeading() < 360)
			turnRight(450 - getHeading());

		else if (head >= 90 && getHeading() <= 270)
			turnLeft(getHeading() - 90);

		else if (head >= 0 && getHeading() < 90)
			turnRight(90 - getHeading());

	}

	public void Oeste() {
		double head = getHeading();

		if (head > 270.0 && head < 360.0)
			turnLeft(getHeading() - 270);

		else if (head >= 90.0 && head <= 270.0)
			turnRight(270 - getHeading());

		else if (head >= 0.0 && head < 90.0)
			turnLeft(90 + getHeading());

	}

	/**
	 * 
	 * Ajusta a potência de disparo consoante a distância a que o inimigo se
	 * encontra
	 * 
	 * @param robotDistance
	 * @author Filipe Colla David (up201810097)
	 * 
	 */
	public void smartFire(double robotDistance) {

		if (robotDistance > 200 || getEnergy() < 15) {
			fire(0.5);
			fire(0.5);
			fire(0.5);
		} else if (robotDistance > 50) {
			fire(2);
			fire(2);
		} else {
			fire(3);
		}

	}

	
	/**
	 * Devolve a distância optima que o robot se deve deslocar de modo a não bater
	 * numa parede quando está a fazer dodge
	 * 
	 * @return cat
	 * @author Filipe Colla David (up201810097)
	 * 
	 */
	public double cat() {

		double h = getHeading();
		double cat = 0;
		if (h >= 325 || h <= 44) {
			// Ver em que metade do mapa está
			if (getX() >= (getWidth() / 2)) {
				cat = getX();
			} else
				cat = getWidth() - getX();
		}

		else if (h >= 45 && h <= 144) {
			// Ver em que metade do mapa está
			if (getY() >= (getHeight() / 2)) {
				cat = getY();
			} else
				cat = getHeight() - getY();
		} else if (h >= 145 && h <= 234) {
			// Ver em que metade do mapa está
			if (getX() <= (getWidth() / 2)) {
				cat = getX();
			} else
				cat = getX() - getWidth();
		} else if (h >= 235 && h <= 324) {
			// Ver em que metade do mapa está
			if (getY() <= (getHeight() / 2)) {
				cat = getY();
			} else
				cat = getX() - getHeight();
		}

		return cat;
	}
	
	/**
	 * 
	 * De modo a não ser acertado por inimigo desvia se e dispara ajustando a mira
	 * sempre que se desvia de modo a não acertar no inimigo
	 * 
	 * @param dist
	 * @param e
	 * @author Filipe Colla David (up201810097)
	 *
	 */
	public void dodge(Double dist, ScannedRobotEvent e) {
		double cat = cat();

		if (e.getBearing() >= 0) {
			turnDirection = -1;
		} else {
			turnDirection = 1;
		}

		// Desviar me dos tiros, angulo tem que ser consoante a distância
		double hip = Math.sqrt((cat * cat) + (dist * dist));
		double angle = Math.acos(cat / hip) * (180 / Math.PI);

		while (peek) {

			// Posição à direita
			ahead(cat/4.0);
			turnGunLeft((turnDirection) * (90 - angle));
			smartFire(dist);

			// Posição Central
			back(cat/4.0);
			turnGunLeft((-turnDirection) * (90 - angle));
			smartFire(dist);

			// Posição à esquerda
			back(cat/4.0);
			turnGunLeft((-turnDirection) * (90 - angle));
			smartFire(dist);

			// Posição Central
			ahead(cat/4.0);
			turnGunLeft((turnDirection) * (90 - angle));
			smartFire(dist);

		}

	}

	/**
	 * 
	 * Tenta calcular a posição futura do adversário e tenta disparar tendo em conta
	 * a distância e a velocidade
	 * 
	 * @param e
	 * @author Filipe Colla David (up201810097)
	 *
	 */
	public void shootAhead(ScannedRobotEvent e) {
		//smartFire(e.getDistance());
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		scan = 0;
		if (!(getX() >= midx - 1 && getX() <= midx + 1) && !(getY() >= midy - 1 && getY() <= midy + 1)) {
			return;
		} else {
			peek = true;

			if (e.getVelocity() == 0) {
				if (scan == 0) scan();
				else scan = 1;
				
				double absoluteBearing = (getHeading() + e.getBearing());

				turnRight(e.getBearing() + (turnDirection * 90));
				double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
				double dist = e.getDistance();
				
				turnGunRight(bearingFromGun);
				dodge(dist, e);
			}
			
			else {
				//turnGunRight(Double.POSITIVE_INFINITY);
				scan();
				shootAhead(e);
			}
		}
	}

	public void onBulletMissed(BulletMissedEvent e) {
		//moveToCenter();
	}

	public void onHitWall(HitWallEvent e) {
		stop();
		peek = false;
		moveToCenter();
		resume();

	}

}
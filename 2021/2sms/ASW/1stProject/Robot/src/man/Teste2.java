package man;

import static robocode.util.Utils.normalRelativeAngleDegrees;

import robocode.*;

public class Teste2 extends AdvancedRobot {

	int turnDirection = 1, scan = 0;
	boolean peek, mid, dodge;
	double midx;
	double midy;

	public void run() {
		moveToCenter();
		dodge = false; 
		peek = false;
		while (!peek) {
			turnRadarRight(Double.POSITIVE_INFINITY);
		}
	}

	/**
	 * 
	 * Função responsável por mover o robot para o centro do mapa independetemente da posição inicial
	 * 
	 * 
	 */

	public void moveToCenter() {
		double y = 0.0;
		double x = 0.0;
		double t = 0.0;
		double move = 0.0;
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

		// Move em direção ao meio
		ahead(move);
	}
	// Se o robot estiver virado para Este
	public void Este() {
		double head = getHeading();

		if (head > 270 && getHeading() < 360)
			turnRight(450 - getHeading());

		else if (head >= 90 && getHeading() <= 270)
			turnLeft(getHeading() - 90);

		else if (head >= 0 && getHeading() < 90)
			turnRight(90 - getHeading());

	}

	//Se o robot estiver virado para Oeste
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
	 * 
	 * 
	 */
	public void smartFire(double robotDistance) {

		if (robotDistance > 200 || getEnergy() < 15) {
			fire(0.5);
		} else if (robotDistance > 50) {
			fire(2);
		} else {
			fire(3);
		}

	}

	/**
	 * 
	 * Devolve a distância optima que o robot se deve deslocar de modo a não bater
	 * numa parede quando está a fazer dodge
	 * 
	 * @return cat
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

		return cat - 5;
	}

	/**
	 * 
	 * De modo a não ser acertado por inimigo desvia se e dispara ajustando a mira
	 * sempre que se desvia para não falhar o alvo
	 * 
	 * @param dist
	 * @param e
	 *
	 */
	public void dodge(Double dist, ScannedRobotEvent e) {
		dodge = true;
		double cat = cat() / 3.0;

		// Desviar me dos tiros, angulo tem que ser consoante a distância
		double hip = Math.sqrt((cat * cat) + (dist * dist));
		double angle = Math.acos(cat / hip) * (180.0 / Math.PI);

		while (peek) {

			// Posição à direita
			ahead(cat);
			turnGunLeft((turnDirection) * (90 - angle));
			smartFire(dist - 2000);

			// Posição Central
			back(cat);
			turnGunLeft((-turnDirection) * (90 - angle));
			smartFire(dist - 2000);

			// Posição à esquerda
			back(cat);
			turnGunLeft((-turnDirection) * (90 - angle));
			smartFire(dist - 2000);

			// Posição Central
			ahead(cat);
			turnGunLeft((turnDirection) * (90 - angle));
			smartFire(dist - 2000);
		}
		dodge = false;
	}

	/**
	 * Verifica se o robot se encotra mid
	 * 
	 * @return bool
	 * 
	 */
	public boolean isMid() {
		mid = true;
		return (getX() >= midx - 1 && getX() <= midx + 1) && (getY() >= midy - 1 && getY() <= midy + 1);
	}

	/**
	 * 
	 * Verifica se está no meio de mapa, ou se já esteve no meio do mapa.
	 * Se o outro robô não se estiver parado, faz um movimento random. 
	 * Se o outro robô estiver parado, verifica mais uma vez se está realmente parado, vira 
	 * de modo a ficar com a arma perpendicular ao heading, e começa a disparar com o dodge
	 * 
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		
		peek = true;
		
		if (!isMid() && !mid) return;
		else {
			if (e.getVelocity() == 0) {
				if (scan <= 1) {
					randMovement(e);
					scan++;
					scan();
				}
				else {
					if (e.getBearing() >= 0.5) {
						turnDirection = 1;
					} else {
						turnDirection = -1;
					}

					double absoluteBearing = (getHeading() + e.getBearing());

					turnRight(e.getBearing() + (turnDirection * 90));
					double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
					double dist = e.getDistance();

					turnGunRight(bearingFromGun);
					dodge(dist, e);
				}
			}

			else {
				randMovement(e);
			}
		}
	}
	
	/**
	 * Movimento "random"
	 * @param e
	 */
	public void randMovement(ScannedRobotEvent e) {
		double dist = (Math.random() * ((100 - 10) + 1)) + 10;
		ahead(dist);
		back(dist*2);
		ahead(dist);
		turnLeft(90);
	
	}

	public void onBulletMissed(BulletMissedEvent e) {
		peek = false;
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		if(!dodge) {
			turnLeft(90);
			ahead(100);
		}
		return;
	}

	public void onHitWall(HitWallEvent e) {
		peek = false;
		moveToCenter();

	}

	public void onHitRobot(HitRobotEvent e) {
		double absoluteBearing = (getHeading() + e.getBearing());
		double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
		turnGunRight(bearingFromGun);
		fire(3);
		moveToCenter();
	}

}
package man;

import static robocode.util.Utils.normalRelativeAngleDegrees;

import robocode.*;
import robocode.util.Utils;

/**
 * 
 * @author fcd
 * @author João 
 */

public class My2ndRobot1 extends AdvancedRobot {
	
	int turnDirection = 1,scan = 0;
	boolean peek;
	
	public void run() {
		peek = false;
		
		moveTowardsCenter();
		
		execute();
		
		do{
			moveTowardsCenter();
			execute();
			turnRadarRight(Double.POSITIVE_INFINITY);
		}while(!peek);
		
	}
	
	
	private void moveTowardsCenter() {		
		double catx = cat();
		double caty = cat();
		
		double hip = Math.sqrt((catx*catx)+(caty*caty));
	    
		double centerAngle = Math.atan2(caty, catx) * (180/Math.PI);
		
	    setTurnRight(Utils.normalRelativeAngle(centerAngle - getHeading()));
	    setAhead(hip);
	}
	
	/**Dispara consoante a posição do outro robô e energia restante
	 * 
	 * @param robotDistance
	 * @return void
	 */
	public void smartFire(double robotDistance) {
		
		if (robotDistance > 200 || getEnergy() < 15) {
			fire(0.5);
			fire(0.5);
			fire(0.5);
		} 
		else if (robotDistance > 50) {
			fire(2);
			fire(2);
		} 
		else {
			fire(3);
		}
		
	}
	
	public double cat () {
		
		double h = getHeading();
		double cat = 0;
		if(h>=325 || h<=44) {
			//Ver em que metade do mapa está
			if(getX() >= (getWidth()/2)) {
				cat = getX();
			}
			else cat = getWidth() - getX();
		}
		
		else if(h>=45 && h<=144) {
			//Ver em que metade do mapa está
			if(getY() >= (getHeight()/2)) {
				cat = getY();
			}
			else cat = getHeight() - getY();
		}
		else if(h>=145 && h<=234) {
			//Ver em que metade do mapa está
			if(getX() <= (getWidth()/2)) {
				cat = getX();
			}
			else cat = getX() - getWidth();
		}
		else if(h>=235 && h<=324) {
			//Ver em que metade do mapa está
			if(getY() <= (getHeight()/2)) {
				cat = getY();
			}
			else cat = getX() - getHeight();
		}
		
		return cat-5;
	}
	public void dodge(Double dist, ScannedRobotEvent e) {
		double cat = cat();
		
		if (e.getBearing() >= 0) {
			turnDirection = -1;
		} 		
		else {
			turnDirection = 1;
		}
		
		//Desviar me dos tiros, angulo tem que ser consoante a distância
    	double hip = Math.sqrt((cat*cat)+(dist*dist));
    	double angle = Math.acos(cat/hip) * (180/Math.PI);
    	
    	while(peek) {
    		
    		//Posição à direita
    		ahead(cat);
    		turnGunLeft((turnDirection)*(90-angle));
    		smartFire(dist);
    		
    		//Posição Central
    		back(cat);
    		turnGunLeft((-turnDirection)*(90-angle));
    		smartFire(dist);
    		
    		//Posição à esquerda
    		back(cat);    	
    		turnGunLeft((-turnDirection)*(90-angle));
    		smartFire(dist);
    		
    		//Posição Central
    		ahead(cat);
    		turnGunLeft((turnDirection)*(90-angle));
    		smartFire(dist);

    	}
    	
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		
		peek = true;
		
		double absoluteBearing = (getHeading() + e.getBearing());
		turnRight(e.getBearing()+(turnDirection*90));
		double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
		double dist = e.getDistance();
		
		if(e.getVelocity() == 0) {
			turnGunRight(bearingFromGun);
			dodge(dist,e);
		}
	}
	
	public void onBulletMissed(BulletMissedEvent e) {
		peek = false;
	}
	
	public void onHitWall(HitWallEvent e){
		stop();
		peek = false;
		moveTowardsCenter();
		resume();
		
    }
	
}

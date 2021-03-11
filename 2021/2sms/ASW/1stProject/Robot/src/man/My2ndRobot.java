package man;

import robocode.*;
import robocode.util.Utils;
import static robocode.util.Utils.normalRelativeAngleDegrees;

public class My2ndRobot extends AdvancedRobot{
	
	int turnDirection = 1,fstScan = 0; //Clockwise or CounterClockwise
	
	public void run() {
		int height = (int)getBattleFieldHeight();
		int width = (int)getBattleFieldWidth();
		while(true) {
			goTo(height/2,width/2);
			rotate();
		}
	}
	
	/*
	 * https://robowiki.net/wiki/GoTo
	 */
	private void goTo(double x, double y) {
	    /* Calculate the difference bettwen the current position and the target position. */
		stop();
	    x = x - getX();
	    y = y - getY();
	    
	    /* Calculate the angle relative to the current heading. */
	    double goAngle = Utils.normalRelativeAngle(Math.atan2(x, y) - getHeadingRadians());
		
	    /*
	     * Apply a tangent to the turn this is a cheap way of achieving back to front turn angle as tangents period is PI.
	     * The output is very close to doing it correctly under most inputs. Applying the arctan will reverse the function
	     * back into a normal value, correcting the value. The arctan is not needed if code size is required, the error from
	     * tangent evening out over multiple turns.
	     */
	    setTurnRightRadians(Math.atan(Math.tan(goAngle)));
		
	    /* 
	     * The cosine call reduces the amount moved more the more perpendicular it is to the desired angle of travel. The
	     * hypot is a quick way of calculating the distance to move as it calculates the length of the given coordinates
	     * from 0.
	     */
	    setAhead(Math.cos(goAngle) * Math.hypot(x, y));
	    resume();
	}
	
	public void rotate() {
		//double startAngle = getHeading();
		int inc = 10;
		while(true) {
			//Roda a arma com incrementos de 10 graus
			for(int i = 1; i<36; i++) {
				turnRight(i*inc);
			}	
			inc*=-1;
		}
	}
	
	//Dispara consoante a posição do outro robô e energia restante
	public void smartFire(double robotDistance) {
		stop();
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
		resume();
	}
	
	public void dodge(Double dist) {
		//Desviar me dos tiros, angulo tem que ser consoante a distância
    	double cat = dist/4;
    	double hip = Math.sqrt((cat*cat)+(dist*dist));
    	double angle = Math.acos(cat/hip) * (180/Math.PI);
    	
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
    	scan();
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		while(e.getVelocity() == 0) {
			
			if (e.getBearing() >= 0) {
				turnDirection = 1;
			} 
			else {
				turnDirection = -1;
			}
			double absoluteBearing = (getHeading() + e.getBearing());
			if(fstScan == 0) {
				turnRight(e.getBearing()+(turnDirection*90));
				fstScan++;
			}
	        //Encontra a posição relativa da arma à do robot
	        double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
	        turnGunRight(bearingFromGun);
			double dist = e.getDistance();
	        while(e.getEnergy() > 0 && e.getVelocity() == 0) {
	        	smartFire(dist);
	        	dodge(dist);
	        }
			scan();
		}
	}
	
	//This method is called when one of your bullets misses, i.e. hits a wall.
	public void onBulletMissed(BulletMissedEvent e) {
		int height = (int)getBattleFieldHeight();
		int width = (int)getBattleFieldWidth();
		stop();
		fstScan = 0;
		goTo(height/2,width/2);
	}
}

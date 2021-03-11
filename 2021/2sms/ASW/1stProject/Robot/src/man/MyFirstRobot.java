package man;
import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;


public class MyFirstRobot extends Robot {
	static int nrobots;
	boolean robotseen = false,movingForward;;
	int turnDirection = 1; //Clockwise or counterclockwise
	double startAngle = 0;
	
	public void run() {
		nrobots = getOthers();
		startAngle = getHeading();
		int inc = 1;
		while(true) {
			//Roda a arma com incrementos de 10 graus
			for(int i = 0; i<36; i++) {
				turnRight(startAngle*inc);
			}
		inc*=-1;
		}
	}
	
	public void dodge(double h) {
		turnLeft(h);
		ahead(1);
	}	
	
	public void ramAndFire(ScannedRobotEvent e) {       
        ahead(50);
        smartFire(e.getDistance());
	}
		
	//Dispara consoante a posição do outro robô e energia restante
	public void smartFire(double robotDistance) {
		stop();
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
	
	//This method is called when your robot sees another robot, i.e. when the robot's radar scan "hits" another robot.
	public void onScannedRobot(ScannedRobotEvent e) {
		stop();
		double absoluteBearing = getHeading() + e.getBearing();
		
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
        turnRight(e.getBearing());
        //Encontra a posição relativa da arma à do robot
        double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
        turnGunRight(bearingFromGun);
        if(e.getVelocity() == 0) {
        	fire(Rules.MAX_BULLET_POWER);
        	ahead(e.getDistance());
        	fire(Rules.MAX_BULLET_POWER);
        }
        else smartFire(e.getDistance());
        startAngle = getHeading();
        
		
	}
	
    //BULLETS
    //This method is called when one of your bullets hits another robot.
    public void onBulletHit(BulletHitEvent e) {
    	
    }
    
    //This method is called when one of your bullets hits another bullet.
	public void onBulletHitBullet(BulletHitBulletEvent e) {
		
	}
    
	//This method is called when one of your bullets misses, i.e. hits a wall.
	public void onBulletMissed(BulletMissedEvent e) {
		
	}
	
	//This method is called when your robot is hit by a bullet.
	public void onHitByBullet(HitByBulletEvent e) {
		stop();
		while(getGunHeading() >= e.getBearing()-45 && getGunHeading() <= e.getBearing()+45) {
			stop();
			smartFire(500);
		}
		if(getVelocity() == 0) {
			ahead(5000);
		}
		resume();
		
	}
	//END_BULLET
	
	//HIT
	//This method is called when your robot collides with another robot.
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
            turnDirection = 1;
        } else {
            turnDirection = -1;
        }
        turnRight(e.getBearing());

        if(getGunHeat() == 0){
            if (e.getEnergy() > 16) {
                fire(3);
            } else if (e.getEnergy() > 10) {
                fire(2);
            } else if (e.getEnergy() > 4) {
                fire(1);
            } else if (e.getEnergy() > 2) {
                fire(.5);
            } else if (e.getEnergy() > .4) {
                fire(.1);
            }
        }
        ahead(40); // Ram him again!*/
	}
	
	//This method is called when your robot collides with a wall.
    public void onHitWall(HitWallEvent e) {
    	turnLeft(180);
    	ahead(100);
    }
    //END_HIT
    
    //This method is called every turn in a battle round in order to provide the robot status as a complete snapshot of the robot's current state at that specific time.
    public void onStatus(StatusEvent e) {
    	
    }
 }
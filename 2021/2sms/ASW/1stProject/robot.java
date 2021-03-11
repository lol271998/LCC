package man;
import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;

public class Bot extends Robot {
	static int nrobots;
	boolean robotseen = false,movingForward;;
	int turnDirection = 1; //Clockwise or counterclockwise
	
	public void run() {
		nrobots = getOthers();
		int inc = 1;
		while(true) {
			//Roda a arma com incrementos de 10 graus
			for(int i = 0; i<36; i++) {
				turnRight(10*inc);
			}
		inc*=-1;
		}
	}
	
	public void dodge(double h) {
		turnLeft(h);
		ahead(10);
	}	
	
	public void ramAndFire(ScannedRobotEvent e) {
		
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
        ahead(500);
        if(e.getDistance()<10) fire(Rules.MAX_BULLET_POWER);
        //smartFire(e.getDistance(),e.getBearing());
	}
		
	//Dispara consoante a posição do outro robô e energia restante
	public void smartFire(double robotDistance,double robotHeading ) {
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
		//Se tiver parado vamos para cima dele
		if(e.getVelocity() == 0) {
			stop();
			ramAndFire(e);
			resume();
		}
		else {
		
		}
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
	}
	//END_BULLET
	
	//HIT
	//This method is called when your robot collides with another robot.
	public void onHitRobot(HitRobotEvent e) {
		if(e.getEnergy() > getEnergy()) dodge(getHeading());
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
        ahead(40); // Ram him again!
	}
	
	//This method is called when your robot collides with a wall.
    public void onHitWall(HitWallEvent e) {
    	turnRight (e.getBearing());
    	ahead(100);
    }
    //END_HIT
    
    //This method is called every turn in a battle round in order to provide the robot status as a complete snapshot of the robot's current state at that specific time.
    public void onStatus(StatusEvent e) {
    	
    }
 }
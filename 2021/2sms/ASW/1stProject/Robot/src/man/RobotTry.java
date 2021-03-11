package man;
import robocode.*;


// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * RobotTry - a robot by (your name here)
 */
public class RobotTry extends AdvancedRobot
{
    int moveDirection=1;
	
	 public void run() {
        setAdjustRadarForRobotTurn(true);
        setAdjustGunForRobotTurn(true); 
        turnRadarRightRadians(Double.POSITIVE_INFINITY);
    }

    
    public void onScannedRobot(ScannedRobotEvent e) {
        double absBearing=e.getBearingRadians()+getHeadingRadians();
        double latVel=e.getVelocity() * Math.sin(e.getHeadingRadians() -absBearing);
        double gunTurnAmt;
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
        if(Math.random()>.9){
            setMaxVelocity((12*Math.random())+12);
        }
        if (e.getDistance() > 150) {
            gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing- getGunHeadingRadians()+latVel/22);//amount to turn our gun, lead just a little bit
            setTurnGunRightRadians(gunTurnAmt);
            setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(absBearing-getHeadingRadians()+latVel/getVelocity()));//drive towards the enemies predicted future location
            setAhead((e.getDistance() - 140)*moveDirection);
            setFire(3);//fire
        }
        else{
            gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing- getGunHeadingRadians()+latVel/15);//amount to turn our gun, lead just a little bit
            setTurnGunRightRadians(gunTurnAmt);
            setTurnLeft(-90-e.getBearing()); 
            setAhead((e.getDistance() - 140) * moveDirection);
            setFire(3);//fire
        }
    }
    public void onHitWall(HitWallEvent e){
        moveDirection = -moveDirection;
    }
    
}
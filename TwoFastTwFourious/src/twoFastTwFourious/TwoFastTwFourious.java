package twoFastTwFourious;
import robocode.*;

public class TwoFastTwFourious extends AdvancedRobot
{
	int moveDirection=1;
	public void run()
	{
		while (true)
		{
			//setAhead(400);
			turnGunRight(360);
			setTurnRight(90);
			waitFor(new TurnCompleteCondition(this));
			setTurnLeft(90);
			turnGunRight(360);
			waitFor(new TurnCompleteCondition(this));
			setTurnRight(90);
			waitFor(new TurnCompleteCondition(this));
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
	    if(e.getDistance() < 150)
	    {
	    	setAhead((e.getDistance() - 140)*moveDirection);
	    	setFire(3);
	    }else
	    {
	    	setAhead((e.getDistance() - 140)*moveDirection);
	    	setFire(1);
	    }
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
        back(40);
    }
	
	public void onHitWall(HitWallEvent e){
        moveDirection=-moveDirection;
    }
}

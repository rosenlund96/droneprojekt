package test;

import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
import de.yadrone.base.command.LEDAnimation;

public class ConnectionTest {

	public static void main(String[] args)
	{
	    IARDrone drone = null;
	    try
	    {
	        drone = new ARDrone();
	        drone.start();
	        drone.getCommandManager().setLedsAnimation(LEDAnimation.SNAKE_GREEN_RED, 10, 2);
	        System.out.println("Der blev oprettet forbindelse til dronen, og LED animationen blev kørt");
	    }
	    catch (Exception exc)
		{
	    	System.out.println("Der skete en fejl:");
			exc.printStackTrace();
		}
		finally
		{
			if (drone != null)
				drone.stop();
			System.exit(0);
		}
	}
}

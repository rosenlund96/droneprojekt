package test;

import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;

public class ControlTest {

	public static void main(String[] args)
	{
	    IARDrone drone = null;
	    try
	    {
	        drone = new ARDrone();
	        drone.start();
	        drone.getCommandManager().takeOff();
	        drone.getCommandManager().waitFor(5000);
	        drone.getCommandManager().landing();
	        System.out.println("Der er fuld kontrol over dronen");
	    }
	    catch (Exception exc)
		{
	    	System.out.println("Der er delvist kontrol over dronen. Er dronen i emergency mode?");
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

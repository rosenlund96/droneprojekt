package test;

import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
import de.yadrone.base.navdata.BatteryListener;

public class ListenerTest {

	
	public static void main(String[] args)
	{
	    IARDrone drone = null;
	    try
	    {
	        drone = new ARDrone();
	        drone.start();
	        drone.getNavDataManager().addBatteryListener(new BatteryListener(){

				@Override
				public void batteryLevelChanged(int arg0) {
					System.out.println("Batteriniveau: " + arg0 + " %");
					
				}

				@Override
				public void voltageChanged(int arg0) {
					System.out.println("Batterispænding: " + arg0 + " %");
					
				}
	        	
	        });
	    }
	    catch (Exception exc)
		{
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

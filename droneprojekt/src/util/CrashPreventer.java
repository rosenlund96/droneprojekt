package util;

import de.yadrone.base.IARDrone;
import de.yadrone.base.navdata.BatteryListener;
import de.yadrone.base.navdata.WifiListener;

public class CrashPreventer {

	
	public CrashPreventer (IARDrone drone){
		
		drone.getNavDataManager().addWifiListener(new WifiListener(){

			@Override
			public void received(long arg0) {
				if(arg0 == 0){
					drone.getCommandManager().landing();
				}
				
			}
			
		});
		
		drone.getNavDataManager().addBatteryListener(new BatteryListener(){

			@Override
			public void batteryLevelChanged(int arg0) {
				if(arg0 < 5){
					System.out.println("Batteriniveau under 5%");
					drone.getCommandManager().landing();
				}
				
			}

			@Override
			public void voltageChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}

package test;

import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
import de.yadrone.base.exception.ARDroneException;
import de.yadrone.base.exception.IExceptionListener;
import de.yadrone.base.video.ImageListener;
import util.VideoUtil;

public class VideoTester {

	public static void main(String[] args)
	{
		IARDrone drone = null;
		try
		{
		
			drone = new ARDrone();
			drone.addExceptionListener(new IExceptionListener() {
				public void exeptionOccurred(ARDroneException exc)
				{
					exc.printStackTrace();
				}
			});
			
			drone.start();
			
			
			
        new VideoUtil(drone);
			
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

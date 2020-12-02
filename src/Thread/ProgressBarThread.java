package Thread;

import GUI.SkyMarketGUI;
import Model.ProgressBar;
import javafx.application.Platform;


public class ProgressBarThread extends Thread{

	
	private ProgressBar pb;
	private SkyMarketGUI gui;

	
	public ProgressBarThread(ProgressBar bar, SkyMarketGUI sky) {
		pb = bar;
		gui=sky;
	}
	
	public void run() {
		while (pb.isActive()) {
			pb.advance();
			Platform.runLater(new Thread() {
				public void run() {
					gui.updateBar();
				}
			});
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
	}
}

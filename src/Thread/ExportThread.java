package Thread;

import java.io.FileNotFoundException;

import Model.SkyMarket;

public class ExportThread extends Thread{

	private SkyMarket sm;
	
	public ExportThread(SkyMarket sm) {
		this.sm = sm;
	}
	
	public void run() {
		try {
			sm.exportDataArticles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

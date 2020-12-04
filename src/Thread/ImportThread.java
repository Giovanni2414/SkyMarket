package Thread;

import java.io.IOException;

import Model.SkyMarket;

public class ImportThread extends Thread{

	private SkyMarket sm;
	
	public ImportThread(SkyMarket sm) {
		this.sm = sm;
	}
	
	public void run() {
		try {
			sm.importDataArticles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

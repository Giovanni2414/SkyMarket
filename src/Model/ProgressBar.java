package Model;

public class ProgressBar {
	
	
		public final static int MAX = 300;
		private int progressLevel;
		private boolean active;
		public ProgressBar() {
			progressLevel = 0;
			active = true;
		}
		
		public int getProgressLevel() {
			return progressLevel;
		}
		
		public void advance() {
			if(progressLevel>=MAX) {
				active = false;
			}else {			
				progressLevel++;
			}
		}
		
		public void setActive(boolean act) {
			active = act;
		}
		
		public boolean isActive() {
			return active;
		}
	

}

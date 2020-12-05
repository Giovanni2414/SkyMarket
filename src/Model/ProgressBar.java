package Model;

public class ProgressBar {
	
		/**
		 * This is until where the progressBar will move
		 */
		public final static int MAX = 300;
		
		/**
		 * The actual level of the progressBar
		 */
		private int progressLevel;
		
		/**
		 * If the ProgressBar is active or not
		 */
		private boolean active;
		
		/**
		 * Constructor of ProgressBar class
		 * <br><b>Pre:</b> 
		 * <br><b>Post: All variables will be initializated</b> 
		 */
		public ProgressBar() {
			progressLevel = 0;
			active = true;
		}
		
		/**
		 * Getter of progressLevel
		 * <br><b>Pre: The variable must be initializated</b>
		 * <br><b>Post:</b>  
		 * @return Return the actual level from the progress bar
		 */
		public int getProgressLevel() {
			return progressLevel;
		}
		
		/**
		 * Method to advance the progressLevel on the bar
		 * <br><b>Pre: The bar will be initializated</b>
		 * <br><b>Post:</b>  
		 */
		public void advance() {
			if(progressLevel>=MAX) {
				active = false;
			}else {			
				progressLevel++;
			}
		}
		
		/**
		 * Setter of Active
		 * <br><b>Pre:</b> 
		 * <br><b>Post: A new status of Active will be setter</b> 
		 * @param act The new status of active in boolean
		 */
		public void setActive(boolean act) {
			active = act;
		}
		
		/**
		 * Getter of Active
		 * <br><b>Pre: The variable will be initializated</b>
		 * <br><b>Post:</b>  
		 * @return If the bar is active or not
		 */
		public boolean isActive() {
			return active;
		}
	

}

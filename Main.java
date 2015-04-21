package ASRS;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Main {
	
		public static void main(String[] args) throws Exception{
			
			//Hoofdscherm openen
			Scherm scherm = new Scherm();
			scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			scherm.setVisible(true);
			
			// File Explorerer settings
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			
			
	        
	        
	        
			
		}

		
	}


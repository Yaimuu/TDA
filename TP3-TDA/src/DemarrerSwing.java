import javax.swing.*;

public class DemarrerSwing 
{
	public static void main(String args[])
	{
		CadreTDA cadre = new CadreTDA();
		
		SwingUtilities.invokeLater(new Runnable() 
	    {
	        public void run() 
	        {
	            cadre.run();
	        }
	    });
		
		PanneauCentral panneauCentral  = new PanneauCentral();
		PanneauPrincipal principal = new PanneauPrincipal();
		
	}
}

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
		
	}
}

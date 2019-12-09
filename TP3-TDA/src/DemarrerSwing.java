import javax.swing.*;

public class DemarrerSwing 
{
	static CadreTDA cadre = new CadreTDA();
	
	public static void main(String args[])
	{
		
		SwingUtilities.invokeLater(new Runnable() 
	    {
	        public void run() 
	        {
	            cadre.run();
	        }
	    });
		
	}
}

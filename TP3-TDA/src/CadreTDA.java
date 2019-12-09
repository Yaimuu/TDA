import javax.swing.*;

public class CadreTDA implements Runnable
{
	int[] size;
	private JFrame frame = new JFrame();
	
	private BarreMenu menu;
	private PanneauCentral panneauCentral;
	
	@Override
	public void run() 
	{
		size = new int[2];
		size[0] = 1000;
		size[1] = 500;
		
		menu = new BarreMenu();
		panneauCentral = new PanneauCentral();
		
		frame.setSize(size[0],size[1]);
		//using no layout managers
		frame.setLayout(null);
		//making the frame visible
		frame.setVisible(true);
		
		frame.setMenuBar(menu);
		
		frame.add(panneauCentral);
	}
	
}

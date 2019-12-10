import javax.swing.*;

public class CadreTDA implements Runnable
{
	int[] size;
	public static JFrame frame = new JFrame();
	
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
		Liste liste = new Liste(1);
		liste.ajoute(1);
		liste.ajoute(2);
		liste.ajoute(4);
		liste.ajoute(1);
		
		
		frame.setSize(size[0],size[1]);
		//using no layout managers
		frame.setLayout(null);
		//making the frame visible
		frame.setVisible(true);
		try {
			panneauCentral.afficherTDA(liste);
		} catch (TDAVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menu.setTDA(liste);
		
		//frame.setMenuBar(menu);
		
		//frame.add(panneauCentral);
		frame.validate();
		frame.repaint();
	}
	
}

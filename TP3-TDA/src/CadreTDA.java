import javax.swing.*;

public class CadreTDA implements Runnable
{
	int[] size;
	public static JFrame frame = new JFrame();
	
	public BarreMenu menu;
	public PanneauCentral panneauCentral;
	public PanneauPrincipal panneauPrincipal;
	
	@Override
	public void run() 
	{
		size = new int[2];
		size[0] = 1000;
		size[1] = 500;
		
		menu = new BarreMenu();
		panneauCentral = new PanneauCentral();
		panneauPrincipal = new PanneauPrincipal();
		
		
		Liste liste = new Liste(1);
		liste.ajoute(1);
		liste.ajoute(2);
		liste.ajoute(4);
		liste.ajoute(1);
		
		panneauPrincipal.setTDA(liste);
		panneauPrincipal.initComposants();
		
		frame.setSize(size[0],size[1]);
		//using no layout managers
		frame.setLayout(null);
		//making the frame visible
		frame.setVisible(true);
		try 
		{
			panneauCentral.afficheTDA(liste);
		} 
		catch (TDAVideException e) 
		{
			e.printStackTrace();
		}
		
		
		menu.setTDA(liste);
		
		panneauCentral.setSize(frame.getWidth(), frame.getHeight());
		panneauPrincipal.setSize(frame.getWidth(), frame.getHeight());
		
		frame.add(panneauCentral);
		frame.add(panneauPrincipal);
		//frame.setMenuBar(menu);
		
		//frame.add(panneauCentral);
		frame.validate();
		frame.repaint();
	}
	
}

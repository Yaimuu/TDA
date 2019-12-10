import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
		size[0] = 1240;
		size[1] = 720;
		
		
		panneauCentral = new PanneauCentral();
		panneauPrincipal = new PanneauPrincipal();
		menu = new BarreMenu(panneauPrincipal);
		panneauCentral.initComposants();
		panneauPrincipal.central = panneauCentral;
		
		panneauPrincipal.setTDA(new Liste(0));
		try {
			panneauPrincipal.central.afficheTDA(panneauPrincipal.getTDA());
		} catch (TDAVideException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		frame.setSize(size[0],size[1]);
		//using no layout managers
		frame.setLayout(new FlowLayout());
		
		//making the frame visible
		frame.setVisible(true);
		frame.addWindowListener(new MyWindowListener());
		
		menu.setTDA(new Liste(0));
		
		//panneauCentral.setSize(size[0],size[1]);
		//panneauPrincipal.setSize(size[0],size[1]);
		
		//panneauPrincipal.central.panel.setSize(panneauCentral.getSize().width - 250, panneauCentral.getSize().height - 150);
		//panneauPrincipal.central.panel.setLocation(panneauCentral.getSize().width/4 - 125, 0);
		panneauPrincipal.initComposants();
		frame.add(panneauPrincipal);
		frame.setJMenuBar(menu);
		
		frame.validate();
		frame.repaint();
	}
	
	private class MyWindowListener implements WindowListener 
	{
		public void windowActivated(WindowEvent event) {}
		
		public void windowDeactivated(WindowEvent event) {}
		
		public void windowClosing(WindowEvent event) 
		{
			System.exit(0);
		}
		
		public void windowClosed(WindowEvent event) {}
		
		public void windowIconified(WindowEvent event) {}
		
		public void windowDeiconified(WindowEvent event) {}
		
		public void windowOpened(WindowEvent event) {}
	}
	
}

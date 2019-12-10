import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class CadreTDA implements Runnable
{
	int[] size;
	public JFrame frame = new JFrame();
	
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
		
		InterfaceTDA tda = new Liste(1);
		tda.ajoute(1);
		tda.ajoute(2);
		tda.ajoute(4);
		tda.ajoute(1);
		
		
		panneauPrincipal.setTDA(tda);
		panneauPrincipal.initComposants();
		
		frame.setSize(size[0],size[1]);
		//using no layout managers
		frame.setLayout(new FlowLayout());
		//making the frame visible
		frame.setVisible(true);
		frame.addWindowListener(new MyWindowListener());
		
		try 
		{
			panneauCentral.afficheTDA(tda);
		} 
		catch (TDAVideException e) 
		{
			e.printStackTrace();
		}
		
		menu.setTDA(tda);
		
		//panneauCentral.setSize(size[0],size[1]);
		panneauPrincipal.setSize(size[0],size[1]);
		
		//panneauCentral.panel.setSize(panneauCentral.getSize().width - 250, panneauCentral.getSize().height - 150);
		//panneauCentral.panel.setLocation(panneauCentral.getSize().width/4 - 125, 0);
		
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

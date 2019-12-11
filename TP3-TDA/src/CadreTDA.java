import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class CadreTDA implements Runnable
{
	int[] size;
	public JFrame frame = new JFrame();
	
	public BarreMenu menu;
	public PanneauPrincipal panneauPrincipal;
	
	
	@Override
	public void run() 
	{
		size = new int[2];
		size[0] = 1240;
		size[1] = 720;
		
		panneauPrincipal = new PanneauPrincipal();
		menu = new BarreMenu(panneauPrincipal);
		
		InterfaceTDA defaultTDA = new Pile();
		
		panneauPrincipal.setTDA(defaultTDA);
		panneauPrincipal.initComposants();
		
		try
		{
			panneauPrincipal.central.afficheTDA(defaultTDA);
		} 
		catch (TDAVideException e1)
		{
			e1.printStackTrace();
		}
		
		frame.setSize(size[0],size[1]);
		//using no layout managers
		frame.setLayout(new FlowLayout());
		
		//making the frame visible
		frame.setVisible(true);
		frame.addWindowListener(new MyWindowListener());
		
		menu.setTDA(defaultTDA);
		
		panneauPrincipal.setPreferredSize(new Dimension(size[0],size[1]));
		
		panneauPrincipal.setBackground(Color.white);
		
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

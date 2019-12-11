import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
/**
 * Classe CadreTDA, elle permet d'initialiser la fenêtre, ainsi que les éléments affichés
 * sur celle-ci
 *
 * @author Yanis Ouled Moussa, Justin Garcia
 * @version automne 2019
 */
public class CadreTDA implements Runnable
{
	int[] size;
	public JFrame frame = new JFrame();
	
	public BarreMenu menu;
	public PanneauPrincipal panneauPrincipal;
	
	// Fonction qui est appellée au lancement de la fenêtre
	@Override
	public void run() 
	{
		// Taille de la fenêtre
		size = new int[2];
		size[0] = 1240;
		size[1] = 720;
		
		// Création du Panneau Principal
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
		// Utilisation du FlowLayout par défaut
		frame.setLayout(new FlowLayout());
		
		// On rend la fenêtre visible
		frame.setVisible(true);
		frame.addWindowListener(new MyWindowListener());
		
		menu.setTDA(defaultTDA);
		
		panneauPrincipal.setPreferredSize(new Dimension(size[0],size[1]));
		
		panneauPrincipal.setBackground(Color.white);
		
		
		frame.add(panneauPrincipal);
		surprise();
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
	
	private void surprise()
	{
		JLabel MasahiroSakurai = new JLabel("Test");
		MasahiroSakurai.setText("<html><body style=\"width:500px;height:300px;background:url('https://scontent.fymy1-2.fna.fbcdn.net/v/t1.0-9/78588680_463169647935841_1782314949989629952_n.jpg?_nc_cat=106&_nc_ohc=nG9lSXZ1fS8AQniifmIEhmyHEpev7_E-AKHw1Eycpwb3HlijxBjG6zaGA&_nc_ht=scontent.fymy1-2.fna&oh=ab8de5625cc6d6a6ef8f77115f4fa15f&oe=5E68C57B');\"></body></html>");
		frame.add(MasahiroSakurai);
	}
}

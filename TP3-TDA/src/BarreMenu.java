import java.awt.MenuBar;

import javax.swing.*;

public class BarreMenu extends MenuBar
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JMenuBar menu = new JMenuBar();
	
	public void setTDA(InterfaceTDA tda)
	{
		JMenu menuSlot = new JMenu("Menu typde de TDA");
		this.menu.add(menuSlot);
		JMenuItem pile = new JMenuItem("Pile");
		JMenuItem file = new JMenuItem("File");
		JMenuItem liste = new JMenuItem("Liste");
		menuSlot.add(pile);
		menuSlot.add(file);
		menuSlot.add(liste);
		CadreTDA.frame.setJMenuBar(menu);
		CadreTDA.frame.validate();
		CadreTDA.frame.repaint();
		
	}
	
}

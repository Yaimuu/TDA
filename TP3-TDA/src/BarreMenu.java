import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BarreMenu extends JMenuBar
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanneauPrincipal panneauPrincipal;
	
	public BarreMenu(PanneauPrincipal panneauPrincipal)
	{
		this.panneauPrincipal = panneauPrincipal;
	}
	
	public void setTDA(InterfaceTDA tda)
	{
		MyActionListener myActionListener = new MyActionListener();
		JMenu menuSlot = new JMenu("Menu typde de TDA");
		this.add(menuSlot);
		
		JMenuItem pile = new JMenuItem("Pile");
		pile.addActionListener(myActionListener);
		JMenuItem file = new JMenuItem("File");
		file.addActionListener(myActionListener);
		JMenuItem liste = new JMenuItem("Liste");
		liste.addActionListener(myActionListener);
		
		menuSlot.add(pile);
		menuSlot.add(file);
		menuSlot.add(liste);
		
	}
	
	class MyActionListener implements ActionListener 
	{  
		public void actionPerformed(ActionEvent e) 
	    { 
	        String s = e.getActionCommand(); 
	        System.out.println(s);
	        switch(s)
	        {
		        case "Pile" :
		        	panneauPrincipal.setTDA(new Pile());
		        	break;
		        case "File" :
		        	panneauPrincipal.setTDA(new File());
		        	break;
		        case "Liste" :
		        	panneauPrincipal.setTDA(new Liste(0));
		        	break;
	        }
	        try {
				panneauPrincipal.central.afficheTDA(panneauPrincipal.getTDA());
			} catch (TDAVideException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        validate();
	        repaint();
	    }
	}
}

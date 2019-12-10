import java.awt.Component;

import javax.swing.*;

public class PanneauIterateurs extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton debutBouton;
	private JButton avantBouton;
	private JButton apresBouton;
	private JButton finBouton;
	private JComboBox<String> ordreCB;
	
	private PanneauCentral panneauCentral;
	
	private InterfaceTDA tda;

	public PanneauIterateurs(InterfaceTDA tda, PanneauCentral panneauCentral) 
	{
		this.tda = tda;
		this.panneauCentral = panneauCentral;
		initComposants();
	}

	public void setTda(InterfaceTDA tda) 
	{
		this.tda = tda;
	}
	
	public void initComposants()
	{
		removeAll();
		if(tda.getId() == "Liste")
		{
			String[] itemsCB = {"Avant", "Après"};
		
			debutBouton = new JButton("|<");
			debutBouton.setSize(150, 50);
			
			finBouton = new JButton(">|");
			finBouton.setSize(150, 50);
			
			avantBouton = new JButton("<<");
			avantBouton.setSize(150, 50);
			
			apresBouton = new JButton(">>");
			apresBouton.setSize(150, 50);
			
			ordreCB = new JComboBox<String>(itemsCB);
			ordreCB.setSize(150, 50);
			
			add(debutBouton);
			add(finBouton);
			add(avantBouton);
			add(apresBouton);
			add(ordreCB);
			
			validate();
			repaint();
		}
	}

}

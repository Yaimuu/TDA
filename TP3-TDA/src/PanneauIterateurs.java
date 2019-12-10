import java.awt.Component;

import javax.swing.*;

public class PanneauIterateurs extends Component
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton debutBouton;
	private JButton avantBouton;
	private JButton apresBouton;
	private JButton finBouton;
	private JComboBox ordreCB;
	
	private PanneauCentral panneauCentral = new PanneauCentral();
	
	private InterfaceTDAIterateur tda;

	public PanneauIterateurs(InterfaceTDA tda, PanneauCentral panneauCentral) 
	{
		// TODO Auto-generated constructor stub
	}

	public void setTda(InterfaceTDA tda) 
	{
		debutBouton = new JButton("|<");
		finBouton = new JButton(">|");
		avantBouton = new JButton("<<");
		apresBouton = new JButton(">>");
		ordreCB = new JComboBox();
		
		
	}

}

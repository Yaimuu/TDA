import java.awt.Component;

import javax.swing.*;

public class PanneauIterateurs extends Component
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton debut;
	private JButton avant;
	private JButton apres;
	private JButton fin;
	private JComboBox ordre;
	
	private PanneauCentral panneauCentral = new PanneauCentral();
	
	private InterfaceTDAIterateur tda;

	public PanneauIterateurs(InterfaceTDA tda, PanneauCentral panneauCentral) 
	{
		// TODO Auto-generated constructor stub
	}

	public void setTda(InterfaceTDA tda) 
	{
		// TODO Auto-generated method stub
		
	}

}

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;  

public class PanneauPrincipal extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanneauNbElements nbElements;
	public PanneauCentral central;
	public PanneauOrientation orientation;
	public PanneauBoutonsDuBas boutonsDuBas;
	
	private InterfaceTDA tda;
	
	public void initComposants()
	{
		nbElements = new PanneauNbElements();
		
		central = new PanneauCentral();
		central.setBackground(Color.orange);
		central.setPreferredSize(new Dimension(750, 400));
		central.initComposants();
		orientation = new PanneauOrientation(central);
		
		boutonsDuBas = new PanneauBoutonsDuBas(this.tda, central, nbElements);
		
		
		add(nbElements);
		add(central);
		add(orientation);
		add(boutonsDuBas);
	}
	
	public void setTDA(InterfaceTDA tda)
	{
		this.tda = tda;
		if(boutonsDuBas != null)
		{
			try 
			{
				boutonsDuBas.setTDA(tda);
			} 
			catch (TDAVideException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public InterfaceTDA getTDA() 
	{
		return this.tda;
	}
}

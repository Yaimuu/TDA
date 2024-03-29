import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;  
/**
 * Classe Panneau Principal, c'est le panneau principale de l'application
 *
 * @author Yanis Ouled Moussa, Justin Garcia
 * @version automne 2019
 */
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
	
	
	/*
	 * Initialisation des composants du PanneauPrincipal
	 * */
	public void initComposants()
	{
		nbElements = new PanneauNbElements();
		nbElements.setNbElements(tda.getNbElements());
		
		central = new PanneauCentral();
		central.setBackground(Color.orange);
		central.setPreferredSize(new Dimension(800, 400));
		central.initComposants();
		
		orientation = new PanneauOrientation(central);
		
		boutonsDuBas = new PanneauBoutonsDuBas(this.tda, central, nbElements);
		
		add(nbElements);
		add(central);
		add(orientation);
		add(boutonsDuBas);
	}
	
	/*
	 * Définition du this.tda pour qu'il soit égale au TDA passé en paramètre
	 * */
	public void setTDA(InterfaceTDA tda)
	{
		this.tda = tda;
		
		if(boutonsDuBas != null)
		{
			nbElements.setNbElements(tda.getNbElements());
			try 
			{
				boutonsDuBas.setTDA(tda);
				boutonsDuBas.mettreAJour();
				
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

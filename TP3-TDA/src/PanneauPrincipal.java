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
	}
	
	public InterfaceTDA getTDA() {
		return this.tda;
	}
}

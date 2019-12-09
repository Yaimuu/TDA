import javax.swing.*;

public class PanneauCentral extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void changeOrientation() 
	{
		// TODO Auto-generated method stub
		
	}

	public void afficheTDA(InterfaceTDA tda) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void afficherTDA(InterfaceTDA tda) throws TDAVideException
	{
		removeAll();
		if(tda.estVide())
		{
			JButton vide = new JButton(tda.getId() + "est vide !");
		}
		else
		{
			Object[] contenuTDA = tda.toArray();
			int pos = tda.getPosition();
			int nbElements = tda.getNbElements();
			
			for(int i = 0; i < contenuTDA.length; i++)
			{
				JButton element = new JButton(tda.getElement().toString());
				if(contenuTDA.length == 1)
				{
					
				}
				else
				{
					
				}
			}
		}
	}
}

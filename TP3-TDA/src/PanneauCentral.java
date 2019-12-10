import java.awt.Color;

import javax.swing.*;

public class PanneauCentral extends JPanel
{
	/**
	 * 
	 */
	//private JFrame frame;
	private static final long serialVersionUID = 1L;
	
	public PanneauCentral() 
	{
		initComposants();
	}
	
	public JLabel nbItems;
	public JPanel panel;
	
	public void changeOrientation(String orientation) 
	{
		System.out.println(getLayout());
		if(orientation== "Portrait") {
			BoxLayout layout = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
			this.panel.setLayout(layout);
		}else {
			BoxLayout layout = new BoxLayout(this.panel, BoxLayout.X_AXIS);
			this.panel.setLayout(layout);
		}
		validate();
		repaint();
	}
	
	public void initComposants()
	{
		/*this.nbItems = new JLabel();
		//nbItems.setText("<html><body style=\"width:500px;height:500px;text-align: center;background: url('https://i.ytimg.com/vi/s7bl9YyoFtw/hqdefault.jpg');background-position: center;\"></body></html>");
		this.nbItems.setText("<html><body style=\"text-align: center;\"><p>Nombre d'éléments :</p><p>" + tda.getNbElements() + "</p></body></html>");
		this.nbItems.setSize(150, 30);
		
		add(this.nbItems);*/
		//System.out.println("width : " + this.getSize().width + " - height : " + this.getSize().height);
		this.panel = new JPanel();
		this.panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		/*BoxLayout layout = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);*/
		add(this.panel);
	}
	
	public void afficheTDA(InterfaceTDA tda) throws TDAVideException
	{
		removeAll();
		
		this.panel.removeAll();
		JButton element;
		
		if(tda.getId() == "Liste") 
		{
			((Liste) tda).setPcDebut();
		}
		
		if(tda.estVide())
		{
			element = new JButton(tda.getId() + " est vide !");
			element.setSize(150, 50);
			this.panel.add(element);
		}
		else
		{
			Object[] contenuTDA = tda.toArray();
			int pos = tda.getPosition();
			int nbElements = tda.getNbElements();
			
			for(int i = 0; i < contenuTDA.length; i++)
			{
				element = new JButton(tda.getElement().toString());
				if(contenuTDA.length == 1)
				{
					element.setBackground(Color.orange);
					element.setText(element.getText() + " Element unique");
				}
				else 
				{
					if(tda.getPosition() == 0)
					{
						element.setBackground(Color.lightGray);
						element.setText(element.getText() + " Debut");
					}
					else if(tda.getPosition() == tda.getNbElements()-1)
					{
						element.setBackground(Color.red);
						element.setText(element.getText() + " Fin");
					}
				}
				element.setSize(150, 50);
				if(pos == i) 
				{
					element.setBackground(Color.yellow);
				}
				element.setLocation(0, 50*i);
				this.panel.add(element);
				
				if(tda.getId() == "Liste") 
				{
					((Liste) tda).setPcSuivant();
				}
			}
		}
		add(this.panel);
		validate();
		repaint();
	}
}

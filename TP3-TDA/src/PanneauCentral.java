import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

public class PanneauCentral extends JPanel
{
	/**
	 * 
	 */
	//private JFrame frame;
	int orientation = 0;
	private static final long serialVersionUID = 1L;
	
	/*public void PanneauCentral(JFrame fFrame) {
		this.frame = fFrame;
	}*/
	
	public JLabel nbItems;
	public JPanel panel;
	
	public void changeOrientation() 
	{
		if(orientation == 1) {
			BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
			setLayout(layout);
			
		}else {
			BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
			setLayout(layout);
		}
		validate();
		repaint();
	}
	
	public void afficheTDA(InterfaceTDA tda) throws TDAVideException
	{
		removeAll();
		
		this.nbItems = new JLabel();
		//nbItems.setText("<html><body style=\"width:500px;height:500px;text-align: center;background: url('https://i.ytimg.com/vi/s7bl9YyoFtw/hqdefault.jpg');background-position: center;\"></body></html>");
		this.nbItems.setText("<html><body style=\"text-align: center;\"><p>Nombre d'éléments :</p><p>" + tda.getNbElements() + "</p></body></html>");
		this.nbItems.setSize(150, 30);
		
		add(this.nbItems);
		
		this.panel = new JPanel();
		this.panel.setSize(CadreTDA.frame.getSize().width - 250, CadreTDA.frame.getSize().height - 150);
		this.panel.setLocation(CadreTDA.frame.getSize().width/4 - 125, 0);
		this.panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		if(tda.getId() == "Liste") 
		{
			((Liste) tda).setPcDebut();
		}
		
		
		
		if(tda.estVide())
		{
			JButton vide = new JButton(tda.getId() + " est vide !");
			vide.setSize(150, 50);
			this.panel.add(vide);
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
					element.setBackground(Color.orange);
					element.setText(element.getText() + " Element unique");
				}else {
					//System.out.println(tda.getElement());
					if(tda.getPosition() == 0)
					{
						element.setBackground(Color.lightGray);
						element.setText(element.getText() + " Debut");
					}else if(tda.getPosition() == tda.getNbElements()-1){
						element.setBackground(Color.red);
						element.setText(element.getText() + " Fin");
					}
				}
				element.setSize(150, 50);
				if(pos == i) {
					element.setBackground(Color.yellow);
				}
				element.setLocation(0, 50*i);
				this.panel.add(element);
				if(tda.getId() == "Liste") {
					((Liste) tda).setPcSuivant();
				}else {
					//((Liste) tda).setPcSuivant();
				}
			}
		}
		add(this.panel);
		validate();
		repaint();
	}
}

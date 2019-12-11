import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
/**
 * Classe Panneau Central, c'est le panneau dans lequel sont affiché les listes
 *
 * @author Yanis Ouled Moussa, Justin Garcia
 * @version automne 2019
 */
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
	
	/*
	 * On change l'orientation du panneauCentral en fonction du string reçu en paramètre
	 * qui correspond au bouton radio coché
	 * */
	public void changeOrientation(String orientation) 
	{
		System.out.println(getLayout());
		
		if(orientation == "Portrait") 
		{
			BoxLayout layout = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
			this.panel.setLayout(layout);
		}
		else 
		{
			BoxLayout layout = new BoxLayout(this.panel, BoxLayout.X_AXIS);
			this.panel.setLayout(layout);
		}
		
		validate();
		repaint();
	}
	
	// Initialisation des composants de PanneauCentral
	public void initComposants()
	{
		this.panel = new JPanel();
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		this.panel.setBackground(Color.orange);
		add(this.panel);
		validate();
		repaint();
	}
	
	/*
	 * Méthode permettant d'afficher les éléments du TDA dans le panneauCentral,
	 * en fonction de leur type (Liste, File, ou Pile)
	 * On gére également les couleurs en fonctions de la position du curseur, du début et de la fin
	 * */
	public void afficheTDA(InterfaceTDA tda) throws TDAVideException
	{
		removeAll();
		
		this.panel.removeAll();
		JButton element;
		
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
			//System.out.println(pos);
			if(tda.getId() == "Liste")
			{
				((Liste) tda).setPcDebut();
			}
			
			for(int i = 0; i < contenuTDA.length; i++)
			{
				if(tda.getId() == "Liste") {
					
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
					
					((Liste) tda).setPcSuivant();
				}else if(tda.getId() == "File") {
					element = new JButton("" + (tda.getNbElements() - (i+1) ) );
					if(contenuTDA.length == 1)
					{
						element.setBackground(Color.orange);
						element.setText(element.getText() + " Element unique");
					}
					else 
					{
						if(i == 0)
						{
							element.setBackground(Color.lightGray);
							element.setText(element.getText() + " Debut");
						}
					}
					element.setSize(150, 50);
					if(i == tda.getNbElements()-1) 
					{
						element.setBackground(Color.yellow);
					}
					element.setLocation(0, 50*i);
					this.panel.add(element);
				}else if(tda.getId() == "Pile") {
					element = new JButton("" + i);
					if(contenuTDA.length == 1)
					{
						element.setBackground(Color.orange);
						element.setText(element.getText() + " Element unique");
					}
					else 
					{
						if(i == 0)
						{
							element.setBackground(Color.lightGray);
							element.setText(element.getText() + " Debut");
						}
					}
					element.setSize(150, 50);
					if(i == 0) 
					{
						element.setBackground(Color.yellow);
					}
					element.setLocation(0, 50*i);
					this.panel.add(element);
				}
				
			}
		}
		add(this.panel);
		validate();
		repaint();
	}
}

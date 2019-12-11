import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanneauIterateurs extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton boutonDebut;
	private JButton boutonPrecedent;
	private JButton boutonSuivant;
	private JButton boutonFin;
	private JComboBox<String> comboBoxMode;
	
	private PanneauCentral panneauCentral;
	
	private InterfaceTDA tda;
	
	private boolean isIterratorShowed;
	
	public PanneauIterateurs(InterfaceTDA tda, PanneauCentral panneauCentral) 
	{
		this.tda = tda;
		this.panneauCentral = panneauCentral;
		isIterratorShowed = false;
		initComposants();
	}

	public void setTda(InterfaceTDA tda) 
	{
		this.tda = tda;
		//System.out.println(tda.getId());
		removeAll();
		if(this.tda.getId() == "Liste")
		{
			mettreAJour();
		}
		else
		{
			isIterratorShowed = false;
		}
	}
	
	public void initComposants()
	{
		removeAll();
		if(tda.getId() == "Liste")
		{
			mettreAJour();
		}
	}
	
	public void mettreAJour()
	{
		System.out.print("Vrai tda : " + ((Liste)tda).getPosition() + "\n");
		try 
		{
			panneauCentral.afficheTDA(tda);
		} 
		catch (TDAVideException e) 
		{
			e.printStackTrace();
		}
		
		if(!isIterratorShowed)
		{
			String[] itemsCB = {"Avant", "Après"};
			
			boutonDebut = new JButton("|<");
			boutonDebut.setSize(150, 50);
			
			boutonFin = new JButton(">|");
			boutonFin.setSize(150, 50);
			
			boutonPrecedent = new JButton("<<");
			boutonPrecedent.setSize(150, 50);
			
			boutonSuivant = new JButton(">>");
			boutonSuivant.setSize(150, 50);
			
			comboBoxMode = new JComboBox<String>(itemsCB);
			comboBoxMode.setSize(150, 50);
			
			boutonDebut.addActionListener(new EcouteurBoutonDebut());
			boutonFin.addActionListener(new EcouteurBoutonFin());
			boutonSuivant.addActionListener(new EcouteurBoutonSuivant());
			boutonPrecedent.addActionListener(new EcouteurBoutonPrecedent());
			comboBoxMode.addActionListener(new EcouteurComboBoxMode());
			
			add(boutonDebut);
			add(boutonFin);
			add(boutonPrecedent);
			add(boutonSuivant);
			add(comboBoxMode);
			isIterratorShowed = true;
		}
		
		validate();
		repaint();
	}
	
	private class EcouteurBoutonDebut implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// On ajoute dans le tda en mémoire
			// et on met à jour les panneaux.
			((Liste)tda).setPcDebut();
			
			// Important pour que l'ajout dans le TDA se voit à l'écran.
			mettreAJour();
			
		}			
	}
	
	private class EcouteurBoutonFin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// On ajoute dans le tda en mémoire
			// et on met à jour les panneaux.
			((Liste)tda).setPcFin();
			
			// Important pour que l'ajout dans le TDA se voit à l'écran.
			mettreAJour();
		}			
	}
	
	private class EcouteurBoutonSuivant implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// On ajoute dans le tda en mémoire
			// et on met à jour les panneaux.
			((Liste)tda).setPcSuivant();
			// Important pour que l'ajout dans le TDA se voit à l'écran.
			mettreAJour();
		}			
	}
	
	private class EcouteurBoutonPrecedent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// On ajoute dans le tda en mémoire
			// et on met à jour les panneaux.
			System.out.println(tda.getPosition());
			((Liste)tda).setPcPrecedent();
			
			// Important pour que l'ajout dans le TDA se voit à l'écran.
			mettreAJour();
		}			
	}
	
	private class EcouteurComboBoxMode implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// On ajoute dans le tda en mémoire
			// et on met à jour les panneaux.
			if(comboBoxMode.getSelectedItem() == "Avant")
			{
				((Liste)tda).setModeInsertion(0);
			}
			else
			{
				((Liste)tda).setModeInsertion(1);
			}
			
			// Important pour que l'ajout dans le TDA se voit à l'écran.
			mettreAJour();
		}			
	}
	
}

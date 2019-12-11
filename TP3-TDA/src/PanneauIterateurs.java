import java.awt.Component;
import java.awt.Dimension;
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
	private JComboBox<String> ordreCB;
	
	private PanneauCentral panneauCentral;
	
	private InterfaceTDA tda;

	public PanneauIterateurs(InterfaceTDA tda, PanneauCentral panneauCentral) 
	{
		this.tda = tda;
		this.panneauCentral = panneauCentral;
		initComposants();
	}

	public void setTda(InterfaceTDA tda) 
	{
		this.tda = tda;
		//System.out.println(tda.getId());
		removeAll();
		if(tda.getId() == "Liste")
		{
			mettreAJour();
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
	
	@SuppressWarnings("deprecation")
	public void mettreAJour()
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
		
		ordreCB = new JComboBox<String>(itemsCB);
		ordreCB.setSize(150, 50);
		
		boutonDebut.addActionListener(new EcouteurBoutonDebut());
		boutonFin.addActionListener(new EcouteurBoutonFin());
		boutonSuivant.addActionListener(new EcouteurBoutonSuivant());
		boutonPrecedent.addActionListener(new EcouteurBoutonPrecedent());
		
		if(this.countComponents() == 2)
		{
			add(boutonDebut);
			add(boutonFin);
			add(boutonPrecedent);
			add(boutonSuivant);
			add(ordreCB);
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
			((Liste)tda).setPcPrecedent();
			
			// Important pour que l'ajout dans le TDA se voit à l'écran.
			mettreAJour();
		}			
	}
	
}

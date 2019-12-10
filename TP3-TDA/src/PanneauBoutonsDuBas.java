import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panneau contenant les boutons qui permettent les opérations sur les TDA.
 *  
 * (voir énoncé accompagnant ce code)
 * 
 * @author Pierre Bélisle
 * @version Copyright 2019
 */
public class PanneauBoutonsDuBas extends JPanel {
	
	/**
	 * STRATÉGIE : Idéalement, nous utiliserions les classes Observer/Observable
	 *             de java.util et on aurait pas besoin de se 
	 *             préoccuper des mises à jour des autres panneaux.
	 *             
	 *             Comme nous avons subdivisé le panneau TDA en sous panneaux
	 *             dans des classes distinctes (pas en sous classes).  Il faut 
	 *             que le panneau reçoive la référence sur le tda dans lequel 
	 *             il va ajouter ou retirer et aussi le panneau Central et
	 *             le panneau du nombre d'éléments actuellement dans le tda pour 
	 *             le rafraichir.
	 */

	// Sert pour la persistence (enlève un warning).
	private static final long serialVersionUID = 1L;

	// La structure qui contient les éléments.
	InterfaceTDA tda;

	// Boutons pour la gestion des tdas
	private JButton boutonAjoute;
	private JButton boutonRetire;
	
	//Panneau qui contient les boutons de navigation des tdaIterateur.
    private PanneauIterateurs panneauIterateurs;
    
    // Pour rafaichir après un ajout ou un retrait (reçu au constructeur).
    private PanneauCentral panneauCentral;   
    private PanneauNbElements panneauNbElements;

		
	/* Facultatif et parfaitement arbitraire.  Ici,
	  nous voulons des numéros représentant le nombre de clics
	  sur le bouton d'ajout.  Juste pour mettre de chiffres
	  dans les boutons.
	*/
	private static int nbAjouts = 0;

	/**
	 * Initialise le panneau en y incluant les boutons.
     *
	 * @param tda Référence sur le tda à considérer
	 * @param panneauCentral, panneauNbElements seront mis à jour.
	 */
	public PanneauBoutonsDuBas(InterfaceTDA tda, 
			                   PanneauCentral panneauCentral,
			                   PanneauNbElements panneauNbElements){

		// On retient les références dans les instances locales.
		this.tda = tda;
		this.panneauCentral = panneauCentral;
		this.panneauNbElements = panneauNbElements;
		
		// Utilisation d'une procédure locale.
		initComposants();
	}

    /**
     * Procédure locale qui crée les boutons
     * ajoute les écouteurs, initalise le TDA à vide
     * et ajoute les boutons au panneau.
     */
	private void initComposants(){

		boutonAjoute = new JButton("Ajoute");
		boutonRetire = new JButton("Retire");

		boutonAjoute.addActionListener(new EcouteurBoutonAjoute());
		boutonRetire.addActionListener(new EcouteurBoutonRetrait());

		// Ce panneau est crée et apparaît ou non dans le bas
		// si le TDA implémente l'itérateur.
		panneauIterateurs = new PanneauIterateurs(tda, panneauCentral);	
		
		// Par défaut le layout est FlowLayout, on n'y touche pas.
		add(boutonAjoute);
		add(boutonRetire);
		add(panneauIterateurs);
		
	}

	/**
	 * Remet le compteur à vide.
	 */
	public void reset(){
		
		nbAjouts = 0;
		panneauNbElements.setNbElements(tda.getNbElements());
	}

	/**
	 * Modifie la référence sur le tda du panneau.
	 * 
	 * @param tda La référence de remplacement.
	 * @throws TDAVideException 
	 */
	public void setTDA(InterfaceTDA tda) throws TDAVideException{
		
	       this.tda = tda;

	       // On met le panneau iterateurs visible si le tda implémente un 
		   // itérateur.  	       	       
	       panneauIterateurs.setTda(tda);
	       
	       mettreAJour();
	}


	/**
	 * Sous classe privée pour implémenter l'écouteur
	 * du bouton d'ajout.  Il ajoute au tda et gére l'exception
	 * possible.
	 */
	private class EcouteurBoutonAjoute implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// On ajoute dans le tda en mémoire
			// et on met à jour les panneaux.
			tda.ajoute(++nbAjouts);

			// Important pour que l'ajout dans le TDA se voit à l'écran.
			try {
				mettreAJour();
			} catch (TDAVideException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}			
}

	/**
	 * Sous classe privée pour implémenter l'écouteur
	 * du bouton de retrait.
	 */
	private class EcouteurBoutonRetrait implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				tda.supprime();
				
			   
				// Important pour que la suppression dans le TDA 
				// se voit à l'écran.
				mettreAJour();

			}
			
			// La structure est vide.
			catch (Exception e) {			
				JOptionPane.showMessageDialog(null, "Le TDA " + 
			               tda.getId() + " est vide vous ne pouvez retirer");	
			}
		}			
	}

    /*
     * Procédure locale qui met à joueur les 2 autres panneaux liés. 
     */
	public void mettreAJour() throws TDAVideException {	
		
		panneauNbElements.setNbElements(tda.getNbElements());
		try 
		{
			panneauCentral.afficheTDA(tda);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
	    }     		
	}
	
	/**
	 * Remet le panneau du bas dans son état initial avec le nouveau tda.
	 * 
	 * @param tda Le tda que lepanneau central doit afficher.
	 * @throws TDAVideException 
	 */
	public void reinitialiser(InterfaceTDA tda) throws TDAVideException {
		
		   
		   // Remet le compteur d'ajout à 0.
		   reset();
		   		   
		   // Retient le tda reçue.  Important pour que l'ajout et la 
		   // suppression se fasse dans le bon tda.
		   setTDA(tda);
	}
}
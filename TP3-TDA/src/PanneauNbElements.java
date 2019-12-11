import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panneau qui affiche le nombre d'éléments reçu.
 * 
 * Ce panneau doit être mis à jour après chaque opération qui touche le nombre
 * d'élément du tda (setNbElements).
 *  
 * @author Pierre Bélisle
 * @version Copyright 2019
 */
public class PanneauNbElements extends JPanel{
		
	    /**
	     * STRATÉGIE : On prend 2 JLabel (une pour l'étiquette et une pour le 
	     * nombre d'éléments) et on les ajoute au panneau.
	     */
	    //Sert pour la persistence (enlève un warning)
		private static final long serialVersionUID = 1L;
		
		
		//L'étiquette et le nombre
		private JLabel etiqNbElements;
		private JLabel nbElements;		
	
		/**
		 * 
		 */
		public PanneauNbElements(){
			
			// Utilisation d'une procédure locale.
			initComposants();			
		}
		
		/**
		 * Crée les deux étiquettes et définit la taille du panneau
		 * avant d'y ajouter les composants.
		 */
		private void initComposants(){

			etiqNbElements = new JLabel("Nombre d'éléments : ");
			nbElements = new JLabel("0");
			
			setPreferredSize(new Dimension(120,50));
			
			add(etiqNbElements);
			add(nbElements);
		}
		
		/**
		 * Modifie l'étiquette représentant le nombre.
		 * 
		 * @param nb Le nombre à afficher
		 */
		public void setNbElements(int nb)
		{
			nbElements.setText(String.valueOf(nb));	
			nbElements.setPreferredSize(new Dimension(10*nbElements.getText().length(),10));
		}
	
	}

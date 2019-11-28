/**
 * Classe servant essentiellement à éviter la répétition de code des 
 * méthodes communes dans une hiérarchie de types de données abstraits
 * (TDA) qui implémente du chaînage dynamique simple.
 * 
 * À noter : Les attributs sont protected, donc utilisables par les classes
 * enfants.
 * 
 * @author Pierre Bélisle
 * @version Copyright 2019
 */
public abstract class TDAAbstrait implements InterfaceTDA{

	/* La classe interne pour utiliser le chaînage dynamique simple.*/
	protected class Noeud{
		
		protected Object element;
		protected Noeud suivant;
		
		protected Noeud(Object element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	// Les métadonnées du TDA.
	protected Noeud debut;
	protected Noeud fin;
	protected int nbElements;
	
	/**
	 * Constructeur par défaut qui crée un TDA vide.
	 * 
	 * getNbElements() == 0.
	 */
	public TDAAbstrait() {
		reinitialiser();
	}
	
	@Override
	public void reinitialiser() {
		
		debut = fin = null;
		nbElements = 0;
	}
	
	@Override
	public Object[] toArray() {
		
		/*
		 * Stratégie : On parcourt toutes la liste et on remplit un tableau 
		 *             de retour avec les éléments du TDA avant de le
		 *             retourner.
		 */
		
		// Tableau de retour.
		Object[] tab = new Object[nbElements];
		
		// Itérateur.
		Noeud tmp = debut;
		
		// Itérateur du tableau.
		int i = 0;
		
		while(tmp != null) {
			tab[i++] = tmp.element;
			tmp = tmp.suivant;
		}
		
		return tab;
	}

	@Override
	public boolean estVide() {
			
		return nbElements == 0;
	}

	
	@Override
	public int getNbElements() {
		
		return nbElements;
	}
	
	@Override
    public String toString() {
		
		/*
		 * Stratégie : On parcourt tous le TDA en créant une String
		 *             par concaténation des éléments du TDA avant de la
		 *             retourner.
		 */
		// Itérateur.
		Noeud tmp = debut;

		// String de retour.
		String s = new String();
		
		while(tmp != null) {
			
			// On ne veut pas d'espace blanc à la fin.
			if(tmp.suivant != null)
				s+= tmp.element.toString() + " ";
			else
				s+= tmp.element.toString();

			tmp = tmp.suivant;
		}
		
		return s;
	}	
	
	/**
	 * Les TDA de base n'implémente pas d'itérateur.
	 */
	@Override
	public boolean implementeIterateur() {
		
		return false;
	}

}
/**
 * Interface à implémenter pour les TDA qui ont un itérateur (position courante).
 * 
 * Les méthodes de l'itérateur à implémenter sont setPcDebut, setPcFin, 
 *                                                setPcSuivant, setPcPredecent.
 *                       
 * Deux constantes serviront à déterminer le mode d'insertion d'un TDA par
 * rapport à l'itérateur (AVANT ou APRES).
 * 
 * 
 *                              
 * @author Pierre Bélisle
 * @version Copyright 2019
 */
public interface InterfaceTDAIterateur extends InterfaceTDA{
	
	// Les modes possibles pour l'insertion des TDA qui implémentent l'itérateur.
	public static final int AVANT = 0;
	public static final int APRES = 1;
	    
	/**
	 * Retourne le mode d'insertion du TDA avec itérateur.
	 * 
	 * @return Le mode AVANT ou APRES qui sera utilisé lors du prochain ajout.
	 */
	public int getModeInsertion();
	
	/**
	 * Mutateur du mode d'insertion pour les TDA qui implémentent un
	 * itérateur.
	 * 
	 * "param mode AVANT ou APRES qui sera utilisé lors du prochain ajout.
	 */
	public void setModeInsertion( int mode);

	/**
	 * Doit positionner l'itérateur sur l'élément suivant.
	 */
	public void setPcSuivant();
	
	/**
	 * Doit positionner l'itérateur sur l'élément précédent.
	 */
	public void setPcPrecedent();
	
	/**
	 * Doit positionner l'itérateur sur le premier élément.
	 */
	public void setPcDebut();
	
	/**
	 * Doit positionner l'itérateur sur le dernier élément.
	 */
	public void setPcFin();	
}
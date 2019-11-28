/**
 * Interface à implémenter pour les TDA du projet (Pile, File et Liste).
 * 
 *  Certains TDA comme la pile et la file n'ont pas d'itérateurs
 *  mais la liste en a un. 
 * 
 * À noter : getElement n'enlève pas l'élément de la structure.
 * 
 * @author Pierre Bélisle
 * @version Copyright 2019
 */
public interface InterfaceTDA {
	
	/*
	 * Remet le TDA dans son état initial, soit vide.
	 */
	public void reinitialiser();
	
	/**
	 * Retourne un tableau dont les objets sont 
	 * disposés dans le même sens que dans le TDA
	 *
	 * Cela signifie que l'élément en première position dans la liste 
	 * est dans la première case du tableau.
	 * 
	 * @return Un tableau des objets du TDA ou null si la liste est vide.
	 */
	public Object[] toArray();

    /**
     * Mutateur de la structure qui ajoute l'élément à 
     * la position prévue par le TDA
     * 
     * @param element L'élement à ajouter
     */
    public void ajoute(Object element);
    
    /**
     * Retourne l'élément à la position prévue par le TDA. 
     * 
	 * @throws TDAVideException On ne peut obtenir d'élément dans une liste vide.
	 * 
     * @return L'objet qui se trouve à la position déterminée
     */
    public Object getElement() throws TDAVideException;
    
    /**
     * Supprime l'élément sélectionné par l'itérateur ou la position 
     * prédéterminée selon le TDA.
     * 
     * @throws TDAVideException On ne peut supprimer dans une liste vide.
     */    
    public void supprime()  throws TDAVideException;
    
    /**
     * Retourne si le TDA est vide.
     * 
     * @return True si le TDA est vide ou false sinon.
     */
    public boolean estVide();
   
    /**
     * Retourne si le TDA a un itérateur ou non.
     * 
     * @return True si le TDA a un itérateur ou false sinon.
     */
    public boolean implementeIterateur();
    
    /**
     * Retourne la position actuelle des opérations d'insertion du TDA.
     * 
     * La position 0 est la première de gauche à droite (getNbElement()-1).
     * 
     * @return La position actuelle de la prochaine opération.
     */
    public int getPosition();
    
    /**
     * Retourne le nombre d'éléments du TDA.
     * 
     * @return Le nombre d'éléments du TDA.
     */
    public int getNbElements();
    
    /**
     * Retourne les données du TDA en chaîne de caractères.
     * 
     * La méthode toString doit être implémentée pour le type d'élément contenu
     * dans la liste.
     * 
     * @return Les éléments de la liste concaténée dans une chaîne de caratères
     *         ou null si la liste est vide.
     */    
    public String toString();
    
    
    /**
     * Retourne un identifiant du TDA (ex: "Pile", "File", ...).
     * 
     * @return Un identifiant du TDA.
     */
    public String getId();
	     
}
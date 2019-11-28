/**
 * Implémente une pile d'objets (simule la généricité, sauf que l'utilisation
 * demande de transtyper les objets reçus, à l'exception des types primitifs
 * ayant des enveloppeurs)
 * 
 * La classe implémente les méthodes décrites dans InterfaceTDA
 * à l'exception de celles décrites dans TDAAbstrait.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2019
 * 
 */
public class Pile extends TDAAbstrait{

	 /*
	  *STRATEGIE : On utilise la classe Noeud déclarée protected dans 
	  *            la classe parent pour la gestion de la pile.
	  *            
	  *            L'attribut fin du parent n'est jamais utilisé donc non mis
	  *            à jour.
	  */

	/*
	 * Constructeur par défaut qui retourne une pile vide instanciée.
	 */
	public Pile(){
		super();
	}


	@Override
	public void ajoute (Object element) {
		
		// On ajoute avant le premier noeud.
		debut = new Noeud(element, debut);
		
		// Un élément de plus.
		nbElements++;

	}

	/**
	 * Retourne l'élément du dessus de la pile sans l'enlever.
	 *
     * antécédent : La pile ne doit pas être vide.
     * conséquent : L'élément sur le sommet est encore sur la pile.
	 */
	@Override
	public Object getElement () throws TDAVideException{
		
		if(debut == null) {
    		throw new TDAVideException(" La pile est vide");
    	}
		return debut.element;
	}

	/**
	 * Supprime l'élément au sommet de la pile.  Vous devez obtenir l'élément 
	 * avant si nécessaire.
	 */
	@Override
	public void supprime() throws TDAVideException {

		if(nbElements == 0) {
			throw new TDAVideException("La pile est vide");
		}
		
		// Déplace la tête sur le noeud suivant suffit grâce au System.gc().
		debut = debut.suivant;
		
		// Un élément de moins.
		nbElements--;
	}

	 @Override
	 public String getId() {
	    	return "Pile";
	 }
	 
	 @Override
	 public int getPosition() {
		 return 0;
	 }

}
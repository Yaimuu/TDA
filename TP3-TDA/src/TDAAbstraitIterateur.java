/**
 * Classe servant essentiellement à éviter la répétition de code des 
 * méthodes communes dans les sous classes de la hiérarchie
 * de classes InterfaceTDAIterateur et TDAAbstrait.
 * 
 * À noter : L'attribut pc est protected et accessible par les classes enfants.
 * 
 * @author Pierre Bélisle
 * @automne 2013
 *
 */
public abstract class TDAAbstraitIterateur extends TDAAbstrait
                                           implements InterfaceTDAIterateur{


	// L'itérateur nommé pc pour position courante.
	protected Noeud pc;
		
	/**
	 * Nous définissons un attribut pour le mode d'insertion.
	 */
	private int modeInsertion = AVANT;

	@Override
	public void reinitialiser() {
		
		super.reinitialiser();
		pc = null;
	}
	
	/**
	 * Mutateur du mode d'insertion utile pour les TDA qui implémentent les
	 * itérateurs.
	 * 
	 * "param mode InterfaceTDAIterateur.AVANT ou InterfaceTDAIterateur.APRES
	 */
	public void setModeInsertion( int mode){
		
		this.modeInsertion = mode;
	}

	/**
	 * Retourne le mode d'insertion du TDA.
	 * 
	 * @return Le mode InterfaceTDAIterateur.AVANT ou InterfaceTDAIterateur.APRES
	 *         qui sera utilisé lors du prochain ajout.
	 */
	public int getModeInsertion() {
		return modeInsertion;
	}
	
	 /**
	  * Met la position courante au début du TDA.
	  * 
	  * antécédent : le TDA ne doit pas être vide.
	  * conséquent : position == debut
	  */
	 public void setPcDebut() {

        // On déplace la position courante au début.
		pc = debut;
	 }

	 /**
	  * Met la position courante à la fin du TDA.
	  * antécédent : le TDA ne doit pas être vide.
	  * conséquent : position == fin
	  * 
	  */  
	 public void setPcFin() {
		 
         // On déplace la position courante à la fin.
		 pc = fin;		 
	 }
	 
	 /**
	  * Passe la position courante au précédent du TDA.
	  * antécédent : le TDA ne doit pas être vide.
	  * conséquent : la position courante est sur l'élément précédent s'il
	  *              existe, sinon position courante == debut.
	  *  
	  */
	 public void setPcPrecedent(){
	
		 if(pc != null && pc != debut){
			 
			 // On se place au début.
			 Noeud posTmp = debut;

			 // Tant qu'on n'est pas sur l'élément voulu. 
			 while(posTmp.suivant != pc) {

				 // On passe au suivant.
				 posTmp = posTmp.suivant;
			 }
			 
			 // On place la position courante sur le précédent.
			 pc = posTmp;
		 }
	 }	
	 
	 /**
	  * Passe la position courante au suivant du TDA.
	  * 
	  * antécédent : aucun
	  * conséquent : position est déplacée sur l'élément suivant s'il existe
	  *              sinon position courante == fin.
	  */
	 public void setPcSuivant(){		
		 
		 // Si c'est la fin, on ne déplace pas, sinon ...
		 if(pc != null && pc.suivant != null){
			 
			 // On passe au suivant.
    	     pc = pc.suivant;
		 }		 
	 }
	 	 
	 @Override
     public boolean implementeIterateur() {		
		 
			return true;
	 }

}
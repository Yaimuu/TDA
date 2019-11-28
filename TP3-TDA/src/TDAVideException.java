/**
 * Exception levée si on tente de supprimer dans un TDA vide.
 *
 * @author Pierre Bélisle
 * @version automne 2019
 */
public class TDAVideException extends Exception {

	/**
	 * Enlève un warning.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur avec un message prédéterminé.
	 */
	public  TDAVideException(){
		super("ERREUR : La collection est vide.");
	}

	/**
	 * Constructeur avec un message.
	 * 
	 * @param message Le message qui sera récupérable par getMessage().
	 */
	public  TDAVideException(String message){
		super(message);
	}

}

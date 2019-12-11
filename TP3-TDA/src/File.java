/**
 * Classe File, elle permet de créer le système de fonctionnement de la file
 *
 * @author Yanis Ouled Moussa, Justin Garcia
 * @version automne 2019
 */

public class File extends TDAAbstrait 
{
	/*
	 * Constructeur par défaut qui retourne une file vide instanciée.
	 */
	public File()
	{
		super();
	}
	
	/*
	 * On ajoute le nouveau noeud dans la file
	 * si la file est null, on instancie un Noeud
	 * */
	@Override
	public void ajoute(Object element) 
	{
		if(debut != null)
		{
			Noeud cursor = debut;
	        while (cursor.suivant != null) 
	        {
	            cursor = cursor.suivant;
	        }
	        cursor.suivant = new Noeud(element, null);
		}
		else
		{
			debut = new Noeud(element, null);
		}
		
		Noeud cursor = debut;
        while (cursor.suivant != null) 
        {
            cursor = cursor.suivant;
        }
        fin = cursor;
		
		// Un élément de plus.
		nbElements++;
		
	}

	@Override
	public Object getElement() throws TDAVideException 
	{
		if(fin == null) {
    		throw new TDAVideException(" La file est vide");
    	}
		return fin.element;
		
	}

	@Override
	public void supprime() throws TDAVideException 
	{
		if(nbElements == 0) 
		{
			throw new TDAVideException("La file est vide");
		}
		
		// Déplace la tête sur le noeud suivant du début
		debut = debut.suivant;
		
		// Un élément de moins.
		nbElements--;
		
	}

	@Override
	public int getPosition() 
	{
		return 0;
	}

	@Override
	public String getId() 
	{
		return "File";
	}
}

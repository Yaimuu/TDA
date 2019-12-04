

public class File extends TDAAbstrait 
{

	@Override
	public void ajoute(Object element) 
	{
		if(debut != null)
		{
			Noeud cursor = debut;
	        while (cursor.suivant != null) {
	            cursor = cursor.suivant;
	        }
	        cursor.suivant = new Noeud(element, null);
		}
		else
		{
			debut = new Noeud(element, null);
		}
		
		// Un élément de plus.
		nbElements++;
		
	}

	@Override
	public Object getElement() throws TDAVideException 
	{
		
		if(fin == null) {
    		throw new TDAVideException(" La file est vide");
    	}
		return debut.element;
		
	}

	@Override
	public void supprime() throws TDAVideException 
	{
		if(nbElements == 0) 
		{
			throw new TDAVideException("La file est vide");
		}
		
		// Déplace la tête sur le noeud suivant suffit grâce au System.gc().
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

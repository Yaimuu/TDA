public class Liste extends TDAAbstraitIterateur
{
	private int mode;
	
	public Liste(int mMode) 
	{
		super();
		this.mode = mMode;
	}
	
	@Override
	public void ajoute(Object element) 
	{
		if(debut != null) {
			if(this.mode == AVANT) {
				Noeud cursor = debut;
				while(cursor.suivant != pc) {
					cursor = cursor.suivant;
				}
				cursor.suivant = new Noeud(element, cursor.suivant);
			}else if(this.mode == APRES) {
				Noeud cursor = pc;
				while(cursor.suivant != null) {
					cursor = cursor.suivant;
				}
				cursor.suivant = new Noeud(element, cursor.suivant);
			}
		}else {
			debut = new Noeud(element, debut);
		}
		
		/*if(debut != null)
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
		}*/
		
		nbElements++;
		
	}

	@Override
	public void setPcDebut() {
		this.pc = debut;
	}
	
	@Override
	public void setPcFin() {
		this.pc = fin;
	}
	
	@Override
	public void setPcSuivant() {
		if(pc != null && pc.suivant != null){
			 
			 // On passe au suivant.
   	     pc = pc.suivant;
		 }	
	}
	

	@Override
	public Object getElement() throws TDAVideException 
	{
		// TODO Auto-generated method stub
		return this.pc.element;
	}

	@Override
	public void supprime() throws TDAVideException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPosition() 
	{
		Noeud temp = debut;
		int position = 0;
		while(temp != pc) {
			temp = temp.suivant;
			position++;
		}
		return position;
	}

	@Override
	public String getId() 
	{
		return "Liste";
	}
	
}

public class Liste extends TDAAbstraitIterateur
{
	private int mode;
	
	public Liste(int mMode) 
	{
		super();
		this.mode = mMode;
	}
	
	public void setModeInsertion( int mode)
	{
		
		this.mode = mode;
	}
	
	@Override
	public void ajoute(Object element) 
	{
		if(this.debut != null) 
		{
			if(this.mode == AVANT) 
			{
				Noeud cursor = this.debut;
				while(cursor != this.pc && cursor.suivant != this.pc)
				{
					cursor = cursor.suivant;
				}
				cursor.suivant = new Noeud(element, cursor.suivant);
				this.pc = cursor.suivant;
				System.out.println("Avant : " + element);
			}
			else if(this.mode == APRES) 
			{
				Noeud cursor = this.pc;
				cursor.suivant = new Noeud(element, cursor.suivant);
				this.pc = cursor.suivant;
				System.out.println("Après : " + element);
			}
		}
		else 
		{
			this.debut = new Noeud(element, this.debut);
		}
		
		Noeud cursor = this.debut;
		while(cursor.suivant != null) 
		{
			cursor = cursor.suivant;
		}
		this.fin = new Noeud(element, null);
		
		nbElements++;
		
	}

	@Override
	public void setPcDebut() {
		this.pc = this.debut;
	}
	
	@Override
	public void setPcFin() {
		this.pc = this.fin;
	}
	
	@Override
	public void setPcSuivant() {
		if(this.pc != null && this.pc.suivant != null)
		{
			 // On passe au suivant.
			this.pc = this.pc.suivant;
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
		
		Noeud cursor = this.debut;
		Noeud tmp = null;
		while(cursor != this.pc && cursor.suivant != this.pc)
		{
			cursor = cursor.suivant;
		}
		tmp = cursor.suivant.suivant;
		if(cursor.suivant != null)
		{
			cursor.suivant = tmp;
		}
		else
		{
			cursor.suivant = null;
		}
		
		this.pc = tmp;
	}

	@Override
	public int getPosition() 
	{
		Noeud temp = debut;
		int position = 0;
		while(temp != this.pc)
		{
			if(temp.suivant == null)
			{
				break;
			}
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

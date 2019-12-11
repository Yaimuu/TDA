/**
 * Classe Liste, elle met en place le système de fonctionnement d'une liste
 *
 * @author Yanis Ouled Moussa, Justin Garcia
 * @version automne 2019
 */
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
	/*
	 * On ajout le Noeud dans la liste selon le mode d'insértion AVANT ou APRES
	 * Si la liste est null, on instancie un Noeud dedans en lui donnant la position de tête
	 * */
	@Override
	public void ajoute(Object element)
	{
		if(this.debut != null) 
		{
			
			if(this.mode == AVANT) 
			{
				if(this.pc == this.debut)
				{
					Noeud cursor = this.pc;
					cursor = new Noeud(element, cursor);
					this.pc = cursor;
					this.debut = cursor;
				}
				else
				{
					Noeud cursor = this.debut;
					while(cursor.suivant != this.pc)
					{
						cursor = cursor.suivant;
					}
					cursor.suivant = new Noeud(element, cursor.suivant);
					this.pc = cursor.suivant;
				}
				
			}
			else if(this.mode == APRES) 
			{
				if(this.pc == null)
				{
					this.pc = this.debut;
				}
				
				Noeud cursor = this.pc;
				cursor.suivant = new Noeud(element, cursor.suivant);
				this.pc = cursor.suivant;
				
			}
		}
		else 
		{
			this.debut = new Noeud(element, this.debut);
		}
		
		Noeud cursor = this.debut;
		while(cursor != null && cursor.suivant != null) 
		{
			cursor = cursor.suivant;
		}
		this.fin = cursor;
		
		nbElements++;
		
	}

	// On indique que la position curseur est égale à la tête
	@Override
	public void setPcDebut() {
		this.pc = this.debut;
	}
	
	// On indique que la position curseur est égale à la queue
	@Override
	public void setPcFin() {
		this.pc = this.fin;
	}
	
	// On indique que la position curseur est égale au Noeud suivant
	@Override
	public void setPcSuivant() {
		if(this.pc != null && this.pc.suivant != null)
		{
			// On passe au suivant.
			this.pc = this.pc.suivant;
		 }	
	}
	
	// On indique que la position curseur est égale au Noeud précédent
	// (avec un while car les Noeuds ne sont pas sont doublement chainés)
	public void setPcPrecedent() {
		if(this.pc != this.debut)
		{
			Noeud cursor = this.debut;
			while(cursor.suivant != this.pc)
			{
				cursor = cursor.suivant;
			}
			this.pc = cursor;
		}
	}

	// On retourne le Noeud correspondant au curseur
	@Override
	public Object getElement() throws TDAVideException 
	{
		if(this.pc == null)
		{
			this.pc = this.fin;
		}
		return this.pc.element;
	}

	// On supprime l'élément se trouvant à la position après le curseur
	@Override
	public void supprime() throws TDAVideException 
	{
		Noeud cursor = this.debut;
		Noeud tmp = null;
		if(this.debut == this.pc)
		{
			this.debut = cursor.suivant;
			cursor = null;
			tmp = this.debut;
		}
		else
		{
			while(cursor.suivant != this.pc)
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
				tmp = cursor;
			}
		}
		this.pc = tmp;
		
		this.nbElements--;
		
		cursor = this.debut;
		while(cursor != null && cursor.suivant != null) 
		{
			cursor = cursor.suivant;
		}
		this.fin = cursor;
	}

	// On retourne la position du Noeud au curseur
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

	// On retourne l'id de la Classe
	@Override
	public String getId() 
	{
		return "Liste";
	}
	
}

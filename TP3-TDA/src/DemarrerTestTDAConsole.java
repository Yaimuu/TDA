/**
 * Programme qui teste la hiérarchie de classes InterfaceTDA du tp3 A2019.
 * 
 * Comme il s'agit de tests, plusieurs valeurs litérales ne sont pas déclarées
 * en constantes.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2019
 */

public class DemarrerTestTDAConsole {

	// Mettre à true pour voir les détails des tests et à false sinon.
	public static final boolean DEBUG = true;

	// Nombre d'éléments utilisés pour le test.
	public static final int NB_ELEMENTS_MAX = 10;

	// On fait 2 tours pour ces tests.
	private static final int NB_TOURS = 2;

	/*
	 * On crée simplement 2 TDA à tester qu'on transmet à tour de rôle à
	 * la procédure de test d'un TDA.
	 */
	public static void main(String args[]) {
		
		/*
		 * De réaliser les tests deux fois permet de vérifier que tout se 
		 * passe bien lorsqu'on réinsère des éléments dans un TDA après l'avoir
		 * vidé.
		 */

		System.out.println();
		System.out.println("LES TESTS SERONT EFFECTUES " + NB_TOURS + " FOIS");
		
		// Création des tdas testés.
		InterfaceTDAIterateur liste = new Liste(InterfaceTDAIterateur.APRES);
		InterfaceTDA file = new File();		
		
		// Les NB_TOURS des tests.
		for (int i = 0; i < NB_TOURS; i ++) {
			
			afficherEntete(i);
			
			// Les explications et le test pour la file.
            if(DEBUG) afficherResultatTestFile();
			testerTda(file);
			
			// Les explications et le test pour la liste.
			if(DEBUG) afficherResultatTestListe();			
			testerTda(liste);
			
		}
		
		System.out.println();
		System.out.println("Test termin�e");		

	}


	/*
	 * Affiche simplement quel tour du test roule actuellement.
	 */
	private static void afficherEntete(int i) {
		
		System.out.println();

		if(i == 0)
			System.out.println("Premi�re batterie de tests");
		else
			System.out.println(i + 1 + " ieme batterie de tests");
		
		System.out.println();
		
	}

	/* 
	 * Affiche les résultats prévus du test pour la file.
	 */
	private static void afficherResultatTestFile() {

		System.out.println();
		System.out.println();
		System.out.println(" Une file contenant les entiers 1 à 10 est cr�e");
		System.out.println(" -----------------------------------------------");
		System.out.println(" Deux entiers sont d�fil�s et trois sont enfil�s");
		System.out.println(" on doit voir des entiers de 3 à 13.");
		System.out.println(" -----------------------------------------------");
		System.out.println(" Toutes les valeurs sont d�fil�es une � une et on");
		System.out.println(" r�enfile 2 entiers, on doit voir les entiers 1 et 2.");
		System.out.println(" -----------------------------------------------");
		System.out.println(" Finalement, on supprime la file.");

	}

	/* 
	 * Affiche les résultats prévus du test pour la liste.
	 */
	private static void afficherResultatTestListe() {

		System.out.println();
		System.out.println();
		System.out.println(" On ajoute en mode d'insertion APRES dans une liste");
		System.out.println(" On aura les valeurs de 1 � 10 dans l'ordre");
		System.out.println(" -----------------------------------------------");
		System.out.println(" On d�place l'it�rateur entre le d�but et la fin " +
		                   " pour tester le positionnement.  On teste aussi "
		                   + "les limites (ex: d�placer suivant d�j� au dernier)");
		System.out.println(" -----------------------------------------------");		
		System.out.println(" On met l'it�rateur au d�but et on ajoute deux entiers");
		System.out.println(" on doit voir  1 12 13 2 3 4 5 6 7 8 9 10.");
		System.out.println(" L'it�rateur est sur le 13.");		
		System.out.println(" -----------------------------------------------");
		System.out.println(" On change le mode d'insertion pour AVANT et " + 
				             "on ajoute un entier");		
		System.out.println(" on doit voir 1 12 14 13 2 3 4 5 6 7 8 9 10.");
		System.out.println(" L'it�rateur est sur le 14.");
		System.out.println(" -----------------------------------------------");
		System.out.println(" On supprime l'�l�ment ajout�");		
		System.out.println(" on doit voir 1 12 13 2 3 4 5 6 7 8 9 10.");
		System.out.println(" L'it�rateur est sur le 13.");
		System.out.println(" -----------------------------------------------");
		System.out.println(" On ajoute avant le premier");		
		System.out.println(" on doit voir 15 1 12 13 2 3 4 5 6 7 8 9 10.");
		System.out.println(" L'it�rateur est sur le 15.");
		System.out.println(" -----------------------------------------------");		
		System.out.println(" On ajoute avant le dernier");		
		System.out.println(" on doit voir 15 1 12 13 2 3 4 5 6 7 8 9 16 10.");
		System.out.println(" L'it�rateur est sur le 16.");
		System.out.println(" -----------------------------------------------");		
		System.out.println(" On supprime le dernier �l�ment");		
		System.out.println(" on doit voir 15 1 12 13 2 3 4 5 6 7 8 9 16.");
		System.out.println(" L'it�rateur est sur le 16.");
		System.out.println(" -----------------------------------------------");
		System.out.println(" On supprime le premier �l�ment");		
		System.out.println(" on doit voir 1 12 13 2 3 4 5 6 7 8 9 16.");
		System.out.println(" L'it�rateur est sur le 1.");
		System.out.println(" -----------------------------------------------");
		System.out.println(" On supprime la liste un à un, elle doit devenir vide.");
		System.out.println(" -----------------------------------------------");

	}


	// Évite la répétition de code pour cette erreur.
	private static void aviserErreurVide(TDAVideException e, String id) {

		System.out.println("Erreur grave le tda "+id+" Ne doit pas �tre vide");

		e.printStackTrace();

	}


	// Évite la répétition du message commun pour ce genre d'erreur.
	private static void aviserErreurPc(String message) {

		System.out.println("�chec lors de l'utilisation de " + message);

	}

	/*
	 * Teste l'ajout, le retrait et le positionnement si c'est un TDA avec
	 * itérateur.
	 * 
	 * On affiche le TDA après chaque opération en mode DEBUG.
	 */
	private static void testerTda(InterfaceTDA tda) {

		obtenirTDA(tda);

		// // On vérifie le positionnnement seulement s'il y a un itérateur. 
		if(tda.implementeIterateur()) {

			// On convertit le TDA pour accéder aux méthodes de positionnement.
			InterfaceTDAIterateur tdaI = (InterfaceTDAIterateur)tda;					

			// Tests de positionnement.
			testerIterateurEtGetPosition(tdaI);

			// Teste les autres méthodes.
			testerTDAIterateur(tdaI);

		}
		else {
			testerFile(tda);
		}		
		
		supprimerTDA(tda);
	}

	/*
	 * S'assure que les méthodes de déplacement et la méthode getPosition() 
	 * fonctionnent correctement.
	 */
	private static void testerIterateurEtGetPosition(InterfaceTDAIterateur tdaI) {
		
		// On démarre le test sur le TDA en mode d'insertion APRES.
		tdaI.setModeInsertion(InterfaceTDAIterateur.APRES);
		
		testerPcDebut(tdaI);

		testerPcFin(tdaI);

		testerPcSuivantDebutAlaFin(tdaI);

		testerPcSuivantDeLaFin(tdaI);

		testerPcPrecedentDuDebut(tdaI);

		testerPcPrecedentFinAuDebut(tdaI);				
	}
	
	private static void testerPcDebut(InterfaceTDAIterateur tdaI) {

		// L'élément est 1 et getPosition() == 0.
		System.out.println("Test pc debut");

		tdaI.setPcDebut();
		if(DEBUG) afficherTDA(tdaI);

		try {
			if(tdaI.getPosition() != 0 && (int)tdaI.getElement() == 1) {

				aviserErreurPc("setPcDebut() ou getElement() ou getPosition()");
			}
		} catch (TDAVideException e) {

			aviserErreurVide(e, tdaI.getId());
		}		
	}

	private static void testerPcFin(InterfaceTDAIterateur tdaI) {

		System.out.println("Test pc fin");

		// L'Élément est 10 et la position est nbElements -1.
		tdaI.setPcFin();
		if(DEBUG) afficherTDA(tdaI);
		
		try {
			if(tdaI.getPosition() != tdaI.getNbElements() -1 && (int)tdaI.getElement() == 10) {

				aviserErreurPc("setPcFin() ou getPosition() ou getNbElement()");
			}
		} catch (TDAVideException e) {

			aviserErreurVide(e, tdaI.getId());
		}

	}

	private static void testerPcSuivantDebutAlaFin(InterfaceTDAIterateur tdaI){


		System.out.println("Test pc suivant en partant du d�but");

		// L'Élément est 10 et la position est nbElements -1.
		// On se déplace de 2 alors getPosition donne 2 en partant de 0 et 
		// l'élément est 3.
		tdaI.setPcDebut();
		if(DEBUG) afficherTDA(tdaI);

		for(int i = 0; i < tdaI.getNbElements() - 1; i++) {

			tdaI.setPcSuivant();
			if(DEBUG) afficherTDA(tdaI);


			try {
				if(tdaI.getPosition() != i + 2 && 
				   (int)tdaI.getElement() == i + 3) {

					aviserErreurPc("setPcDebut() ou setPcSuivant() ou" + 
					               "getElement() ou  getPosition()");
				}
			} catch (TDAVideException e) {

				aviserErreurVide(e, tdaI.getId());
			}
		}
	}

	private static void testerPcPrecedentDuDebut(InterfaceTDAIterateur tdaI) {

		System.out.println("Test pc pr�c�dent, itérateur d�j� au début");

		tdaI.setPcDebut();
		if(DEBUG) afficherTDA(tdaI);

		tdaI.setPcPrecedent();
		if(DEBUG) afficherTDA(tdaI);

		try {
			if(tdaI.getPosition() != 0 && (int) tdaI.getElement() != 1) {

				aviserErreurPc("setPcDebut() ou setPcPrecedent() ou" + 
				               "getElement() ou getPosition()");
			}
		} catch (TDAVideException e) {

			aviserErreurVide(e, tdaI.getId());
		}

	}

	private static void testerPcSuivantDeLaFin(InterfaceTDAIterateur tdaI) {

		System.out.println("Test pc suivant, it�rateur d�j�� la fin");

		tdaI.setPcFin();
		if(DEBUG) afficherTDA(tdaI);

		tdaI.setPcSuivant();
		if(DEBUG) afficherTDA(tdaI);

		try {
			if(tdaI.getPosition() != tdaI.getNbElements() -1 &&
					(int)tdaI.getElement() == 10) {

				aviserErreurPc("setPcFin() ou setPcSuivant() ou" + 
				               "getElement() ou getPosition() ou getNbElement()");
			}
		} catch (TDAVideException e) {

			aviserErreurVide(e, tdaI.getId());
		}	
	}

	private static void testerPcPrecedentFinAuDebut(InterfaceTDAIterateur tdaI){

		System.out.println("Test pc pr�c�dent en partant de la fin");

		tdaI.setPcFin();
		if(DEBUG) afficherTDA(tdaI);	

		int nbElements = tdaI.getNbElements();

		for(int i = 0; i < nbElements; i++) {

			tdaI.setPcPrecedent();
			if(DEBUG) afficherTDA(tdaI);		

			int pos = nbElements - i - 1;
			int valeur = pos;
			try {
				if(tdaI.getPosition() != pos && 
						(int) tdaI.getElement() != valeur) {

					aviserErreurPc("setPcFin() ou setPcPrecedent() ou " +
					               "getElement() ou getPosition()");
				}
			} catch (TDAVideException e) {

				aviserErreurVide(e, tdaI.getId());		
			}

		}
	}

	/*
	 * Teste une séquence d'ajout et de suppression d'un même élément.
	 * Démontre que l'itérateur est bien positionné.
	 */
	private static void testerTDAIterateur(InterfaceTDAIterateur tdaI) {
		
		/*
		 * Il ne faut pas changer l'ordre d'appel sans risquer de détruire
		 * la validité de ces tests.
		 */
		
		testerAjoutApresDebut(tdaI);

		testerAjoutAvantEtRetrait(tdaI);
		
		testerInsertionAvantPremier(tdaI);
		
		testerInsertionAvantdernier(tdaI);
		
		testerSuppressionDernier(tdaI);
		
		testerSuppressionPremier(tdaI);
		
		
	}
	
	private static void testerInsertionAvantdernier(InterfaceTDAIterateur tdaI){
		
		/*
		 * Il s'agit de positionner l'itérateur au début, de mettre le
		 * mode d'insertion à AVANT et d'ajouter.
		 * 
		 * Nous retenons la position, le nombre d'éléments et l'élément actuel
		 * avant et après l'ajout.  C'est ainsi que nous vérifions que
		 * tout se passe bien.
		 */
		System.out.println("Test d'insertion avant le dernier �l�ment");

		try {
			tdaI.setModeInsertion(InterfaceTDAIterateur.AVANT);
			tdaI.setPcFin();

			// Avant
			int element = (int) tdaI.getElement();
			int nbElements = tdaI.getNbElements();
			int posAvant = tdaI.getPosition();

			if(DEBUG)afficherTDA(tdaI);
			tdaI.ajoute(16);
			if(DEBUG)afficherTDA(tdaI);

			// Après
			int posApres = tdaI.getPosition();
			int nbElementsApres = tdaI.getNbElements();
			int elementApres = (int) (int)tdaI.getElement();

			// Comme on connait la composition des données, il est facile 
			// de vérifier.
			if(posAvant != posApres || 
			   posApres != nbElementsApres - 2 || 
			   posAvant != nbElements - 1 || 
			   element == elementApres || 
			   element != 10 || elementApres != 16) {

				aviserErreurPc("l'ajout avant le dernier");
			}
		}

		catch (TDAVideException e) {
			aviserErreurVide(e, tdaI.getId());
		}
		
	}

	private static void testerInsertionAvantPremier(InterfaceTDAIterateur tdaI){
	
		/*
		 * Il s'agit de positionner l'itérateur au début, de mettre le
		 * mode d'insertion à AVANT et d'ajouter.
		 * 
		 * Nous retenons la position, le nombre d'éléments et l'élément actuel
		 * avant et après l'ajout.  C'est ainsi que nous vérifions que
		 * tout se passe bien.
		 */
		System.out.println("Test d'insertion avant le premier �l�ment");
		
		try {
			tdaI.setModeInsertion(InterfaceTDAIterateur.AVANT);
			tdaI.setPcDebut();
			
			// Avant
			int element = (int) tdaI.getElement();
			int nbElements = tdaI.getNbElements();
			int posAvant = tdaI.getPosition();
			
			if(DEBUG)afficherTDA(tdaI);
			tdaI.ajoute(15);
			if(DEBUG)afficherTDA(tdaI);
			
			// Après
			int posApres = tdaI.getPosition();
			int nbElementsApres = tdaI.getNbElements();
			int elementApres = (int) (int)tdaI.getElement();
			
			
			// Comme on connait la composition des données, il est facile de 
			// vérifier.
			if(posAvant != posApres || posApres != 0 || posAvant != 0 ||  
			   nbElements != nbElementsApres - 1 ||
			   element ==  elementApres || element != 1 || elementApres != 15) {
				
			   aviserErreurPc("l'ajout avant le premier");
			}
		}
		
		catch (TDAVideException e) {
			aviserErreurVide(e, tdaI.getId());
		}
				
	}

	private static void testerSuppressionPremier(InterfaceTDAIterateur tdaI) {
		
		/*
		 * Il s'agit de positionner l'itérateur au début et supprimer.
		 * 
		 * Nous retenons la position, le nombre d'éléments et l'élément actuel
		 * avant et après la suppression.  C'est ainsi que nous vérifions que
		 * tout se passe bien.
		 */
		
		System.out.println("Test de suppression du premier �l�ment");


		try {
			tdaI.setModeInsertion(InterfaceTDAIterateur.APRES);

			tdaI.setPcDebut();		
			
			// Avant
			int element = (int) tdaI.getElement();
			int nbElements = tdaI.getNbElements();
			int posAvant = tdaI.getPosition();

			if(DEBUG)afficherTDA(tdaI);
			tdaI.supprime();
			if(DEBUG)afficherTDA(tdaI);

			// Après
			int posApres = tdaI.getPosition();
			int nbElementsApres = tdaI.getNbElements();
			int elementApres = (int) (int)tdaI.getElement();


			// Comme on connait la composition des données, il est facile de 
			// vérifier.
			if(posAvant != posApres || 
			   posApres != 0 ||
			   posAvant != 0 || 
			   nbElements - 1 != nbElementsApres ||
			   element ==  elementApres || 
			   element != 15 || 
			   elementApres != 1) {

				aviserErreurPc("la suppression du premier");
			}
		}

		catch (TDAVideException e) {
			aviserErreurVide(e, tdaI.getId());
	}
	
	}
		
	private static void testerSuppressionDernier(InterfaceTDAIterateur tdaI) {
		
		/*
		 * Il s'agit de positionner l'itérateur à la fin et supprimer.
		 * 
		 * Nous retenons la position, le nombre d'éléments et l'élément actuel
		 * avant et après la suppression.  C'est ainsi que nous vérifions que
		 * tout se passe bien.
		 */
		
		System.out.println("Test de suppression du dernier �l�ment");
		
		try {
			tdaI.setModeInsertion(InterfaceTDAIterateur.APRES);
			
			tdaI.setPcFin();
			
			// Avant
			int element = (int) tdaI.getElement();
			int nbElements = tdaI.getNbElements();
			int posAvant = tdaI.getPosition();
			
			if(DEBUG)afficherTDA(tdaI);
			tdaI.supprime();
			if(DEBUG)afficherTDA(tdaI);
			
			// Après
			int posApres = tdaI.getPosition();
			int nbElementsApres = tdaI.getNbElements();
			int elementApres = (int) (int)tdaI.getElement();
			
			
			// Comme on connait la composition des données, il est facile de 
			// vérifier.
			if(posAvant == posApres ||
			   posApres != nbElementsApres - 1 ||
			   posAvant != nbElements - 1 || 
			   nbElements != nbElementsApres + 1 ||
			   element ==  elementApres || 
			   element != 10 || 
			   elementApres != 16) {
				
			   aviserErreurPc("la suppression du dernier");
			}
		}
		
		catch (TDAVideException e) {
			aviserErreurVide(e, tdaI.getId());
		}
		
	}
	

	private static void testerAjoutAvantEtRetrait(InterfaceTDAIterateur tdaI) {
		
		/*
		 * On joute une valeur et on valide qu'elle est à la position qu'elle
		 * devrait.
		 * 
		 * On supprime cette même valeur et l'itérateur ne doit pas bouger.
		 */
		System.out.println("Test d'ajout AVANT et de retait à l'it�rateur");
		
		try {
			
			tdaI.setModeInsertion(InterfaceTDAIterateur.AVANT);
			
			// On retient la position qui devra avoir boucgé après l'ajout.
			int posDepart = tdaI.getPosition();

			// Valeur choisi pour respecter le test annoncé.
			if(DEBUG) afficherTDA(tdaI);
			tdaI.ajoute(14);
			if(DEBUG) afficherTDA(tdaI);
				
			// Test de validité
			if( tdaI.getPosition() != posDepart ||  
		        (int)tdaI.getElement()  != 14) {
				
				aviserErreurPc("ajoute() ou getElement() ou  getPosition()");
			}

			// Même exercice pour la suppresion.
			posDepart = tdaI.getPosition();
			
			tdaI.supprime();
			if(DEBUG) afficherTDA(tdaI);
			
			if( tdaI.getPosition() != posDepart  || 
				(int)tdaI.getElement()  != 13) {
				
			   aviserErreurPc("supprime() ou getElement() ou getPosition()");
			}
				
		}
		catch(TDAVideException e) {

			aviserErreurVide(e, tdaI.getId());
		}		
	}

	private static void testerAjoutApresDebut(InterfaceTDAIterateur tdaI) {

		/*
		 * Deux valeurs ajoutées après, chacune déplace l'itérateur sur 
		 * le dernier élément ajouté.
		 */

		System.out.println("Test d'ajout en mode APRES du d�but");
		tdaI.setPcDebut();			
		if(DEBUG) afficherTDA(tdaI);

		tdaI.ajoute(12);
		if(DEBUG) afficherTDA(tdaI);

		tdaI.ajoute(13);
		if(DEBUG) afficherTDA(tdaI);

		if(!tdaI.toString().equals("1 12 13 2 3 4 5 6 7 8 9 10")) {
			aviserErreurPc("l'ajout APRES l'iterateur au d�but");		
		}
		// Itérateur sur le 13.
		try {
			if(tdaI.getPosition() != 2 || (int)tdaI.getElement() != 13) {

				aviserErreurPc("l'ajout APRES l'iterateur au d�but");

			}
		} catch (TDAVideException e) {
             aviserErreurVide(e, tdaI.getId());
		}
	}



	/*
	 * Teste la méthode qui supprime.
	 */
	private static void supprimerTDA(InterfaceTDA tda) {

		System.out.println("Suppression de la " + tda.getId());
		
		/*
		 * On ne se soucis pas de l'ordre de suppression qui est laissé
		 * au TDA concret.  On supprime de là où est le pc et cela pour tous
		 * les éléments.
		 */
		int nb = tda.getNbElements();
		
		// Avant le début de la suppression.
		if(DEBUG) afficherTDA(tda);
		
		for(int i = 0; i < nb; i++) {

			try {
				tda.supprime();
				if(DEBUG) afficherTDA(tda);
			}
			catch(Exception e) {
				System.out.println("Probl�me de file vide pr�matur�ment");
			}

		}

	}

	/*
	 * Crée un TDA avec les valeurs 1 à 10.
	 * 
	 * Antécédent : On présume le TDA vide.
	 */
	private static void obtenirTDA(InterfaceTDA tda) {

		System.out.println("Cr�ation de la " + tda.getId());
		
		for(int i = 0; i < NB_ELEMENTS_MAX; i++) {

			tda.ajoute(i+1);
			if(DEBUG) afficherTDA(tda);

		}		

		if(!tda.toString().equals("1 2 3 4 5 6 7 8 9 10")) {
			System.out.println("�chec de cr�ation du tda - " + tda.getId());
		}


	}

	private static void testerFile(InterfaceTDA tda) {

		// Effectue le test décrit dans afficherResultatTestFile

		//	Deux entiers sont défilés et trois sont enfilés.
		System.out.println("Test de d�filement");

		try {
			tda.supprime();
			if(DEBUG) afficherTDA(tda);

			tda.supprime();
			if(DEBUG) afficherTDA(tda);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test d'enfilement");
		
		tda.ajoute(11);
		if(DEBUG) afficherTDA(tda);

		tda.ajoute(12);
		if(DEBUG) afficherTDA(tda);

		// On doit voir des entiers de 3 à 13.
		tda.ajoute(13);
		if(DEBUG) afficherTDA(tda);

		supprimerTDA(tda);

		System.out.println("Test d'enfilement apr�s suppression");
		
		tda.ajoute(1);
		if(DEBUG) afficherTDA(tda);

		tda.ajoute(2);
		if(DEBUG) afficherTDA(tda);

	}
	
	/* 
	 * Affiche les éléments d'un TDA et l'itérateur s'il y a lieu.
	 * 
	 * Indique s'il est vide.
	 */
	public static void afficherTDA(InterfaceTDA tda) {

		if(tda.estVide()) {
			System.out.println();
			System.out.println(tda.getId() + " vide");
		}		

		else {
			System.out.println("[ " + tda.toString() + " ]");

			// Montre la position courante quand le TDA a un itérateur.
			if(tda.implementeIterateur()) {

				afficherPosition((InterfaceTDAIterateur)tda);
			}
		}	
	}

	/*
	 * Affiche la position courante en tenant compte qu'il y a des crochets à
	 * l'affichage.
	 */
	private static void afficherPosition(InterfaceTDAIterateur tdaI) {

		int pos = tdaI.getPosition();

		// AU moins 1 espace pour le crochet.
		String espace = "  ";
		
		tdaI.setPcDebut();

		// Selon la position de l'itérateur, on construit l'espace à afficher 
		// en premier.
		for(int i = 0; i < pos; i++) {

			try {
				if((int)tdaI.getElement() > 10) {
					espace += "   ";
				}

				else {
					espace += "  ";
				}
				
				tdaI.setPcSuivant();


			} catch (TDAVideException e) {

				aviserErreurVide(e, tdaI.getId());
			}
		}

		
		if(pos != tdaI.getPosition())
			System.out.println("oups probl�me avec getPosition() ou " + 
		                       "setPcDebut() ou setPcSuivant() ou getElement()");
			
		// On affiche la position.
		System.out.println();
		System.out.println(espace + "^");
		System.out.println(espace + "|");

	}

}
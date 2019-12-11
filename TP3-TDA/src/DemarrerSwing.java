import javax.swing.*;
/**
 * Classe Demarrer Swing, elle permet de démarrer l'interface swing et donc l'affichage graphique
 *
 * @author Yanis Ouled Moussa, Justin Garcia
 * @version automne 2019
 */
public class DemarrerSwing 
{
	public static void main(String args[])
	{
		// On créer un objet de la classe CadreTDA afin d'appeler la méthode run();
		CadreTDA cadre = new CadreTDA();
		
		SwingUtilities.invokeLater(new Runnable() 
	    {
			// Appelle de la méthode run() de la classe CadreTDA
	        public void run() 
	        {
	            cadre.run();
	        }
	    });
		
	}
}

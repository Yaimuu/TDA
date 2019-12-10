import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Classe qui permet de choisir entre l'orientation portrait
 * et paysage.  Une seule instance de se panneau se trouve dans
 * le panneau central.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2019
 */
public class PanneauOrientation extends JPanel implements ActionListener{

	/**
	 * STRATÉGIE : Nous offrons deux boutons-radio 
	 * 
	 *             Un seul écouteur suffit.  C'est le panneau central qui 
	 *             offre les méthodes pour changer l'orientation et afficher 
	 *             le nouveau tda.  Ici, on montre les boutons et on
	 *             réagit à un clic en chagneant l'oritnation du panneau central.
	 */

	//Sert pour la persistence (enlève un warning)
	private static final long serialVersionUID = 1L;

	//Attributs
	private JRadioButton orientationPortrait;
	private JRadioButton orientationPaysage;

	//On veut une sélection exclusive (un ou l'autre mais pas les deux).
	private ButtonGroup groupe;

	// Nécessaire pour le rafraichissement d'écran. 
	private PanneauCentral panneauCentral;
		
	/**
	 * 
	 */
	public PanneauOrientation(PanneauCentral panneauCentral)
	{
		this.panneauCentral = panneauCentral;
	
		//Procédure locale 
		initComposants();

	}

	/**
	 * Crée les instances, sélectionne l'orientation
	 * portrait, ajoute l'écouteur, crée un groupe,  
	 * y ajoute les boutons et ajoute les boutons au panneau.
	 */
	private void initComposants(){

		orientationPortrait = new JRadioButton("Portrait");  
		orientationPortrait.setSelected(true);                  
		orientationPortrait.addActionListener(this);
		panneauCentral.changeOrientation(orientationPortrait.getText().toString());

		orientationPaysage = new JRadioButton("Paysage");
		orientationPaysage.addActionListener(this);

		groupe = new ButtonGroup();

		groupe.add(orientationPortrait);
		groupe.add(orientationPaysage);

		add(orientationPortrait);
		add(orientationPaysage);
	}

	/**
	 * écouteur qui s'exécute lorsqu'un des boutons-radio
	 * est cliqué.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		System.out.println(((AbstractButton) arg0.getSource()).getText().toString());
		panneauCentral.changeOrientation(((AbstractButton) arg0.getSource()).getText().toString());
    }	
	
}
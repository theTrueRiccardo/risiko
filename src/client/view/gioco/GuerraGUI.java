/**
 * 
 */
package client.view.gioco;

import javax.swing.JPanel;

/**
 * @author Riccardo
 *
 */
public abstract class GuerraGUI extends JPanel{

	public abstract void setAttaccante(String attaccante);
	
	public abstract void setDifensore(String difensore);
	
	public abstract void mostraRisultatoAttaccante(String attacco);
	
	public abstract void mostraRisultatoDifensore(String difesa);
	
	public abstract void reset();
}

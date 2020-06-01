package client.view.gioco;

import javax.swing.JPanel;

public abstract class PannelloAttaccoGUI extends JPanel {

	public abstract void mostraNazioneDalla(String nomeNazione);
	
	public abstract void mostraNazioneAlla(String nomeNazione);
	
	public abstract void mostraIncremento();
	
	public abstract void reset();

}

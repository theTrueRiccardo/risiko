package client.view.gioco;

import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneDecrementoArmateSposta;
import client.controller.gioco.ControllerBottoneIncrementoArmateSposta;
import client.controller.gioco.ControllerBottonePassa;
import client.controller.gioco.ControllerBottoneSposta;

public abstract class PannelloSpostaGUI extends JPanel{

	public abstract void mostraNazioneDA(String nomeNazione);
	
	public abstract void mostraNazioneA(String nomeNazione);
	
	public abstract void mostraArmate(int armate);
	
	public abstract void reset();
	
	public abstract void setControllerBottoneSposta(ControllerBottoneSposta controllerBottoneSposta);
	
	public abstract void setControllerBottoneIncrementoArmateSposta(ControllerBottoneIncrementoArmateSposta controllerBottoneIncrementoArmateSposta);
	
	public abstract void setControllerBottoneDecrementoArmateSposta(ControllerBottoneDecrementoArmateSposta controllerBottoneDecrementoArmateSposta);
	
	public abstract void setControllerBottonePassa(ControllerBottonePassa controllerBottonePassa);

}

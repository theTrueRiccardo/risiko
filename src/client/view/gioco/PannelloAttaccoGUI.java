package client.view.gioco;

import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneAttacca;
import client.controller.gioco.ControllerBottoneDecrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneFaseSpostamento;
import client.controller.gioco.ControllerBottoneIncrementoArmateAttacco;

public abstract class PannelloAttaccoGUI extends JPanel {

	public abstract void mostraNazioneDA(String nomeNazione);
	
	public abstract void mostraNazioneA(String nomeNazione);
	
	public abstract void mostraArmate(int armate);
	
	public abstract void reset();
	
	public abstract void setControllerBottoneAttacca(ControllerBottoneAttacca controllerBottoneAttacca);
	
	public abstract void setControllerBottoneIncrementoArmateAttacco(ControllerBottoneIncrementoArmateAttacco controllerBottoneIncrementoArmateAttacco);
	
	public abstract void setControllerBottoneDecrementoArmateAttacco(ControllerBottoneDecrementoArmateAttacco controllerBottoneDecrementoArmateAttacco);
	
	public abstract void setControllerBottoneFaseSpostamento(ControllerBottoneFaseSpostamento controllerBottoneFaseSpostamento);

}

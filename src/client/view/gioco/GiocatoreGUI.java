package client.view.gioco;
import java.awt.Color;

import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneAttacca;
import client.controller.gioco.ControllerBottoneBandiera;
import client.controller.gioco.ControllerBottoneCarro;
import client.controller.gioco.ControllerBottoneCarte;
import client.controller.gioco.ControllerBottoneDecrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneDecrementoArmateSposta;
import client.controller.gioco.ControllerBottoneFaseAttacco;
import client.controller.gioco.ControllerBottoneFaseSpostamento;
import client.controller.gioco.ControllerBottoneIncrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneIncrementoArmateSposta;
import client.controller.gioco.ControllerBottoneObbiettivo;
import client.controller.gioco.ControllerBottonePassa;
import client.controller.gioco.ControllerBottoneSposta;
import client.controller.gioco.ControllerBottoneTerritori;
public abstract class GiocatoreGUI extends JPanel {
	
	public abstract void settaObbiettivo(String testoObbiettivo);
	
	public abstract void settaColoreArmate(Color colore);
	
	public abstract void settaAttaccante(String attaccante);
	
	public abstract void settaRisultatoAttaccante(String risultatoAttaccante);
	
	public abstract void settaDifensore(String difensore);
	
	public abstract void settaRisultatoDifensore(String risultatoDifensore);
	
	public abstract void settaNazioneDallaAttacco(String nazione);
	
	public abstract void settaNazioneAllaAttacco(String nazione);
	
	public abstract void scriviArmateAttacco(int armate);
	
	public abstract void settaNazioneDallaSpostaPassa(String nazione);
	
	public abstract void settaNazioneAllaSpostaPassa(String nazione);
	
	public abstract void scriviArmateSposta(int armate);
	
	public abstract void congelaArmate();
	
	public abstract void scongelaArmate();
	
	public abstract void scriviTurnista(String turnista);
	
	public abstract void scriviArmateDisponibili(String numeroArmate);
	
	
	
	
	
	
	public abstract void setControllerBottoneCarro(ControllerBottoneCarro controllerBottoneCarro);
	
	public abstract void setControllerBottoneBandiera(ControllerBottoneBandiera controllerBottoneBandiera);
	
	public abstract void setControllerBottoneFaseAttacco(ControllerBottoneFaseAttacco controllerBottoneFaseAttacco);
	
	public abstract void setControllerBottoneAttacca(ControllerBottoneAttacca controllerBottoneAttacca);
	
	public abstract void setControllerBottoneIncrementoArmateAttacco(ControllerBottoneIncrementoArmateAttacco controllerBottoneIncrementoArmateAttacco);
	
	public abstract void setControllerBottoneDecrementoArmateAttacco(ControllerBottoneDecrementoArmateAttacco controllerBottoneDecrementoArmateAttacco);
	
	public abstract void setControllerBottoneFaseSpostamento(ControllerBottoneFaseSpostamento controllerBottoneFaseSpostamento);

	public abstract void setControllerBottoneSposta(ControllerBottoneSposta controllerBottoneSposta);
	
	public abstract void setControllerBottoneIncrementoArmateSposta(ControllerBottoneIncrementoArmateSposta controllerBottoneIncrementoArmateSposta);
	
	public abstract void setControllerBottoneDecrementoArmateSposta(ControllerBottoneDecrementoArmateSposta controllerBottoneDecrementoArmateSposta);
	
	public abstract void setControllerBottonePassa(ControllerBottonePassa controllerBottonePassa);
	
	public abstract void setControllerBottoneTerritori(ControllerBottoneTerritori controllerBottoneTerritori);

	public abstract void setControllerBottoneObbiettivo(ControllerBottoneObbiettivo controllerBottoneObbiettivo);

	public abstract void setControllerBottoneCarte(ControllerBottoneCarte controllerBottoneCarte);
}

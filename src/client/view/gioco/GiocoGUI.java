package client.view.gioco;

import java.awt.Color;

import client.controller.gioco.ControllerBottoneAttacca;
import client.controller.gioco.ControllerBottoneBandiera;
import client.controller.gioco.ControllerBottoneCarro;
import client.controller.gioco.ControllerBottoneDecrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneDecrementoArmateSposta;
import client.controller.gioco.ControllerBottoneFaseAttacco;
import client.controller.gioco.ControllerBottoneFaseSpostamento;
import client.controller.gioco.ControllerBottoneIncrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneIncrementoArmateSposta;
import client.controller.gioco.ControllerBottonePassa;
import client.controller.gioco.ControllerBottoneSposta;
import client.controller.gioco.ControllerMappa;

public interface GiocoGUI {

	void apriFinestra();
	
	void settaObbiettivo(String testoObbiettivo);
	
	void settaColoreArmate(Color colore);
	
	void settaAttaccante(String attaccante);
	
	void settaRisultatoAttaccante(String risultatoAttaccante);
	
	void settaDifensore(String difensore);
	
	void settaRisultatoDifensore(String difensore);
	
	void scriviNazioneAttaccoDA(String nazione);
	
	void scriviNazioneAttaccoA(String nazione);
	
	void scriviNazioneSpostaDA(String nazione);
	
	void scriviNazioneSpostaA(String nazione);
	
	void scriviArmateAttacco(int armate);
	
	void scriviArmateSposta(int armate);
	
	void congelaArmate();
	
	void scongelaArmate();
	
	void disegnaArmata(double percx, double percy, Color colore, boolean eCarro);
	
	void scriviTurnista(String turnista);
	
	void scriviArmateDisponibili(String numeroArmate);
	
	void mostraMessaggio(String messaggio);
	
	int getLarghezzaMappa();
	
	int getAltezzaMappa();
	
	
	
	
	
	
	void setControllerBottoneCarro(ControllerBottoneCarro controllerBottoneCarro);
	
	void setControllerBottoneBandiera(ControllerBottoneBandiera controllerBottoneBandiera);
	
	void setControllerBottoneFaseAttacco(ControllerBottoneFaseAttacco controllerBottoneFaseAttacco);
	
	void setControllerBottoneAttacca(ControllerBottoneAttacca controllerBottoneAttacca);
	
	void setControllerBottoneIncrementoArmateAttacco(ControllerBottoneIncrementoArmateAttacco controllerBottoneIncrementoArmateAttacco);
	
	void setControllerBottoneDecrementoArmateAttacco(ControllerBottoneDecrementoArmateAttacco controllerBottoneDecrementoArmateAttacco);
	
	void setControllerBottoneFaseSpostamento(ControllerBottoneFaseSpostamento controllerBottoneFaseSpostamento);

	void setControllerBottoneSposta(ControllerBottoneSposta controllerBottoneSposta);
	
	void setControllerBottoneIncrementoArmateSposta(ControllerBottoneIncrementoArmateSposta controllerBottoneIncrementoArmateSposta);
	
	void setControllerBottoneDecrementoArmateSposta(ControllerBottoneDecrementoArmateSposta controllerBottoneDecrementoArmateSposta);
	
	void setControllerBottonePassa(ControllerBottonePassa controllerBottonePassa);
	
	void setControllerMappa(ControllerMappa controllerMappa);
	
	
}

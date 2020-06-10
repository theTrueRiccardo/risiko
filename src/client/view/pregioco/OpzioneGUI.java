package client.view.pregioco;
import client.controller.pregioco.ControllerPreGioco;
import client.view.gioco.GiocoGUI;


public interface OpzioneGUI {
	
	void mostraAggiornamento(String aggiornamento);
	
	void disabilitaBottone(String nomeBottone);
	
	void mostraRisultatoDadoTurno(int faccia);
	
	void apriFinestra();
	
	void chiudiFinestra();
	
	void setControllerBottoneColoreArmate(ControllerPreGioco controllerBottoneColoreArmate);
	
	void setControllerBottoneDadoTurno(ControllerPreGioco controllerBottoneDadoTurno);
	
	void disabilitaColori();
	
	void mostraContoAllaRovescia();
	
	void setGiocoGUI(GiocoGUI giocoGUI);

}

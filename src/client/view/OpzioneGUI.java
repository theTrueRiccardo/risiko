package client.view;

import client.controller.Controller;


public interface OpzioneGUI {
	
	void mostraAggiornamento(String aggiornamento);
	
	void disabilitaBottone(String nomeBottone);
	
	void mostraRisultatoDadoTurno(int faccia);
	
	void apriFinestra();
	
	void chiudiFinestra();
	
	void setControllerBottoneColoreArmate(Controller controllerBottoneColoreArmate);
	
	void setControllerBottoneDado(Controller controllerDado);
	
	void disabilitaColori();
	
	void mostraContoAllaRovescia();
	
	void setGiocoGUI(GiocoGUI giocoGUI);

}

package client.view.pregioco;

import client.controller.pregioco.ControllerPreGioco;

public interface RegistrazioneGUI {
	
	void setControllerBottoneRegistrazione(ControllerPreGioco controllerBottoneRegistrazione);
	
	String getNome();
	
	String getIndirizzoIP();
	
	String getIndirizzoIpServer();
	
	void chiudiFinestra();
	
	void disabilitaBottoneRegistrazione();
	
	void mostraMessaggio(String messaggio);

}

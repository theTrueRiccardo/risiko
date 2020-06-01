package client.view;
import client.controller.Controller;

public interface RegistrazioneGUI {
	
	void setControllerBottoneRegistrazione(Controller controllerBottoneRegistrazione);
	
	String getNome();
	
	String getIndirizzoIP();
	
	String getIndirizzoIpServer();
	
	void chiudiFinestra();
	
	void disabilitaBottoneRegistrazione();
	
	void mostraMessaggio(String messaggio);

}

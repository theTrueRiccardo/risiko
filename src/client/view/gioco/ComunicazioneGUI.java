package client.view.gioco;

import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneApriCodaTelegrammi;
import client.controller.gioco.ControllerBottoneInvia;
import client.controller.gioco.ControllerBottoneInviaTelegramma;

public abstract class ComunicazioneGUI extends JPanel{

	public ComunicazioneGUI() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void report(String report);
	
	public abstract void chat(String messaggio);
	
	public abstract String getMessaggioUtente();
	
	public abstract void setControllerBottoneInvia(ControllerBottoneInvia controllerBottoneInvia);
	
	public abstract void setControllerBottoneInviaTelegramma(ControllerBottoneInviaTelegramma controllerBottoneInviaTelegramma);
	
	public abstract String getDestinatario();
	
	
	public abstract void setControllerBottoneApriCodaTelegrammi(ControllerBottoneApriCodaTelegrammi controllerBottoneApriCodaTelegrammi);
	
	

}

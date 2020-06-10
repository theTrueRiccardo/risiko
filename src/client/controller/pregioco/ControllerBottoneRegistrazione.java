package client.controller.pregioco;

import java.awt.event.ActionEvent;

import client.model.ClientModel;
import client.model.Gioco;
import client.view.pregioco.RegistrazioneGUI;

public class ControllerBottoneRegistrazione extends ControllerPreGioco {

	private RegistrazioneGUI registrazioneGUI;
	
	
	public ControllerBottoneRegistrazione(ClientModel clientModel, Gioco gioco, RegistrazioneGUI registrazioneGUI) {
		super(clientModel,gioco);
		this.registrazioneGUI=registrazioneGUI;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ip = registrazioneGUI.getIndirizzoIP();
		String nomePartecipante = registrazioneGUI.getNome();
		String ipServer = registrazioneGUI.getIndirizzoIpServer();
		if(ipCorretto(ip) && ipCorretto(ipServer)) {
			registrazioneGUI.disabilitaBottoneRegistrazione();
			gioco.setNomePartecipante(nomePartecipante);
			clientModel.registraPartecipante(nomePartecipante,ip,ipServer);
		}
		else {
			registrazioneGUI.mostraMessaggio("Inserisci un indirizzo IP valido");
		}
		
	}
	
	
	private boolean ipCorretto(String ip) {
		return true;
		//TODO
	}

}

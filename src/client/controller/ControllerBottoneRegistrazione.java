package client.controller;

import java.awt.event.ActionEvent;

import client.view.RegistrazioneGUI;

public class ControllerBottoneRegistrazione extends Controller {

	private RegistrazioneGUI registrazioneGUI;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ip = registrazioneGUI.getIndirizzoIP();
		String nomePartecipante = registrazioneGUI.getNome();
		String ipServer = registrazioneGUI.getIndirizzoIpServer();
		System.out.println(ip);
		System.out.println(ipServer);
		if(ipCorretto(ip) && ipCorretto(ipServer)) {
			registrazioneGUI.disabilitaBottoneRegistrazione();
			clientModel.registraPartecipante(nomePartecipante,ip,ipServer);
		}
		else {
			registrazioneGUI.mostraMessaggio("Inserisci un indirizzo IP valido");
		}
		
	}
	
	
	public void setRegistrazioneGUI(RegistrazioneGUI registrazioneGUI) {
		this.registrazioneGUI=registrazioneGUI;
	}
	
	private boolean ipCorretto(String ip) {
		return true;
		//TODO
	}

}

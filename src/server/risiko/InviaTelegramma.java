package server.risiko;

import java.rmi.RemoteException;

import server.Notificatore;

public class InviaTelegramma extends AzioneAstratta {

	public InviaTelegramma(String telegramma,String destinatario,Notificatore notificatore) {
		super(notificatore);
		this.telegramma=telegramma;
		this.destinatario=destinatario;
	}

	private String telegramma,destinatario;
	
	@Override
	public void esegui() {
		try {
			notificatore.notificaTelegramma(telegramma, destinatario);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}

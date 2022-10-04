package server.risiko;

import java.rmi.RemoteException;

import server.Notificatore;

public class InviaMessaggio extends AzioneAstratta{
	
	public InviaMessaggio(String messaggio,Notificatore notificatore) {
		super(notificatore);
		this.messaggio=messaggio;
	}
	
	private String messaggio;

	@Override
	public void esegui() {
		try {
			notificatore.notificaMessaggio(messaggio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}

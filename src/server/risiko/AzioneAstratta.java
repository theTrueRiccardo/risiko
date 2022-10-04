package server.risiko;

import server.Notificatore;

public abstract class AzioneAstratta implements Azione{
	
	protected Notificatore notificatore;
	
	public AzioneAstratta(Notificatore notificatore) {
		this.notificatore=notificatore;
	}

}

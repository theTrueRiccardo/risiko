package utilita;

import java.net.URL;

public class Raccoglitore {

	private final String chitarra = "chitarra.wav";
	private final String dado = "audio.wav";
	private final String panzers = "panzers.wav";
	private final String posizione = "posizione.wav";
	private final String coltello = "coltello.wav";
	private final String anello = "anello.wav";
	private final String messaggio = "messaggio.wav";
	private final String guerra = "guerra.wav";
	
	public URL prendiChitarra(){
		return Raccoglitore.class.getResource(chitarra);
	}
	
	public URL prendiDado() {
		return Raccoglitore.class.getResource(dado);
	}
	
	public URL prendiPanzers() {
		return Raccoglitore.class.getResource(panzers);
	}
	
	public URL prendiPosizione() {
		return Raccoglitore.class.getResource(posizione);
	}
	
	public URL prendiColtello() {
		return Raccoglitore.class.getResource(coltello);
	}
	
	public URL prendiAnello() {
		return Raccoglitore.class.getResource(anello);
	}
	
	public URL prendiMessaggio() {
		return Raccoglitore.class.getResource(messaggio);
	}
	
	public URL prendiGuerra() {
		return Raccoglitore.class.getResource(guerra);
	}

}

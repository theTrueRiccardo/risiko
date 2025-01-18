package utilita;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musica {
	
	private static Raccoglitore raccoglitore = new Raccoglitore();
	
	private Musica() {
	}
	
	public static void suonaDado() {
		try{
			URL url= raccoglitore.prendiDado();
			suona(url,2300000);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	public static void suonaChitarra() {
		try{
			URL url = raccoglitore.prendiChitarra();
			suona(url,2000000);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	public static void suonaPanzers() {
		try {
			URL url = raccoglitore.prendiPanzers();
			suona(url,2000000);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	public static void suonaPosizione() {
		try {
			URL url = raccoglitore.prendiPosizione();
			suona(url,2000000);
		}catch(Exception ex) {ex.printStackTrace();}
	}

	public static void suonaColtello() {
		try {
			URL url = raccoglitore.prendiColtello();
			suona(url,2000000);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	
	public static void suonaAnello() {
		try {
			URL url = raccoglitore.prendiAnello();
			suona(url,3900000);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	
	public static void suonaMessaggio() {
		try {
			URL url = raccoglitore.prendiMessaggio();
			suona(url,1000000);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	
	public static void suonaGuerra() {
		try {
			URL url = raccoglitore.prendiGuerra();
			suona(url,0);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	private static void suona(URL url, int sfasamento) throws Exception {
		AudioInputStream as = AudioSystem.getAudioInputStream(url);
		Clip clip = AudioSystem.getClip();
		clip.open(as);
		clip.setMicrosecondPosition(sfasamento);
		clip.start();
	}
	
	public static void main(String[] args) throws Exception {
		suonaGuerra();
		Thread.sleep(100000000);
  	}
}

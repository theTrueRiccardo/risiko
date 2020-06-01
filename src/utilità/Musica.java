package utilità;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musica {
	
	private static final String URLchitarra ="src//musiche//chitarra.wav";
	
	private static final String URLdado = "src//musiche//audio.wav";

	private Musica() {
	}
	
	public static void suonaDado() {
		try{
			File f = new File("src//musiche//audio.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(f);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.setMicrosecondPosition(2300000);
			clip.start();
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	public static void suonaChitarra() {
		try{
			File f = new File("src//musiche//chitarra.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(f);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.setMicrosecondPosition(2000000);
			clip.start();
		}catch(Exception ex) {ex.printStackTrace();}
	}

}

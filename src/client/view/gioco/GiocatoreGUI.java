package client.view.gioco;
import java.awt.Color;

import javax.swing.*;
public abstract class GiocatoreGUI extends JPanel {
	
	public abstract void settaObbiettivo(String testoObbiettivo);
	
	public abstract void settaColoreArmate(Color colore);
	
	public abstract void settaAttaccante(String attaccante);
	
	public abstract void settaRisultatoAttaccante(String risultatoAttaccante);
	
	public abstract void settaDifensore(String difensore);
	
	public abstract void settaRisultatoDifensore(String risultatoDifensore);
	
	public abstract void settaNazioneDallaAttacco(String nazione);
	
	public abstract void settaNazioneAllaAttacco(String nazione);
	
	public abstract void incrementaCarriAttacco();
	
	public abstract void settaNazioneDallaSpostaPassa(String nazione);
	
	public abstract void settaNazioneAllaSpostaPassa(String nazione);
	
	public abstract void incrementaCarriSpostaPassa();
	
	public abstract void settaArmateDisponibili(String numeroArmate);
	
	public abstract void settaTurnista(String turnista);
	

}

package client.view;

import java.awt.Color;

public interface GiocoGUI {

	void apriFinestra();
	
	void settaObbiettivo(String testoObbiettivo);
	
	void settaColoreArmate(Color colore);
	
	void settaAttaccante(String attaccante);
	
	void settaRisultatoAttaccante(String risultatoAttaccante);
	
	void settaDifensore(String difensore);
	
	void settaRisultatoDifensore(String difensore);
	
	void settaNazioneDallaAttacco(String nazione);
	
	void settaNazioneAllaAttacco(String nazione);
	
	void incrementaCarriAttacco();
	
	void disegnaCarro(Color coloreCarro);
	
	void disegnaBandiera(Color coloreBandiera);
	
	void settaNazioneDallaSpostaPassa(String nazione);
	
	void settaNazioneAllaSpostaPassa(String nazione);
	
	void incrementaCarriSpostaPassa();
	
	void settaArmateDisponibili(String numeroArmate);
	
	void settaTurnista(String turnista);
	
	void mostraMessaggio(String messaggio);
	
	
}

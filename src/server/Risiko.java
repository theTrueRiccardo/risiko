package server;

import java.awt.Color;
import java.util.HashMap;

public interface Risiko {
	
	void inserisciGiocatore(String nomePartecipante);
	
	void assegnaColoreArmate(String nomePartecipante, Color colore);
	
	int tiraDadoTurno(String nomePartecipante);
	
	HashMap<String,Giocatore> avviaGioco();
	
	boolean prontiTutti();
	
	String getTurnista();
	
	String getGiocatoriOrdinati();

}

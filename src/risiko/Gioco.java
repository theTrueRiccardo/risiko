package risiko;

import risiko.ElementiDelGioco.*;
import server.Giocatore;

public interface Gioco {
	
	void attacca(Giocatore turnista, Giocatore difensore, Territorio da, Territorio a, int numeroDadi);
	
	void posizionaCarri(Giocatore turnista, int numeroCarri, Territorio territorio);
	
	void posizionaBandiere(Giocatore turnista, int numeroBandiere, Territorio territorio);
	
	void lanciaDadoDelTurno(Giocatore turnista);
	
	void pescaCartaObbiettivo(Giocatore turnista);
	
	void ottieniTerritoriIniziali(Giocatore turnista);
	
	void pescaCartaTerritorio(Giocatore turnista);
	
	void passa(Giocatore turnista);
	
	void inizializza(HashMap<String,String>);

}

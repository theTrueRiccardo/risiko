package server.risiko.obbiettivi;

import server.risiko.Giocatore;
import server.risiko.mappa.Continente;

public class ConquistareNordAmericaEOceania extends ObbiettivoAstratto{

	public ConquistareNordAmericaEOceania(String testo) {
		super(testo);
		
	}

	@Override
	public boolean eSoddisfatto(Giocatore giocatore) {
		return giocatore.possiedeContinente(Continente.AMERICA_DEL_NORD)
				&& giocatore.possiedeContinente(Continente.OCEANIA);
	}

}

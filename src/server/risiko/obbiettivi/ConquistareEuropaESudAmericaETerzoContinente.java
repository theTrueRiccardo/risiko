package server.risiko.obbiettivi;

import server.risiko.Giocatore;
import server.risiko.mappa.Continente;

public class ConquistareEuropaESudAmericaETerzoContinente extends ObbiettivoAstratto{

	public ConquistareEuropaESudAmericaETerzoContinente(String testo) {
		super(testo);
	}

	@Override
	public boolean eSoddisfatto(Giocatore giocatore) {
		if(!giocatore.possiedeContinente(Continente.EUROPA)) return false;
		if(!giocatore.possiedeContinente(Continente.AMERICA_DEL_SUD)) return false;
		return giocatore.possiedeContinente(Continente.AFRICA)
				|| giocatore.possiedeContinente(Continente.AMERICA_DEL_NORD) ||
				giocatore.possiedeContinente(Continente.OCEANIA) ||
				giocatore.possiedeContinente(Continente.ASIA);
	}

	
	

}

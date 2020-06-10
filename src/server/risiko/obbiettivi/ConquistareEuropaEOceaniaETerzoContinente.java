package server.risiko.obbiettivi;

import server.risiko.Giocatore;
import server.risiko.mappa.Continente;

public class ConquistareEuropaEOceaniaETerzoContinente extends ObbiettivoAstratto{

	
	public ConquistareEuropaEOceaniaETerzoContinente(String testo) {
		super(testo);
	}

	
	@Override
	public boolean eSoddisfatto(Giocatore giocatore) {
		if(!giocatore.possiedeContinente(Continente.EUROPA)) return false;
		if(!giocatore.possiedeContinente(Continente.OCEANIA)) return false;
		return giocatore.possiedeContinente(Continente.AFRICA)
				|| giocatore.possiedeContinente(Continente.AMERICA_DEL_NORD) ||
				giocatore.possiedeContinente(Continente.AMERICA_DEL_SUD) ||
				giocatore.possiedeContinente(Continente.ASIA);
	}
	

}

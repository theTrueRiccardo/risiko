package server.risiko.obbiettivi;

import server.risiko.Giocatore;
import server.risiko.mappa.Continente;

public class ConquistareNordAmericaEAfrica extends ObbiettivoAstratto{

	public ConquistareNordAmericaEAfrica(String testo) {
		super(testo);
		
	}

	@Override
	public boolean eSoddisfatto(Giocatore giocatore) {
		return giocatore.possiedeContinente(Continente.AMERICA_DEL_NORD)
				&& giocatore.possiedeContinente(Continente.AFRICA);
	}

}

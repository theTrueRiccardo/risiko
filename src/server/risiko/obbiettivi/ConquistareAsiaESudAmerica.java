package server.risiko.obbiettivi;

import server.risiko.Giocatore;
import server.risiko.mappa.Continente;

public class ConquistareAsiaESudAmerica extends ObbiettivoAstratto{

	public ConquistareAsiaESudAmerica(String testo) {
		super(testo);
		
	}

	@Override
	public boolean eSoddisfatto(Giocatore giocatore) {
		return giocatore.possiedeContinente(Continente.ASIA) && giocatore.possiedeContinente(Continente.AMERICA_DEL_SUD);
	}


}

package server.risiko.obbiettivi;

import server.risiko.Giocatore;

public class Conquistare24Territori extends ObbiettivoAstratto{

	public Conquistare24Territori(String testo) {
		super(testo);
	}
	
	@Override
	public boolean eSoddisfatto(Giocatore giocatore) {
		return giocatore.getNumeroNazioni() >= 24;
	}

}

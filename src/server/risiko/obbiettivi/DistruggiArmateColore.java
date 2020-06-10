package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Giocatore;
import server.risiko.Risiko;

public abstract class DistruggiArmateColore extends ObbiettivoAstratto{
	
	protected Color coloreArmate;
	
	protected Risiko risiko;

	public DistruggiArmateColore(String testo, Risiko risiko) {
		super(testo);
		this.risiko=risiko;
	}
	
	
	@Override
	public boolean eSoddisfatto(Giocatore giocatore) {
		Giocatore giocatoreVittima = risiko.getGiocatorePerColore(coloreArmate);
		if(giocatore.isTurnista() && giocatoreVittima.getNazioniArmate().size()==0) return true;
		return false;
	}
	
}

package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateGialle extends DistruggiArmateColore{

	public DistruggiArmateGialle(String testo, Risiko risiko) {
		super(testo, risiko);
		this.coloreArmate=Color.YELLOW;
	}


}

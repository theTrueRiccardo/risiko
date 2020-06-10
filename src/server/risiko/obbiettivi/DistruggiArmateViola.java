package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateViola extends DistruggiArmateColore{

	public DistruggiArmateViola(String testo, Risiko risiko) {
		super(testo, risiko);
		this.coloreArmate = new Color(102,0,153);
	}

	
}

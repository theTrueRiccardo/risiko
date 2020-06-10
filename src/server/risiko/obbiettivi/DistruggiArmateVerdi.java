package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateVerdi extends DistruggiArmateColore{

	public DistruggiArmateVerdi(String testo, Risiko risiko) {
		super(testo, risiko);
		this.coloreArmate=Color.GREEN;
	}

	

}

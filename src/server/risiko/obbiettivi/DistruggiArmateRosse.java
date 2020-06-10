package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateRosse extends DistruggiArmateColore{

	public DistruggiArmateRosse(String testo, Risiko risiko) {
		super(testo, risiko);
		this.coloreArmate=Color.RED;
	}

	

}

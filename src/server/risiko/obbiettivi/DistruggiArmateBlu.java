package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateBlu extends DistruggiArmateColore {

	public DistruggiArmateBlu(String testo, Risiko risiko) {
		super(testo, risiko);
		this.coloreArmate=Color.BLUE;
	}

	

}

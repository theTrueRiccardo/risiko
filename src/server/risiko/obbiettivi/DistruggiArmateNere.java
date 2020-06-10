package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateNere extends DistruggiArmateColore{

	public DistruggiArmateNere(String testo, Risiko risiko) {
		super(testo, risiko);
		this.coloreArmate = Color.BLACK;
	}

	

}

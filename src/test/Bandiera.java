package test;

import java.awt.Color;

public class Bandiera extends Armata{

	public Bandiera(double percx, double percy, Color colore) {
		super(percx, percy, colore);
	}
	
	public Bandiera(Bandiera bandiera) {
		super(bandiera);
	}

	@Override
	public int valoreNumerico() {
		return 10;
	}
	
	

}

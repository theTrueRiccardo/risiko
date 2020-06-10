package test;

import java.awt.Color;

public class Carro extends Armata{
	
	public Carro(double percx, double percy, Color colore) {
		super(percx, percy, colore);
	}
	
	public Carro(Carro carro) {
		super(carro);
	}

	
	@Override
	public int valoreNumerico() {
		return 1;
	}
	
	
	
}

package test;

import java.awt.Color;

public abstract class Armata extends ElementoDelGioco{

	private double percx, percy;
	
	private Color colore;
	
	public double getPercx() {
		return percx;
	}
	
	public double Percy() {
		return percy;
	}
	
	public Color getColore() {
		return new Color(colore.getRed(), colore.getGreen(), colore.getRGB());
	}
	
	public Armata(double percx, double percy, Color colore) {
		this.percx=percx;
		this.percy=percy;
		this.colore = new Color(colore.getRed(), colore.getGreen(), colore.getBlue());
	}
	
	
	public Armata(Armata armata) {
		this.percx=armata.percx;
		this.percy=armata.percy;
		this.colore = new Color(armata.colore.getRed(), armata.colore.getGreen(), armata.colore.getBlue());
	}
	
	
	public abstract int valoreNumerico();
}

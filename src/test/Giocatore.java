package test;

import java.awt.Color;
import java.util.BitSet;

public class Giocatore {
	
	private String nome;
	
	private Color coloreArmate;
	
	private int armateSullaMappa;
	
	private Obbiettivo obbiettivo;
	
	private BitSet possedimenti = new BitSet(42);
	
	private BitSet giocatoriUccisi = new BitSet(GiocoServer.numPartecipanti);
	
	
	public boolean haVinto() {
		return obbiettivo.verifica(this);
	}
	
	
	public BitSet getPossedimenti() {
		return (BitSet)possedimenti.clone();
	}
	
	public BitSet getGiocatoriUccisi() {
		return (BitSet)giocatoriUccisi.clone();
	}
	
	public String getNome() {
		return new String(nome);
	}
	
	public void setColoreArmate(Color coloreArmate) {
		this.coloreArmate=coloreArmate;
	}
	
	
	public boolean equals(Object o) {
		if(!(o instanceof Giocatore)) return false;
		if(o == this) return true;
		Giocatore g = (Giocatore)o;
		return nome.equals(g.nome);
	}
}

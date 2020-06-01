package server;
import java.awt.Color;
import java.util.*;

import risiko.CartaObbiettivo;
import risiko.CartaTerritorio;
public class Giocatore {
	
	private String nome;
	
	private Color coloreArmate;
	
	private Integer dadoTurno;
	
	private boolean turnista;
	
	private int armateDisponibili =30;
	
	private Obbiettivo obbiettivo;
	
	public Giocatore(String nome) {
		this.nome=nome;
	}
	
	
	public int getDadoTurno() {
		return dadoTurno;
	}


	public void setDadoTurno(int dadoTurno) {
		this.dadoTurno = dadoTurno;
	}


	public Color getColoreArmate() {
		return coloreArmate;
	}


	public void setColoreArmate(Color coloreArmate) {
		this.coloreArmate = coloreArmate;
	}


	public String getNome() {
		return nome;
	}
	
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public boolean isTurnista() {
		return turnista;
	}
	
	
	
	
	public void setTurnista(boolean turnista) {
		this.turnista = turnista;
	}
	
	
	public int getArmateDisponibili() {
		return armateDisponibili;
	}

	
	

	public void setArmateDisponibili(int armateDisponibili) {
		this.armateDisponibili = armateDisponibili;
	}

	
	
	

	public Obbiettivo getObbiettivo() {
		return obbiettivo;
	}


	
	
	public void setObbiettivo(Obbiettivo obbiettivo) {
		this.obbiettivo = obbiettivo;
	}


	
	
	
	public boolean pronto() {
		return dadoTurno!=null && coloreArmate!=null;
	}
	
	

}

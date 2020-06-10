package test;

import java.util.HashSet;

public class Continente extends ElementoConNome{

	private int rinforzi;
	
	private HashSet<Nazione> nazioni;
	
	public Continente(String nome, int rinforzi, HashSet<Nazione> nazioni) {
		super(nome);
		this.rinforzi=rinforzi;
		nazioni = new HashSet<Nazione>(nazioni);
	}
	
	public int getRinforzi() {
		return rinforzi;
	}
	
	public boolean siComponeDi(HashSet<Nazione> nazioni) {
		return this.nazioni.containsAll(nazioni);
	}
	
	

}

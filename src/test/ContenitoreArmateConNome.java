package test;

import java.util.HashSet;

public abstract class ContenitoreArmateConNome extends ElementoConNome {
	

	private HashSet<Carro> carri;
	
	private HashSet<Bandiera> bandiere;
	
	
	public ContenitoreArmateConNome(String nome) {
		super(nome);
		carri = new HashSet<Carro>();
		bandiere = new HashSet<Bandiera>();
	}
	

	public int getNumeroArmate() {
		return carri.size() + bandiere.size();
	}
	
	public int getValoreNumericoArmate() {
		int valore = 0;
		for(Carro carro: carri) {
			valore += carro.valoreNumerico();
		}
		for(Bandiera bandiera : bandiere) {
			valore += bandiera.valoreNumerico();
		}
		return valore;
	}
	
	public void aggiungiCarro(Carro carro) {
		carri.add(new Carro(carro));
	}
	
	public void aggiungiBandiera(Bandiera bandiera) {
		bandiere.add(new Bandiera(bandiera));
	}
	
	
	public void eliminaCarri(int numCarri) {
		if(numCarri > carri.size()) throw new RuntimeException("stai eliminando più carri di quelli che ci sono");
		for(Carro carro : carri) {
			if(numCarri==0) break;
			carri.remove(carro);
			numCarri--;
		}
	}
	
	
	public void eliminaBandiere(int numBandiere) {
		if(numBandiere > bandiere.size()) throw new RuntimeException("stai eliminando più bandiere di quelle che ci ne sono");
		for(Bandiera bandiera: bandiere) {
			if(numBandiere==0) break;
			bandiere.remove(bandiera);
			numBandiere--;
		}
	}

}

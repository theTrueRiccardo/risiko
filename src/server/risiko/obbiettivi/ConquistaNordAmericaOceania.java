package server.risiko.obbiettivi;

import java.util.BitSet;

import server.risiko.Risiko;

public class ConquistaNordAmericaOceania implements Obbiettivo{
	
	private String testo = "Devi conquistare Nord America e Oceania";
			
	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		BitSet cont1 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		BitSet cont2 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		cont1.and(Risiko.America_Del_Nord);
		cont2.and(Risiko.Oceania);
		return cont1.equals(Risiko.America_Del_Nord) && cont2.equals(Risiko.Oceania);
	}
			

	
	private int indiceObbiettivo() {
		for(int i = 0; i < Risiko.obbiettivi.length; i++) {
			if(Risiko.obbiettivi[i].equals(testo)) return i;
		}
		return -1;
	}
	
	private int indiceGiocatore(int i) {
		for(int j = 0; j < Risiko.numGiocatori; j++) {
			if(Risiko.obbiettiviGiocatori.get(j)==i)return j;
		}
		return -1;
	}

}

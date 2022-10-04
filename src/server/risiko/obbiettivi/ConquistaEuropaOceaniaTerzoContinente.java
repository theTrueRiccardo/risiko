package server.risiko.obbiettivi;

import java.util.BitSet;

import server.risiko.Risiko;

public class ConquistaEuropaOceaniaTerzoContinente implements Obbiettivo{

	
	private String testo = "Devi conquistare Europa, Oceania e un terzo continente a tua scelta";
			
	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		BitSet cont1 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		BitSet cont2 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		cont1.and(Risiko.Europa);
		cont2.and(Risiko.Oceania);
		if(!cont1.equals(Risiko.Europa) || !cont2.equals(Risiko.Oceania))return false;
		BitSet cont3 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		BitSet cont4 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		BitSet cont5 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		BitSet cont6 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		cont3.and(Risiko.Asia);
		cont4.and(Risiko.Africa);
		cont5.and(Risiko.America_Del_Nord);
		cont6.and(Risiko.America_Del_Sud);
		return cont3.equals(Risiko.Asia) || cont4.equals(Risiko.Africa) || cont5.equals(Risiko.America_Del_Nord) || cont6.equals(Risiko.America_Del_Sud);
		
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

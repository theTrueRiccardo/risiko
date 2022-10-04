package server.risiko.obbiettivi;

import java.util.BitSet;

import server.risiko.Risiko;

public class ConquistaAsiaAfrica implements Obbiettivo{
	
	private String testo = "Devi conquistare Asia e Africa";
			

	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		BitSet cont1 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		BitSet cont2 = (BitSet)Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).clone();
		cont1.and(Risiko.Asia);
		cont2.and(Risiko.Africa);
		return cont1.equals(Risiko.Asia) && cont2.equals(Risiko.Africa);
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

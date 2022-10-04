package server.risiko.obbiettivi;

import server.risiko.Risiko;

public class Conquista24Territori implements Obbiettivo{
	
	private String testo = "Devi conquistare 24 territori";
	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
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

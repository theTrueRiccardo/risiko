package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateNere implements Obbiettivo{
	
	private String testo = "Devi distruggere le armate nere. Se sei tu stesso il proprietario delle armate nere o nessuno ha (più) le armate nere, devi conquistare 24 territori";
			
	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		int indiceProprietarioArmateNere = indiceProprietarioArmateNere();
		if(indiceGiocatorePosseditore==indiceProprietarioArmateNere) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		if(!Risiko.vitaGiocatori.get(indiceProprietarioArmateNere) && !Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateNere)) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		return !Risiko.vitaGiocatori.get(indiceProprietarioArmateNere) && Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateNere);
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
	
	
	private int indiceProprietarioArmateNere() {
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.coloriGiocatori.get(i).equals(Color.BLACK)) return i;
		}
		return -1;
	}

}

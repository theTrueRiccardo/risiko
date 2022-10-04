package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateVerdi implements Obbiettivo{

	private String testo = "Devi distruggere le armate verdi. Se sei tu stesso il proprietario delle armate verdi o nessuno ha (più) le armate verdi, devi conquistare 24 territori";
			
	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		int indiceProprietarioArmateVerdi = indiceProprietarioArmateVerdi();
		if(indiceGiocatorePosseditore==indiceProprietarioArmateVerdi) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		if(!Risiko.vitaGiocatori.get(indiceProprietarioArmateVerdi) && !Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateVerdi)) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		return !Risiko.vitaGiocatori.get(indiceProprietarioArmateVerdi) && Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateVerdi);
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
	
	
	private int indiceProprietarioArmateVerdi() {
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.coloriGiocatori.get(i).equals(Color.GREEN)) return i;
		}
		return -1;
	}

}

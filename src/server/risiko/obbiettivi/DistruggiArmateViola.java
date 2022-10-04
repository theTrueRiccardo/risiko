package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateViola implements Obbiettivo{
	
	private String testo = "Devi distruggere le armate viola. Se sei tu stesso il proprietario delle armate viola o nessuno ha (più) le armate viola, devi conquistare 24 territori";
			
	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		int indiceProprietarioArmateViola = indiceProprietarioArmateViola();
		if(indiceGiocatorePosseditore==indiceProprietarioArmateViola) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		if(!Risiko.vitaGiocatori.get(indiceProprietarioArmateViola) && !Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateViola)) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		return !Risiko.vitaGiocatori.get(indiceProprietarioArmateViola) && Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateViola);
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
	
	
	private int indiceProprietarioArmateViola() {
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.coloriGiocatori.get(i).equals(new Color(102,0,153))) return i;
		}
		return -1;
	}

}

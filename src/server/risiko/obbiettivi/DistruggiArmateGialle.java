package server.risiko.obbiettivi;

import java.awt.Color;

import server.risiko.Risiko;

public class DistruggiArmateGialle implements Obbiettivo{
	
	private String testo = "Devi distruggere le armate gialle. Se sei tu stesso il proprietario delle armate gialle o nessuno ha (più) le armate gialle, devi conquistare 24 territori";
			

	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		int indiceProprietarioArmateGialle = indiceProprietarioArmateGialle();
		if(indiceGiocatorePosseditore==indiceProprietarioArmateGialle) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		if(!Risiko.vitaGiocatori.get(indiceProprietarioArmateGialle) && !Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateGialle)) return Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore).cardinality()>=24;
		return !Risiko.vitaGiocatori.get(indiceProprietarioArmateGialle) && Risiko.giocatoriUccisiGiocatori.get(indiceGiocatorePosseditore).get(indiceProprietarioArmateGialle);
	}
	
	private int indiceObbiettivo() {
		for(int i = 0; i < Risiko.obbiettivi.length; i++) {
			if(Risiko.obbiettivi[i].equals(testo)) return i;
		}
		System.out.println("Obbiettivo armate gialle non troavto");
		return -1;
	}
	
	private int indiceGiocatore(int i) {
		for(int j = 0; j < Risiko.numGiocatori; j++) {
			if(Risiko.obbiettiviGiocatori.get(j)==i)return j;
		}
		System.out.println("indice giocatore posseditore obbiettivo non trovato");
		return -1;
	}
	
	
	private int indiceProprietarioArmateGialle() {
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.coloriGiocatori.get(i).equals(Color.YELLOW))return i;
		}
		System.out.println("Indice proprietario armate gialle non trovato");
		return -1;
	}
}

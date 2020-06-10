package server.risiko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import server.risiko.obbiettivi.Obbiettivo;

public class RisikoUtils {
	
	public static Obbiettivo[] distribuisciObbiettivi(String[] giocatori, Obbiettivo[] obbiettivi) {
		Obbiettivo[] risultato = new Obbiettivo[giocatori.length];
		ArrayList<Obbiettivo> obb = new ArrayList<Obbiettivo>(Arrays.asList(obbiettivi));
		Random r = new Random();
		for(int i = 0; i < risultato.length; i++) {
			int indice = r.nextInt(obb.size());
			risultato[i]=obb.get(indice);
			obb.remove(indice);
		}
		return risultato;
	}
	
	
	
	public static void assegnaTerritori(String[] proprietari, String[] nazioni, String[] giocatori) {
		ArrayList<String> naz = new ArrayList<String>(Arrays.asList(nazioni));
		int i = 0;
		Random r = new Random();
		while(!naz.isEmpty()) {
			String giocatore = giocatori[i]; //pigli un giocatore
			int indice = r.nextInt(naz.size()); //prendi una nazione a caso fra le disponibili
			String nazione = naz.get(indice);
			naz.remove(indice); //la cacci dalle disponibili perchè la stai per assegnare
			for(int j = 0; j < nazioni.length; j++) {
				if(nazioni[j].equals(nazione)) {
					indice=j;
					break;
				}
			}
			proprietari[indice] = giocatore; //assegna
			i= (i+1)%giocatori.length;//passa all'altro giocatore
		}
		
	}

}

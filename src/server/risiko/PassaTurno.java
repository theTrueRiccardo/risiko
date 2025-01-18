package server.risiko;

import java.rmi.RemoteException;
import java.util.BitSet;
import java.util.HashSet;

import server.Notificatore;
import utilita.CustodiaCarte;

public class PassaTurno extends AzioneAstratta{
	
	private boolean fattaCombinazione=false;
	private String combinazioneFatta="";
	private int codiceCombinazione=0;

	public PassaTurno(Notificatore notificatore) {
		super(notificatore);
	}

	@Override
	public void esegui() {
		int indice = 0;
		int nuovoIndice=0;
		BitSet bs = new BitSet(Risiko.numGiocatori);
		bs.set(0, Risiko.numGiocatori);
		do {
			indice = indiceTurnista();
			cambiaTurnista(indice);
			nuovoIndice = indiceTurnista();
		}while(Risiko.fineFasePre.get(nuovoIndice) && !(Risiko.fineFasePre.cardinality()==bs.cardinality()));//qualcuno potrebbe aver finito la pre e quindi lo si salta
		try {
			if(Risiko.fineFasePre.cardinality()==bs.cardinality()) {
				int rinforzi = calcolaRinforzi();
				notificatore.notificaPassaggioTurno(Risiko.turnista, rinforzi,fattaCombinazione,combinazioneFatta,codiceCombinazione);
				System.out.println("passaggio turno a "+Risiko.turnista);
				System.out.println(Risiko.turnista+ " prende "+rinforzi+" armate di rinforzo");
				if(fattaCombinazione)System.out.println("Ha fatto una combinazione");
				else System.out.println("Non ha fatto combinazioni");
				System.out.println("Codice combinazione (include la non combinazione): "+ codiceCombinazione);
				
			}
			else{
				System.out.println("passaggio turno pre a "+Risiko.turnista);
				notificatore.notificaPassaggioTurnoPre(Risiko.turnista);
			}
			System.out.println();
			System.out.println();
			situazioneAttuale();
		} catch (RemoteException e) {e.printStackTrace();}
	}
	
	
	private int indiceTurnista() {
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.giocatori.get(Risiko.indiceGiocatoriOrdinati[i]).equals(Risiko.turnista)) {
				return i;
			}
		}
		return -1;
	}
	
	
	private void cambiaTurnista(int indice) {
		Risiko.primaConquistaTurnoGiocatori.set(indice);
		indice = (indice + 1) % Risiko.numGiocatori;
		Risiko.turnista = Risiko.giocatori.get(Risiko.indiceGiocatoriOrdinati[indice]);
	}
	
	
	private int calcolaRinforzi() {
		System.out.println();
		int indiceTurnista=Risiko.giocatori.indexOf(Risiko.turnista);
		int numPossedimenti = Risiko.nazioniGiocatori.get(Risiko.giocatori.indexOf(Risiko.turnista)).cardinality();
		int base = numPossedimenti/3;
		System.out.println(Risiko.turnista +" ha "+numPossedimenti+" territori");
		int continenti=0;
		int combinazioni=0;
		BitSet possedimenti=(BitSet)Risiko.nazioniGiocatori.get(indiceTurnista).clone();
		possedimenti.and(Risiko.Africa);
		if(possedimenti.equals(Risiko.Africa)) {
			continenti+=3;
			System.out.println(Risiko.turnista+" posside l'Africa");
		}
		possedimenti=(BitSet)Risiko.nazioniGiocatori.get(indiceTurnista).clone();
		possedimenti.and(Risiko.Oceania);
		if(possedimenti.equals(Risiko.Oceania)) {
			continenti+=2;
			System.out.println(Risiko.turnista+" possiede l'Oceania");
		}
		possedimenti=(BitSet)Risiko.nazioniGiocatori.get(indiceTurnista).clone();
		possedimenti.and(Risiko.America_Del_Sud);
		if(possedimenti.equals(Risiko.America_Del_Sud)) {
			continenti+=2;
			System.out.println(Risiko.turnista+" possiede l'America del sud");
		}
		possedimenti=(BitSet)Risiko.nazioniGiocatori.get(indiceTurnista).clone();
		possedimenti.and(Risiko.America_Del_Nord);
		if(possedimenti.equals(Risiko.America_Del_Nord)) {
			continenti+=5;
			System.out.println(Risiko.turnista+" possiede l'America del nord");
		}
		possedimenti=(BitSet)Risiko.nazioniGiocatori.get(indiceTurnista).clone();
		possedimenti.and(Risiko.Europa);
		if(possedimenti.equals(Risiko.Europa)) {
			continenti+=5;
			System.out.println(Risiko.turnista+" possiede l'Europa");
		}
		possedimenti=(BitSet)Risiko.nazioniGiocatori.get(indiceTurnista).clone();
		possedimenti.and(Risiko.Asia);
		if(possedimenti.equals(Risiko.Asia)) {
			continenti+=7;
			System.out.println(Risiko.turnista+" possiede l'Asia");
		}
		CustodiaCarte cc=Risiko.cartePosseduteAttualmenteDaiGiocatori[indiceTurnista];
		CustodiaCarte.Combinazione combinazione=cc.submitCombinazione();
		System.out.println(Risiko.turnista+" ha questa combinazione: "+combinazione);
		combinazioni=combinazione.getValore();
		System.out.println("Le armate che da questa combinazione sono "+combinazioni);
		HashSet<Integer>indiciCarteCacciate=cc.getIndiciCarteAppenaTolte();
		for(Integer i:indiciCarteCacciate)Risiko.carteDate.flip(i);
		indiciCarteCacciate.clear();
		if(combinazione!=CustodiaCarte.Combinazione.NESSUNA_COMBINAZIONE) {
			fattaCombinazione=true;
			combinazioneFatta=combinazione.toString();
			codiceCombinazione=combinazione.ordinal()+cc.getOffset();
		}
		return base+continenti+combinazioni;
	}
	
	
	private void situazioneAttuale() {
		System.out.println("SITUAZIONE ATTUALE:");
		System.out.println();
		System.out.println("Armate sulle nazioni:");
		for(int i=0;i<42;i++) {
			System.out.println(Risiko.nazioni.get(i)+"     "+Risiko.armateSulleNazioni[i]);
		}
		System.out.println();
		System.out.println("Armate giocatori sulla mappa:");
		for(int i=0;i<Risiko.numGiocatori;i++) {
			System.out.println(Risiko.giocatori.get(i)+" ha sulla mappa un totale di "+Risiko.armateGiocatoriSullaMappa[i] + " armate");
		}
		System.out.println();
		System.out.println("Possedimenti giocatori:");
		for(int i=0;i<Risiko.numGiocatori;i++) {
			System.out.println(Risiko.giocatori.get(i)+":");
			for(int j=0;j<42;j++) {
				if(Risiko.nazioniGiocatori.get(i).get(j))System.out.println("     "+Risiko.nazioni.get(j));
			}
		}
		System.out.println();
		System.out.println("Giocatori uccisi da altri giocatori:");
		for(int i=0;i<Risiko.numGiocatori;i++) {
			System.out.println(Risiko.giocatori.get(i)+" ha ucciso:");
			for(int j=0;j<Risiko.numGiocatori;j++) {
				if(Risiko.giocatoriUccisiGiocatori.get(i).get(j))System.out.println("     "+Risiko.giocatori.get(j));
			}
		}
		
		System.out.println();
		System.out.println();
	}

}

package server.risiko;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Random;

import server.Notificatore;

public class Attacco extends AzioneAstratta{
	
	public Attacco(String nazioneDA, String nazioneA, int armateImpiegate,Notificatore notificatore) {
		super(notificatore);
		this.nazioneA=nazioneA;
		this.nazioneDA=nazioneDA;
		this.armateImpiegate=armateImpiegate;
	}

	private String nazioneA,nazioneDA;
	private int armateImpiegate;
	
	
	private int indiceNazioneDA,indiceNazioneA,indiceAttaccante,indiceDifensore;
	
	private String attaccante,difensore;
	
	private int[] dadiRossi, dadiBlu;
	
	private int armateInDifesa;

	private int perditeAttacco, perditeDifesa;
	
	private boolean conquista = false, daiCarta=false;
	
	
	@Override
	public void esegui() {
		indiceNazioneDA = prendiIndiceNazioneDA();
		indiceNazioneA= prendiIndiceNazioneA();
		indiceAttaccante=prendiIndiceAttaccante();
		indiceDifensore=prendiIndiceDifensore();
		attaccante = Risiko.giocatori.get(indiceAttaccante);
		difensore = Risiko.giocatori.get(indiceDifensore);
		armateInDifesa = calcolaArmateInDifesa();
		System.out.println(attaccante +" sta attaccando "+difensore+" da "+nazioneDA +" a "+nazioneA+".\nL'attaccante attacca con "+armateImpiegate+", il difensore difende con  "+ armateInDifesa);
		dadiRossi = lanciaDadi(armateImpiegate);
		dadiBlu = lanciaDadi(armateInDifesa);
		System.out.println("Dadi rossi: "+Arrays.toString(dadiRossi));
		System.out.println("Dadi blu: "+Arrays.toString(dadiBlu));
		calcolaPerdite();
		notificaRisultato();
		if(conquista) {
			try {
				notificatore.notificaConquistaNazione(nazioneA, attaccante);
			} catch (RemoteException e) {e.printStackTrace();}
		}
		if(daiCarta) {
			boolean ok=false;
			Random r=new Random();
			do {
				int indiceCarta=r.nextInt(44);
				if(!Risiko.carteDate.get(indiceCarta)) {//se non è stata data
					Risiko.carteDate.set(indiceCarta);
					String carta=Risiko.carte.get(indiceCarta);
					Risiko.cartePosseduteAttualmenteDaiGiocatori[indiceAttaccante].inserisciCarta(indiceCarta, carta);
					try {
						notificatore.notificaCarta(attaccante, carta);
					} catch (Exception e) {
						e.printStackTrace();
					}//dai la carta
					ok=true;
					daiCarta=false;
					System.out.println(attaccante +" ottiene "+carta);
				}
			}while(!ok);
		}
	}
	
	
	private int[] lanciaDadi(int armateImpiegate) {
		int[] ris = new int[armateImpiegate];
		Random r = new Random();
		for(int i = 0; i < ris.length; i++) {
			ris[i] = r.nextInt(6)+1;
		}
		boolean scambi = true;
		while(scambi) {
			scambi = false;
			for(int i = 0; i < ris.length-1; i++) {
				int park = 0;
				if(ris[i]<ris[i+1]) {
					scambi = true;
					park = ris[i+1];
					ris[i+1] = ris[i];
					ris[i] = park;
				}
			}
		}
		return ris;
	}
	
	
	private int prendiIndiceNazioneDA() {
		int indice = -1;
		for(int i = 0; i < Risiko.nazioni.size(); i++) {
			if(Risiko.nazioni.get(i).equals(nazioneDA)) indice= i;
		}
		return indice;
	}
	
	
	
	private int prendiIndiceNazioneA() {
		int indice = -1;
		for(int i = 0; i < Risiko.nazioni.size(); i++) {
			if(Risiko.nazioni.get(i).equals(nazioneA)) indice= i;
		}
		return indice;
	}
	
	
	private int prendiIndiceAttaccante() {
		int indice = -1;
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.nazioniGiocatori.get(i).get(indiceNazioneDA)) indice=i;
		}
		return indice;
	}
	
	private int prendiIndiceDifensore() {
		int indice = -1;
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.nazioniGiocatori.get(i).get(indiceNazioneA)) indice=i;
		}
		return indice;
	}
	
	private int calcolaArmateInDifesa() {
		int ris = 0;
		if(Risiko.armateSulleNazioni[indiceNazioneA]>=3) ris=3;
		else ris = Risiko.armateSulleNazioni[indiceNazioneA];
		return ris;
	}
	
	
	private void notificaRisultato() {
		String risultatoAttaccante="",risultatoDifensore="";
		for(int i = 0; i < dadiRossi.length; i++) {
			risultatoAttaccante += dadiRossi[i]+"  ";
		}
		for(int j = 0; j < dadiBlu.length; j++) {
			risultatoDifensore += dadiBlu[j] +"  ";
		}
		try {
			notificatore.notificaRisultatoBattaglia(attaccante, difensore, risultatoAttaccante, risultatoDifensore,Risiko.armateSulleNazioni,Risiko.nazioniGiocatori.get(indiceAttaccante), Risiko.nazioniGiocatori.get(indiceDifensore));
			notificatore.notificaCancellamentoArmate(perditeAttacco, nazioneDA);//pessimo design: sarebbe molto meglio asservire completamente mvc e lasciare al model del client il compito di notificare la vista
			notificatore.notificaCancellamentoArmate(perditeDifesa, nazioneA);
		} catch (RemoteException e) {e.printStackTrace();}
	}
	
	
	private void calcolaPerdite() {
		perditeAttacco = 0; perditeDifesa = 0;
		int limite = (dadiRossi.length < dadiBlu.length) ? dadiRossi.length : dadiBlu.length;
		for(int i = 0; i < limite; i++) {
			if(dadiBlu[i]>=dadiRossi[i]) perditeAttacco++;
			else perditeDifesa++;
		}
		System.out.println(attaccante +" ne perde "+ perditeAttacco + ", "+difensore+" ne perde "+perditeDifesa);
		Risiko.armateSulleNazioni[indiceNazioneA]-=perditeDifesa;
		Risiko.armateSulleNazioni[indiceNazioneDA]-=perditeAttacco;
		Risiko.armateGiocatoriSullaMappa[indiceAttaccante]-=perditeAttacco;
		Risiko.armateGiocatoriSullaMappa[indiceDifensore]-=perditeDifesa;
		if(Risiko.armateGiocatoriSullaMappa[indiceDifensore]==0) {
			Risiko.vitaGiocatori.flip(indiceDifensore);
			Risiko.giocatoriUccisiGiocatori.get(indiceAttaccante).set(indiceDifensore);
			System.out.println(attaccante + " ha ucciso "+difensore);
		}
		if(Risiko.armateSulleNazioni[indiceNazioneA]==0) {
			Risiko.nazioniGiocatori.get(indiceDifensore).flip(indiceNazioneA);
			Risiko.nazioniGiocatori.get(indiceAttaccante).set(indiceNazioneA);
			conquista = true;
			if(Risiko.primaConquistaTurnoGiocatori.get(indiceAttaccante)) {
				daiCarta=true;
				Risiko.primaConquistaTurnoGiocatori.flip(indiceAttaccante);
			}
			System.out.println(attaccante + " ha conquistato "+ nazioneA);
		}

	}
	
	

}

package server.risiko;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Random;

import server.Notificatore;
import utilita.GloboGrafico;
import utilita.GloboGraficoConcreto;
import utilita.NazioneGrafica;
import utilita.Rettangolo;

public class AvviaGioco extends AzioneAstratta{
	
	private int[] armate;

	public AvviaGioco(Notificatore notificatore) {
		super(notificatore);
		armate = new int[Risiko.numGiocatori];
		int daMettere = 0;
		switch(Risiko.numGiocatori) {
		case 3: daMettere = 35; break;
		case 4: daMettere= 30; break;
		case 5: daMettere= 25; break;
		case 6: daMettere= 20; break;
		case 2: daMettere=24;break;
		default: daMettere = 50; break;
		}
		for(int i = 0; i< Risiko.numGiocatori; i++) armate[i]=daMettere;
	}

	@Override
	public void esegui() {
		if(!pronto()) return;
		ordinaGiocatori();
		String listaGiocatoriOrdinati = listaGiocatoriOrdinati();
		distribuisciNazioni();
		piazzaCarriIniziali();
		try {
			notificatore.notificaOrdinamentoTurni(listaGiocatoriOrdinati);
			HashMap<String,String> obbiettiviGiocatori = prendiObbiettivi();
			HashMap<String,Color> coloriGiocatori = prendiColori();
			HashMap<String,Integer> armateGiocatori = prendiArmate();
			HashMap<String,BitSet> possedimentiGiocatori = prendiPossedimenti();
			String turnista = Risiko.turnista;
			int[] armateSulleNazioni = Risiko.armateSulleNazioni;
			notificatore.notificaAvvioGioco(obbiettiviGiocatori, coloriGiocatori, armateGiocatori,turnista,possedimentiGiocatori,armateSulleNazioni);
			logga(obbiettiviGiocatori,coloriGiocatori,armateGiocatori,possedimentiGiocatori,turnista);
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
	
	private void ordinaGiocatori() {
		boolean scambi = true;
		while(scambi) {
			scambi=false;
			for(int i = 0; i < Risiko.numGiocatori-1; i++) {
				int park = 0;
				if(Risiko.dadiTurnoGiocatori.get(Risiko.indiceGiocatoriOrdinati[i])<Risiko.dadiTurnoGiocatori.get(Risiko.indiceGiocatoriOrdinati[i+1])) {
					scambi = true;
					park = Risiko.indiceGiocatoriOrdinati[i+1];
					Risiko.indiceGiocatoriOrdinati[i+1] = Risiko.indiceGiocatoriOrdinati[i];
					Risiko.indiceGiocatoriOrdinati[i] = park;
				}
			}
		}
		Risiko.turnista=Risiko.giocatori.get(Risiko.indiceGiocatoriOrdinati[0]);
	}
	
	
	private String listaGiocatoriOrdinati() {
		String s = "";
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			int indice = Risiko.indiceGiocatoriOrdinati[i];
			s = s + (i+1)+ ": " +Risiko.giocatori.get(indice)+"\n";
		}
		return s;
	}
	
	
	
	private void distribuisciNazioni() {
		Random r = new Random();
		BitSet bs = new BitSet(42);
		bs.set(0,42);
		while(Risiko.nazioniScelte.cardinality()!=bs.cardinality()) {
			for(int i = 0; i < Risiko.numGiocatori;) {
				if(Risiko.nazioniScelte.cardinality()==bs.cardinality()) break;
				int nazione = r.nextInt(42);
				if(!Risiko.nazioniScelte.get(nazione)) {
					Risiko.nazioniGiocatori.get(i).set(nazione);
					Risiko.nazioniScelte.set(nazione);
					armate[i]--;
					i++;
				}
			}
		}
	}
	
	
	
	private HashMap<String,String> prendiObbiettivi() {
		HashMap<String,String> ris = new HashMap<String,String>();
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			int indiceObbiettivo = Risiko.obbiettiviGiocatori.get(i);
			ris.put(Risiko.giocatori.get(i),Risiko.obbiettivi[indiceObbiettivo]);
		}
		return ris;
	}
	
	
	private HashMap<String,Color> prendiColori() {
		HashMap<String,Color> ris = new HashMap<String,Color>();
		for(int i = 0; i < Risiko.giocatori.size(); i++) {
			ris.put(Risiko.giocatori.get(i), Risiko.coloriGiocatori.get(i));
		}
		return ris;
	}
	
	
	private HashMap<String,Integer> prendiArmate(){
		HashMap<String,Integer> ris = new HashMap<String,Integer>();
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			ris.put(Risiko.giocatori.get(i), armate[i]);
		}
		return ris;
	}
	
	
	private HashMap<String,BitSet> prendiPossedimenti(){
		HashMap<String,BitSet> ris = new HashMap<String,BitSet>();
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			ris.put(Risiko.giocatori.get(i), (BitSet)Risiko.nazioniGiocatori.get(i).clone());
		}
		return ris;
	}
	
	
		
	private boolean pronto() {
		if(Risiko.giocatori.size()<Risiko.numGiocatori) return false;
		int tiri = 0;
		for(int i = 0; i < Risiko.dadiTurnoGiocatori.size(); i++) {
			if(Risiko.dadiTurnoGiocatori.get(i)!=0) tiri++;
		}
		if(tiri < Risiko.numGiocatori) return false;
		int colori = 0;
		for(int i = 0; i < Risiko.coloriGiocatori.size(); i++) {
			if(Risiko.coloriGiocatori.get(i)!=null) colori++;
		}
		if(colori < Risiko.numGiocatori) return false;
		return true;
	}
	
	
	
	private void piazzaCarriIniziali() {
		GloboGrafico globoGrafico = new GloboGraficoConcreto();
		for(int i = 0; i < Risiko.nazioni.size(); i++) {
			int indicePosseditore = -1;
			String nomeNazione = Risiko.nazioni.get(i);
			for(int j = 0; j < Risiko.numGiocatori; j++) {
				if(Risiko.nazioniGiocatori.get(j).get(i)) indicePosseditore = j;
			}
			NazioneGrafica n = globoGrafico.prendiNazione(nomeNazione);
			Rettangolo r = n.prendiRettangoloACaso();
			String nomePartecipante = Risiko.giocatori.get(indicePosseditore);
			double percx = r.getPercx1();
			double percy = r.getPercy1();
			Color colore = Risiko.coloriGiocatori.get(indicePosseditore);
			boolean eCarro = true;
			PosizionaArmata p = new PosizionaArmata(nomePartecipante,eCarro,percx,percy,colore,nomeNazione,this.notificatore);
			p.esegui();
		}
	}
	
	private void logga(HashMap<String,String>obbiettiviGiocatori,HashMap<String,Color>coloriGiocatori,HashMap<String,Integer>armateGiocatori,HashMap<String,BitSet>possedimentiGiocatori,String turnista) {
		System.out.println("AVVIO GIOCO:");
		System.out.println();
		System.out.println("Inizia "+turnista);
		System.out.println();
		System.out.println("Obbiettivi:");
		for(String s:obbiettiviGiocatori.keySet()) {
			System.out.println(s+"----->"+obbiettiviGiocatori.get(s));
		}
		System.out.println();
		System.out.println("Colori:");
		for(String s:coloriGiocatori.keySet()) {
			System.out.println(s+"   "+coloriGiocatori.get(s));
		}
		System.out.println();
		for(String s:armateGiocatori.keySet()) {
			System.out.println(s+" riceve "+armateGiocatori.get(s)+" armate");
		}
		System.out.println();
		System.out.println("Possedimenti:");
		for(String s:possedimentiGiocatori.keySet()) {
			System.out.println(s+":");
			for(int i=0;i<42;i++) {
				if(possedimentiGiocatori.get(s).get(i))System.out.println("     "+Risiko.nazioni.get(i));
			}
		}
		System.out.println();
		System.out.println();
	}

}

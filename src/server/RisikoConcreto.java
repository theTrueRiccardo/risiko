package server;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class RisikoConcreto implements Risiko{
	
	private ArrayList<Giocatore> giocatori;
	
	private ArrayList<Obbiettivo> obbiettivi;
	
	
	private Giocatore turnista;
	
	
	private int totalePartecipanti = 3;
	
	public RisikoConcreto() {
		giocatori = new ArrayList<Giocatore>();
		obbiettivi = new ArrayList<Obbiettivo>();
		Obbiettivo o1 = new ObbiettivoConcreto("Devi distruggere le armate rosse. Se sei tu stesso il proprietario delle armate rosse o nessuno ha (più) le armate rosse, devi conquistare 24 territori");
		Obbiettivo o2 = new ObbiettivoConcreto("Devi conquistare 24 territori");
		Obbiettivo o3 = new ObbiettivoConcreto("Devi conquistare il Nord America e l'Africa");
		Obbiettivo o4 = new ObbiettivoConcreto("Devi conquistare l'Europa, il Sud America e un terzo continente a tua scelta");
		Obbiettivo o5 = new ObbiettivoConcreto("Devi conquistare l'Europa, l'Oceania e un terzo continente a tua scelta");
		Obbiettivo o6 = new ObbiettivoConcreto("Devi conquistare l'Asia e l'Africa");
		Obbiettivo o7 = new ObbiettivoConcreto("Devi conquistare 18 territori e occupare ciascuno di questi con (almeno) 2 armate");
		Obbiettivo o8 = new ObbiettivoConcreto("Devi conquistare Nord America e Oceania");
		Obbiettivo o9 = new ObbiettivoConcreto("Devi conquistare Asia e Sud America");
		Obbiettivo o10 = new ObbiettivoConcreto("Devi distruggere le armate verdi. Se sei tu stesso il proprietario delle armate verdi o nessuno ha (più) le armate verdi, devi conquistare 24 territori");
		Obbiettivo o11 = new ObbiettivoConcreto("Devi distruggere le armate gialle. Se sei tu stesso il proprietario delle armate gialle o nessuno ha (più) le armate gialle, devi conquistare 24 territori");
		Obbiettivo o12 = new ObbiettivoConcreto("Devi distruggere le armate blu. Se sei tu stesso il proprietario delle armate blu o nessuno ha (più) le armate blu, devi conquistare 24 territori");
		Obbiettivo o13 = new ObbiettivoConcreto("Devi distruggere le armate nere. Se sei tu stesso il proprietario delle armate nere o nessuno ha (più) le armate nere, devi conquistare 24 territori");
		Obbiettivo o14 = new ObbiettivoConcreto("Devi distruggere le armate viola. Se sei tu stesso il proprietario delle armate viola o nessuno ha (più) le armate viola, devi conquistare 24 territori");
		obbiettivi.add(o1);
		obbiettivi.add(o2);
		obbiettivi.add(o3);
		obbiettivi.add(o4);
		obbiettivi.add(o5);
		obbiettivi.add(o6);
		obbiettivi.add(o7);
		obbiettivi.add(o8);
		obbiettivi.add(o9);
		obbiettivi.add(o10);
		obbiettivi.add(o11);
		obbiettivi.add(o12);
		obbiettivi.add(o13);
		obbiettivi.add(o14);
		
	}
	
	
	@Override
	public void inserisciGiocatore(String nomePartecipante) {
		Giocatore g = new Giocatore(nomePartecipante);
		giocatori.add(g);
	}

	@Override
	public void assegnaColoreArmate(String nomePartecipante, Color colore) {
		for(Giocatore g : giocatori) {
			if(g.getNome().equals(nomePartecipante)) {
				g.setColoreArmate(colore);
			}
		}
	}

	@Override
	public int tiraDadoTurno(String nomePartecipante) {
		Random r = new Random();
		int faccia = r.nextInt(6)+1;
		for(Giocatore g : giocatori) {
			if(g.getNome().equals(nomePartecipante)) {
				g.setDadoTurno(faccia);
			}
		}
		return faccia;
	}

	
	
	
	/**
	 * AVVIO DEL GIOCO
	 */
	@Override
	public HashMap<String,Giocatore> avviaGioco() {
		distribuisciObbiettivi();
		distribuisciArmate();
		HashMap<String,Giocatore> informazioni = prendiStatoAttuale();
		return informazioni;
	}

	
	
	
	
	

	@Override
	public boolean prontiTutti() {
		if(giocatori.size()<totalePartecipanti) return false;
		for(Giocatore g : giocatori) if(!g.pronto())return false;
		return true;
	}


	@Override
	public String getGiocatoriOrdinati() {
		ordinaGiocatoriPerTurni();
		String ris = "TURNI:\n";
		for(int i = 0; i < giocatori.size(); i++) {
			int turno = i+1;
			ris=ris +turno+":";
			ris= ris + " " + giocatori.get(i).getNome() + "\n";
		}
		return ris;
	}


	@Override
	public String getTurnista() {
		return turnista.getNome();
	}


	
	
	
	private void ordinaGiocatoriPerTurni() {
		Collections.sort(giocatori, new Comparator<Giocatore>() {
			public int compare(Giocatore g1, Giocatore g2) {
				if(g1.getDadoTurno()>g2.getDadoTurno())return -1;
				if(g1.getDadoTurno()<g2.getDadoTurno())return 1;
				return 0;
			}
		});
		turnista = giocatori.get(0);
	}
	
	
	
	private void distribuisciObbiettivi() {
		ArrayList<Giocatore> copiaGiocatori = new ArrayList<Giocatore>(giocatori);
		ArrayList<Obbiettivo> copiaObbiettivi = new ArrayList<Obbiettivo>(obbiettivi);
		Random r = new Random();
		while(!copiaGiocatori.isEmpty()) {
			int i = r.nextInt(copiaGiocatori.size());
			Giocatore giocatore = copiaGiocatori.get(0);
			Obbiettivo obbiettivo = copiaObbiettivi.get(i);
			giocatore.setObbiettivo(obbiettivo);
			copiaGiocatori.remove(0);
			copiaObbiettivi.remove(i);
		}
	}
	
	
	
	
	private void distribuisciArmate() {
		int armate = 0;
		switch(totalePartecipanti) {
		case 3: armate = 35; break;
		case 4: armate = 30; break;
		case 5: armate = 25; break;
		case 6: armate = 20; break;
		}
		for(Giocatore giocatore: giocatori) giocatore.setArmateDisponibili(armate);
	}
	
	
	
	
	
	private HashMap<String,Giocatore> prendiStatoAttuale(){
		HashMap<String,Giocatore> stato = new HashMap<String,Giocatore>();
		for(Giocatore giocatore : giocatori) {
			stato.put(giocatore.getNome(), giocatore);
		}
		return stato;
	}

}

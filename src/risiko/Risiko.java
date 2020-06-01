package risiko;

import risiko.ElementiDelGioco.Territorio;
import server.Giocatore;
import utilità.Carta;

public class Risiko implements Gioco{
	
	private Carta carteTerritorio;
	
	private Carta cartaObbiettivo;
	
	private static int perditeAttaccante(int[] dadiAttaccante, int[] dadiDifensore) {
		int perdite=0;
		for(int i = 0; i < 3; i++) {
			if(dadiAttaccante[i]!=0 && dadiDifensore[i]!=0) {
				if(dadiAttaccante[i]<=dadiDifensore[i]) perdite++;
			}
		}
		return perdite;
	}
	
	private static int perditeDifensore(int[] dadiAttaccante, int[] dadiDifensore) {
		int perdite=0;
		for(int i = 0; i < 3; i++) {
			if(dadiAttaccante[i]!=0 && dadiDifensore[i]!=0) {
				if(dadiAttaccante[i]>dadiDifensore[i]) perdite++;
			}
		}
		return perdite;
	}

	@Override
	public void attacca(Giocatore turnista, Giocatore difensore, Territorio da, Territorio a, int numeroDadi) {
		int risultatiAttaccante[]=turnista.lanciaDadi(numeroDadi);
		int dadiDifensore = (a.carri() >= 3) ? 3 : a.carri();
		int risultatiDifensore[]=difensore.lanciaDadi(dadiDifensore);
		da.rimuoviCarri(perditeAttaccante(risultatiAttaccante,risultatiDifensore));
		a.rimuoviCarri(perditeDifensore(risultatiAttaccante,risultatiDifensore));
		
	}

	@Override
	public void posizionaCarri(Giocatore turnista, int numeroCarri, Territorio territorio) {
		territorio.depositaCarri(numeroCarri);
	}

	@Override
	public void posizionaBandiere(Giocatore turnista, int numeroBandiere, Territorio territorio) {
		territorio.depositaBandiere(numeroBandiere);
	}

	@Override
	public void lanciaDadoDelTurno(Giocatore turnista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pescaCartaObbiettivo(Giocatore turnista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ottieniTerritoriIniziali(Giocatore turnista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pescaCartaTerritorio(Giocatore turnista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passa(Giocatore turnista) {
		turnista.setTurnista(false);
	}

	
	public static void main(String[] args) {
		
	}
}

package server.risiko;

import java.awt.Color;

import server.Notificatore;
import utilita.GloboGrafico;
import utilita.GloboGraficoConcreto;
import utilita.NazioneGrafica;
import utilita.Rettangolo;

public class Spostamento extends AzioneAstratta{
	
	private String nazioneDA,nazioneA;
	
	private int armate;

	public Spostamento(String nazioneDA, String nazioneA, int armate,Notificatore notificatore) {
		super(notificatore);
		this.nazioneA=nazioneA;
		this.nazioneDA=nazioneDA;
		this.armate=armate;
	}

	@Override
	public void esegui() {
		int indiceNazioneDA = Risiko.nazioni.indexOf(nazioneDA);
		int indiceNazioneA = Risiko.nazioni.indexOf(nazioneA);
		Risiko.armateSulleNazioni[indiceNazioneDA]-=armate;
		//Risiko.armateSulleNazioni[indiceNazioneA]+=armate; verrà fatto in posizionamentoArmata
		try {
			notificatore.notificaCancellamentoArmate(armate, nazioneDA); //solo grafico
		} catch (Exception e) {e.printStackTrace();}
		GloboGrafico gg = new GloboGraficoConcreto();
		NazioneGrafica n = gg.prendiNazione(nazioneA);
		int indiceGiocatore = -1;
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.nazioniGiocatori.get(i).get(indiceNazioneA)) indiceGiocatore = i;
		}
		Risiko.armateGiocatoriSullaMappa[indiceGiocatore]-=armate;//serve per avere un numero di armate consistente dopo l'operazione duale in posizionaArmata
		String posseditore = Risiko.giocatori.get(indiceGiocatore);
		Color colore = Risiko.coloriGiocatori.get(indiceGiocatore);
		System.out.println("Vengono spostate "+armate+" armate da "+nazioneDA + " a "+ nazioneA + " per conto di "+posseditore);
		while(armate > 0) {
			Rettangolo r = n.prendiRettangoloACaso();
			double percx = r.getPercx1(), percy = r.getPercy1();
			if(armate>=10) {
				PosizionaArmata p = new PosizionaArmata(posseditore, false, percx, percy, colore, nazioneA, notificatore);
				p.esegui();
				armate-=10;
				
			}
			else {
				PosizionaArmata p = new PosizionaArmata(posseditore, true, percx, percy, colore, nazioneA, notificatore);
				p.esegui();
				armate--;
			}
		}
	}
	
	

}

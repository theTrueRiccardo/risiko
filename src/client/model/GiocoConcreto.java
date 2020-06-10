package client.model;

import java.awt.Color;
import java.util.Arrays;

import utilità.ElementiDelGioco;
import utilità.ElementiDelGioco.Territorio;

public class GiocoConcreto implements Gioco{
	
	private String[] nazioni = {"urali", "siberia", "jacuzia", "cita", "kamchatka", "giappone", 
			"mongolia", "afghanistan", "medio_oriente", "india", "cina", "siam", "africa_del_nord", 
			"egitto", "congo", "africa_orientale", "africa_del_sud", "madagascar", "alaska", 
			"territori_del_nord_ovest", "groenlandia", "alberta", "ontario", "quebec", 
			"stati_uniti_occidentali", "stati_uniti_orientali", "america_centrale", "venezuela", 
			"peru", "brasile", "argentina", "islanda", "scandinavia", "gran_bretagna", 
			"europa_occidentale", "europa_meridionale", "ucraina", "europa_settentrionale", 
			"indonesia", "nuova_guinea", "australia_orientale", "australia_occidentale"};
	
	
	private int[] armate = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	private String[] proprietari = {null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null};
	
	
	
	
	private String nomePartecipante, difensoreAttuale, nazioneAttaccoDA, nazioneAttaccoA,
	nazioneSpostaDA, nazioneSpostaA, turnista;
	
	private Color coloreArmatate;
	
	private int armateDisponibili=0,armateAttualmenteImpiegate=0;
	
	
	

	@Override
	public void setNomePartecipante(String nomePartecipante) {
		this.nomePartecipante=nomePartecipante;
	}



	@Override
	public void setColoreArmate(Color coloreArmate) {
		this.coloreArmatate=coloreArmate;
	}



	@Override
	public String getNomePartecipante() {
		return nomePartecipante;
	}



	@Override
	public Color getColoreArmate() {
		return coloreArmatate;
	}



	@Override
	public void setNazioneAttaccoA(String nazioneAttaccoA) {
		this.nazioneAttaccoA=nazioneAttaccoA;
	}



	@Override
	public void setNazioneAttaccoDA(String nazioneAttaccoDA) {
		this.nazioneAttaccoDA=nazioneAttaccoDA;
	}



	@Override
	public void setNazioneSpostaA(String nazioneSpostaA) {
		this.nazioneSpostaA=nazioneSpostaA;
	}



	@Override
	public void setNazioneSpostaDA(String nazioneSpostaDA) {
		this.nazioneSpostaDA=nazioneSpostaDA;
	}



	@Override
	public String getNazioneAttaccoDA() {
		return nazioneAttaccoDA;
	}



	@Override
	public String getNazioneAttaccoA() {
		return nazioneAttaccoA;
	}



	@Override
	public String getNazioneSpostaDA() {
		return nazioneSpostaDA;
	}



	@Override
	public String getNazioneSpostaA() {
		return nazioneSpostaA;
	}



	@Override
	public int getArmateAttualmenteImpiegate() {
		return armateAttualmenteImpiegate;
	}



	@Override
	public void setDifensoreAttuale(String difensoreAttuale) {
		this.difensoreAttuale=difensoreAttuale;
	}



	@Override
	public String getDifensoreAttuale() {
		return difensoreAttuale;
	}



	@Override
	public boolean ePossibileIncrementareAttacco(String nazioneAttaccoDA) {
		Territorio territorio = ElementiDelGioco.Territorio.riconosciNazione(nazioneAttaccoDA);
		return territorio.carri()-(armateAttualmenteImpiegate+1)>= 1;
	}

	
	@Override
	public boolean ePossibileIncrementareSposta(String nazioneSpostaDA) {
		int indiceNazione = 0;
		for(int i = 0; i <nazioni.length; i++) {
			if(nazioni[i].equals(nazioneSpostaDA)) {
				indiceNazione=i;
				break;
			}
		}
		return armate[indiceNazione]-1 >=1;
		
	}


	@Override
	public boolean possiedeNazione(String nomeNazione) {
		int indiceNazione = 0;
		for(int i = 0; i <nazioni.length; i++) {
			if(nazioni[i].equals(nomeNazione)) {
				indiceNazione=i;
				break;
			}
		}
		return proprietari[indiceNazione].equals(nomePartecipante);
	}



	@Override
	public String getPosseditoreNazione(String nomeNazione) {
		Territorio territorio = ElementiDelGioco.Territorio.riconosciNazione(nomeNazione);
		return territorio.posseditore();
	}



	@Override
	public void decrementaArmateDisponibili(int numero) {
		armateDisponibili-=numero;
	}



	@Override
	public void incrementaArmateDisponibili(int numero) {
		this.armateDisponibili+=numero;
	}



	@Override
	public int getArmateDisponibili() {
		return armateDisponibili;
	}



	@Override
	public void incrementaArmateAttualmenteImpiegate() {
		armateAttualmenteImpiegate++;
		
	}



	@Override
	public void decrementaArmateAttualmentaImpiegate() {
		armateAttualmenteImpiegate--;
	}



	@Override
	public boolean ePossibileDecrementareAttacco(String nazioneAttaccoDA) {
		return armateAttualmenteImpiegate-1>=0;
	}



	@Override
	public boolean ePossibileDecrementareSposta(String nazioneSpostaDA) {
		return armateAttualmenteImpiegate-1>=0;
	}



	@Override
	public boolean confinano(String nomeNazione1, String nomeNazione2) {
		Territorio territorio1 = ElementiDelGioco.Territorio.riconosciNazione(nomeNazione1);
		Territorio territorio2 = ElementiDelGioco.Territorio.riconosciNazione(nomeNazione2);
		return territorio1.confinaCon(territorio2);
	}



	@Override
	public void setTurnista(String turnista) {
		this.turnista=turnista;
	}



	@Override
	public String getTurnista() {
		return turnista;
	}



	@Override
	public void setPosseditori(String[] posseditori) {
		this.proprietari=posseditori;
	}




	

}

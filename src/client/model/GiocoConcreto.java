package client.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;

import utilità.ElementiDelGioco;
import utilità.ElementiDelGioco.Territorio;

public class GiocoConcreto implements Gioco{
	
	public GiocoConcreto() {
		
	}
	
	private ArrayList<String>nazioni = new ArrayList<String>(Arrays.asList( new String[] {"urali", "siberia", "jacuzia", "cita", "kamchatka", "giappone", 
			"mongolia", "afghanistan", "medio_oriente", "india", "cina", "siam", "africa_del_nord", 
			"egitto", "congo", "africa_orientale", "africa_del_sud", "madagascar", "alaska", 
			"territori_del_nord_ovest", "groenlandia", "alberta", "ontario", "quebec", 
			"stati_uniti_occidentali", "stati_uniti_orientali", "america_centrale", "venezuela", 
			"perù", "brasile", "argentina", "islanda", "scandinavia", "gran_bretagna", 
			"europa_occidentale", "europa_meridionale", "ucraina", "europa_settentrionale", 
			"indonesia", "nuova_guinea", "australia_orientale", "australia_occidentale"}));
	
	
	private int[] armateSulleNazioni = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	private BitSet possedimenti = new BitSet(42);
	
	
	private int armatePosizionateInFasePre = 0;
	
	private boolean haPresoCarta=false;
	
	private String nomePartecipante, difensoreAttuale, nazioneAttaccoDA, nazioneAttaccoA,
	nazioneSpostaDA, nazioneSpostaA, turnista;
	
	private Color coloreArmatate;
	
	private int armateDisponibili=0,armateAttualmenteImpiegate=0;
	
	private ArrayList<String> carteOttenute=new ArrayList<String>();
	
	private LinkedList<String> codaTelegrammi=new LinkedList<String>();
	
	private boolean conquista=false;
	
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
		int indice = nazioni.indexOf(nazioneAttaccoDA);
		return (conquista) ? armateSulleNazioni[indice]-(armateAttualmenteImpiegate+1)>=1:armateSulleNazioni[indice]-(armateAttualmenteImpiegate+1)>= 1 && armateAttualmenteImpiegate<3;
		//return armateSulleNazioni[indice]-(armateAttualmenteImpiegate+1)>= 1 && armateAttualmenteImpiegate<3;
		/*Territorio territorio = ElementiDelGioco.Territorio.riconosciNazione(nazioneAttaccoDA);
		return territorio.carri()-(armateAttualmenteImpiegate+1)>= 1;*/
	}

	
	@Override
	public boolean ePossibileIncrementareSposta(String nazioneSpostaDA) {
		int indice = nazioni.indexOf(nazioneSpostaDA);
		return armateSulleNazioni[indice]-(armateAttualmenteImpiegate+1)>= 1;
		/*int indiceNazione = 0;
		for(int i = 0; i <nazioni.length; i++) {
			if(nazioni[i].equals(nazioneSpostaDA)) {
				indiceNazione=i;
				break;
			}
		}
		return armate[indiceNazione]-1 >=1;*/
		
	}


	@Override
	public boolean possiedeNazione(String nomeNazione) {
		int indice = nazioni.indexOf(nomeNazione.toLowerCase());
		return possedimenti.get(indice);
		/*
		int indiceNazione = 0;
		for(int i = 0; i <nazioni.length; i++) {
			if(nazioni[i].equals(nomeNazione)) {
				indiceNazione=i;
				break;
			}
		}
		return proprietari[indiceNazione].equals(nomePartecipante);*/
	}



	/*@Override
	public String getPosseditoreNazione(String nomeNazione) {
		Territorio territorio = ElementiDelGioco.Territorio.riconosciNazione(nomeNazione);
		return territorio.posseditore();
	}*/



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
		return armateAttualmenteImpiegate-1>0;
	}



	@Override
	public boolean ePossibileDecrementareSposta(String nazioneSpostaDA) {
		return armateAttualmenteImpiegate-1>0;
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
	public void setPossedimenti(BitSet possedimenti) {
		this.possedimenti=possedimenti;
	}



	@Override
	public String getTerritori() {
		String ris = "Territori:\n";
		for(int i = 0; i < nazioni.size(); i++) {
			if(possedimenti.get(i)) ris = ris+nazioni.get(i)+"\n";
		}
		return ris;
	}



	@Override
	public void incrementaArmatePosizionateInFasePre() {
		armatePosizionateInFasePre++;
	}



	@Override
	public void azzeraArmatePosizionateInFasePre() {
		armatePosizionateInFasePre=0;
	}



	@Override
	public int getArmatePosizionateInFasePre() {
		return armatePosizionateInFasePre;
	}



	@Override
	public void setArmateSulleNazioni(int[] armateSulleNazioni) {
		this.armateSulleNazioni=armateSulleNazioni;
	}



	@Override
	public void azzeraArmateAttualmenteImpiegate() {
		armateAttualmenteImpiegate=0;
	}



	@Override
	public void settaPresaCarta() {
		haPresoCarta=true;
	}

	@Override
	public boolean haPresoCarta() {
		return haPresoCarta;
	}


	@Override
	public void daiCarta(String carta) {
		carteOttenute.add(carta);
	}



	@Override
	public void cacciaCarte(int codiceCombinazione) {
		int i=0;
		switch(codiceCombinazione) {
		case 0:{
			for(int k=0;k<carteOttenute.size();k++) {
				String s=carteOttenute.get(k);
				if(s.equals("fante")) {
					carteOttenute.remove(k);
					k--;
					i++;
					if(i==3)break;
				}
			}
			break;
		}
		case 1:{
			for(int k=0;k<carteOttenute.size();k++) {
				String s=carteOttenute.get(k);
				if(s.equals("cannone")) {
					carteOttenute.remove(k);
					k--;
					i++;
					if(i==3)break;
				}
			}
			break;
		}
		case 2:{
			for(int k=0;k<carteOttenute.size();k++) {
				String s=carteOttenute.get(k);
				if(s.equals("cavaliere")) {
					carteOttenute.remove(k);
					k--;
					i++;
					if(i==3)break;
				}
			}
			break;
		}
		case 3:{
			boolean f=false,can=false,cav=false;
			for(int k=0;k<carteOttenute.size();k++) {
				String s=carteOttenute.get(k);
				if(f&&can&&cav)break;
				if(s.equals("fante")&&!f) {
					carteOttenute.remove(k);
					k--;
					f=true;
				}
				else if(s.equals("cannone")&&!can) {
					carteOttenute.remove(k);
					k--;
					can=true;
				}
				else if(s.equals("cavaliere")&&!cav) {
					carteOttenute.remove(k);
					k--;
					cav=true;
				}
			}
			break;
		}
		case 14:{
			boolean j=false,dop=false;int due=0;
			for(int k=0;k<carteOttenute.size();k++) {
				String s=carteOttenute.get(k);
				if(j&&dop)break;
				if(s.equals("jolly")&&!j) {
					carteOttenute.remove(k);
					k--;
					j=true;
				}
				if(s.equals("fante")&&!dop) {
					due++;
					carteOttenute.remove(k);
					k--;
					if(due==2)dop=true;
				}
			}
			break;
		}
		case 15:{
			boolean j=false,dop=false;int due=0;
			for(int k=0;k<carteOttenute.size();k++) {
				String s=carteOttenute.get(k);
				if(j&&dop)break;
				if(s.equals("jolly")&&!j) {
					carteOttenute.remove(k);
					k--;
					j=true;
				}
				if(s.equals("cannone")&&!dop) {
					carteOttenute.remove(k);
					k--;
					due++;
					if(due==2)dop=true;
				}
			}
			break;
		}
		case 16:{
			boolean j=false,dop=false;int due=0;
			for(int k=0;k<carteOttenute.size();k++) {
				String s=carteOttenute.get(k);
				if(j&&dop)break;
				if(s.equals("jolly")&&!j) {
					carteOttenute.remove(k);
					k--;
					j=true;
				}
				if(s.equals("cavaliere")&&!dop) {
					carteOttenute.remove(k);
					k--;
					due++;
					if(due==2)dop=true;
				}
			}
			break;
		}
		}
	}



	@Override
	public String listaCarte() {
		String ris="Carte:\n";
		for(String s:carteOttenute)ris=ris+s+"\n";
		return ris;
	}



	@Override
	public String getTelegrammi() {
		String ris="Telegrammi:\n";
		for(String s:codaTelegrammi)ris=ris+s+"\n";
		return ris;
	}



	@Override
	public void inserisciTelegramma(String telegramma) {
		codaTelegrammi.addLast(telegramma);
	}



	@Override
	public void setConquista(boolean c) {
		conquista=c;
	}



	@Override
	public boolean eConquista() {
		return conquista;
	}



	

}

package server.risiko;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import server.risiko.obbiettivi.Obbiettivo;

public class Risiko {
	
	private static int numeroPartecipanti = 1;
	
	private static int[] rinforziPre = new int[numeroPartecipanti];

	private static String[] nazioni = {"urali", "siberia", "jacuzia", "cita", "kamchatka", "giappone", 
			"mongolia", "afghanistan", "medio_oriente", "india", "cina", "siam", "africa_del_nord", 
			"egitto", "congo", "africa_orientale", "africa_del_sud", "madagascar", "alaska", 
			"territori_del_nord_ovest", "groenlandia", "alberta", "ontario", "quebec", 
			"stati_uniti_occidentali", "stati_uniti_orientali", "america_centrale", "venezuela", 
			"peru", "brasile", "argentina", "islanda", "scandinavia", "gran_bretagna", 
			"europa_occidentale", "europa_meridionale", "ucraina", "europa_settentrionale", 
			"indonesia", "nuova_guinea", "australia_orientale", "australia_occidentale"};
	
	private static int[] armate = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	
	private static String[] proprietari = {null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null};
	
	
	private static Obbiettivo[] obbiettivi = {};
	
	private static String[] giocatori = new String[numeroPartecipanti];
	
	private static int[] dadiTurno = new int[numeroPartecipanti];
	
	private static Color[] coloreArmateGiocatori = new Color[numeroPartecipanti];
	
	private static Obbiettivo[] obbiettiviGiocatori;
	
	private static int rinforzi[] = new int[numeroPartecipanti];
	
	private static String turnista;
	
	private static boolean modalit‡Pre;
	
	
	
	
	public static void inserisciGiocatore(String nomePartecipante) {
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i]==null) {
				giocatori[i] = nomePartecipante;
				break;
			}
		}
	}
	
	
	public static void registraColoreArmateGiocatore(String nomePartecipante, Color coloreArmate) {
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i].equals(nomePartecipante)) {
				coloreArmateGiocatori[i] = coloreArmate;
				break;
			}
		}
	}
	
	
	public static void registraTiroDadoTurnoGiocatore(String nomePartecipante) {
		Random r = new Random();
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i].equals(nomePartecipante)) {
				dadiTurno[i] = r.nextInt(6)+1;
				break;
			}
		}
	}
	
	
	
	public static int getDadoTurnoPartecipante(String nomePartecipante) {
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i].equals(nomePartecipante)) {
				return dadiTurno[i];
			}
		}
		return -1;
	}
	
	
	public static void posizionaArmata(String nazione, boolean eCarro) {
		int numArmate = (eCarro==true) ? 1 : 10;
		for(int i = 0; i < nazioni.length; i++) {
			if(nazioni[i].equals(nazione)) {
				armate[i]+=numArmate;
				break;
			}
		}
	}
	
	
	public static String getTurnista() {
		return turnista;
	}
	
	
	public static void gestisciPassaggioTurno() {
		int index = 0;
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i].equals(turnista)) {
				index = i;
				break;
			}
		}
		index = (index+1)%giocatori.length;
		turnista = giocatori[index];
	}
	
	
	public static boolean gestisciAttacco(String attaccante, String nazioneDA, String nazioneA, int numArmateAttaccanti) {
		Random r = new Random();
		int[] dadiRossi = new int[numArmateAttaccanti];
		for(int i = 0; i < dadiRossi.length; i++) {
			dadiRossi[i] = r.nextInt(6)+1;
		}
		Arrays.sort(dadiRossi);
		int numArmateDifensore = 0;
		int indiceNazioneA = 0;
		int indiceNazioneDA = 0;
		for(int i = 0; i < nazioni.length; i++) {
			if(nazioni[i].equals(nazioneA)) {
				indiceNazioneA = i;
			}
			if(nazioni[i].equals(nazioneDA)) {
				indiceNazioneDA = i;
			}
		}
		int armateTotaliNazioneA = armate[indiceNazioneA];
		if(armateTotaliNazioneA >=3) numArmateDifensore = 3;
		else numArmateDifensore = armateTotaliNazioneA;
		int[] dadiBlu = new int[numArmateDifensore];
		Arrays.sort(dadiBlu);
		int perditeAttaccante = 0, perditeDifensore = 0;
		for(int i = 0 ; i < dadiBlu.length; i++) {
			if(dadiRossi[i] <= dadiBlu[i]) perditeAttaccante++;
			else perditeDifensore++;
		}
		armate[indiceNazioneA] -= perditeDifensore;
		armate[indiceNazioneDA] -= perditeAttaccante;
		if(armate[indiceNazioneA] == 0) {
			proprietari[indiceNazioneA] = attaccante;
		}
		int indiceObbiettivo = 0;
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i].equals(attaccante)) {
				indiceObbiettivo = i;
				break;
			}
		}
		return obbiettivi[indiceObbiettivo].eSoddisfatto();
	}
	
	
	public boolean gestisciSpostamento(String spostante, String nazioneDA, String nazioneA, int numArmateSpostanti) {
		int indiceNazioneA = 0;
		int indiceNazioneDA = 0;
		for(int i = 0; i < nazioni.length; i++) {
			if(nazioni[i].equals(nazioneA)) {
				indiceNazioneA = i;
			}
			if(nazioni[i].equals(nazioneDA)) {
				indiceNazioneDA = i;
			}
		}
		armate[indiceNazioneDA]-=numArmateSpostanti;
		armate[indiceNazioneA] += numArmateSpostanti;
		int indiceObbiettivo = 0;
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i].equals(spostante)) {
				indiceObbiettivo = i;
				break;
			}
		}
		return obbiettivi[indiceObbiettivo].eSoddisfatto();
	}

	
	public static void ordinaGiocatori() {
		boolean scambi = true;
		while(scambi) {
			scambi = false;
			for(int i = 0; i < dadiTurno.length-1; i++) {
				int park = 0;
				String parkString = "";
				Color parkColor = null;
				if(dadiTurno[i]>dadiTurno[i+1]) {
					park=dadiTurno[i+1];
					parkString = giocatori[i+1];
					parkColor = coloreArmateGiocatori[i+1];
					dadiTurno[i+1] = dadiTurno[i];
					giocatori[i+1] = giocatori[i];
					coloreArmateGiocatori[i+1] = coloreArmateGiocatori[i];
					dadiTurno[i] = park;
					giocatori[i]=parkString;
					coloreArmateGiocatori[i] = parkColor;
					scambi=true;
				}
			}
		}
	}
	
	
	public static String getGiocatori() {
		String ris = "";
		for(int i = 0; i < giocatori.length; i++) {
			ris= ris +i+":"+giocatori[i]+"\n";
		}
		return ris;
	}
	
	
	public static boolean prontiTutti() {
		int registrati = 0;
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i]!=null) registrati++;
		}
		if(registrati < numeroPartecipanti) return false;
		for(int i = 0; i < giocatori.length; i++) {
			if(dadiTurno[i]==0 || coloreArmateGiocatori[i]==null) return false;
		}
		return true;
	}
	
	
	
	public static int getRinforzi(String giocatore) {
		int indice = 0;
		for(int i = 0; i < giocatori.length; i++) {
			if(giocatori[i].equals(giocatore)) {
				indice = i;
				break;
			}
		}
		return rinforzi[indice];
	}
	
	
	
	
	public static boolean pre() {
		return modalit‡Pre;
	}
	
	
	
	public static HashMap<String,Object[]> informazioniGiocatori(){
		HashMap<String,Object[]> ris = new HashMap<String,Object[]>();
		for(int i = 0; i < giocatori.length; i++) {
			Object[] informazioni = new Object[3];
			informazioni[0] = obbiettivi[i].toString();
			informazioni[1] = coloreArmateGiocatori[i];
			informazioni[2] = rinforzi[i] + "";
			ris.put(giocatori[i], informazioni);
		}
		return ris;
	}
	
	
	public static String[] getPosseditori() {
		return Arrays.copyOf(proprietari, proprietari.length);
	}
	
	public static void avviaGioco() {
		int armatePre=0;
		switch(numeroPartecipanti) {
		case 3: armatePre = 35; break;
		case 4: armatePre= 30;break;
		case 5: armatePre = 25;break;
		case 6: armatePre = 20; break;
		default: armatePre = 10; break;
		}
		for(int i = 0; i < rinforziPre.length; i++) {
			rinforziPre[i]=armatePre;
		}
		obbiettiviGiocatori=RisikoUtils.distribuisciObbiettivi(giocatori, obbiettivi);
		RisikoUtils.assegnaTerritori(proprietari,nazioni,giocatori);
		
	}
}

package server.risiko;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

import utilità.CustodiaCarte;

public class Risiko {
	
	public static int numGiocatori = 1;
	
	public static final ArrayList<String> nazioni = new ArrayList<String>(Arrays.asList(new String[] {
			"urali", "siberia", "jacuzia", "cita", "kamchatka", "giappone", 
			"mongolia", "afghanistan", "medio_oriente", "india", "cina", "siam", "africa_del_nord", 
			"egitto", "congo", "africa_orientale", "africa_del_sud", "madagascar", "alaska", 
			"territori_del_nord_ovest", "groenlandia", "alberta", "ontario", "quebec", 
			"stati_uniti_occidentali", "stati_uniti_orientali", "america_centrale", "venezuela", 
			"perù", "brasile", "argentina", "islanda", "scandinavia", "gran_bretagna", 
			"europa_occidentale", "europa_meridionale", "ucraina", "europa_settentrionale", 
			"indonesia", "nuova_guinea", "australia_orientale", "australia_occidentale"}));
	
	
	public static final ArrayList<String> carte = new ArrayList<String>(Arrays.asList(new String[] {
			"fante","cannone","cannone","cavaliere","cavaliere","fante",
			"fante","cavaliere","cavaliere","cannone","fante","cannone","fante",
			"cannone","fante","cavaliere","cannone","cavaliere","cavaliere",
			"cavaliere","cannone","cannone","fante","fante",
			"fante","cannone","cavaliere","cannone",
			"cavaliere","fante","cannone","cannone","cavaliere","fante",
			"cavaliere","cannone","fante","cavaliere",
			"fante","fante","cavaliere","cannone","jolly","jolly"}));
	
	
	
	public static final String[] obbiettivi = {
			"Devi distruggere le armate rosse. Se sei tu stesso il proprietario delle armate rosse o nessuno ha (più) le armate rosse, devi conquistare 24 territori",
			"Devi distruggere le armate gialle. Se sei tu stesso il proprietario delle armate gialle o nessuno ha (più) le armate gialle, devi conquistare 24 territori",
			"Devi distruggere le armate verdi. Se sei tu stesso il proprietario delle armate verdi o nessuno ha (più) le armate verdi, devi conquistare 24 territori",
			"Devi distruggere le armate blu. Se sei tu stesso il proprietario delle armate blu o nessuno ha (più) le armate blu, devi conquistare 24 territori",
			"Devi distruggere le armate viola. Se sei tu stesso il proprietario delle armate viola o nessuno ha (più) le armate viola, devi conquistare 24 territori",
			"Devi distruggere le armate nere. Se sei tu stesso il proprietario delle armate nere o nessuno ha (più) le armate nere, devi conquistare 24 territori",
			"Devi conquistare 24 territori",
			"Devi conquistare Nord America e Africa",
			"Devi conquistare Nord America e Oceania",
			"Devi conquistare Asia e Africa",
			"Devi conquistare Asia e Sud America",
			"Devi conquistare Europa, Sud America e un terzo continente a tua scelta",
			"Devi conquistare Europa, Oceania e un terzo continente a tua scelta",
			"Devi conquistare 18 territori e metterci sopra almeno 2 armate ciascuno"
			};
	
	
	public static void init() {
		vitaGiocatori.set(0, numGiocatori);
		
		Africa.set(nazioni.indexOf("egitto"));
		Africa.set(nazioni.indexOf("africa_del_nord"));
		Africa.set(nazioni.indexOf("africa_del_sud"));
		Africa.set(nazioni.indexOf("congo"));
		Africa.set(nazioni.indexOf("madagascar"));
		Africa.set(nazioni.indexOf("africa_orientale"));
		
		Asia.set(nazioni.indexOf("urali"));
		Asia.set(nazioni.indexOf("siberia"));
		Asia.set(nazioni.indexOf("jacuzia"));
		Asia.set(nazioni.indexOf("cita"));
		Asia.set(nazioni.indexOf("kamchatka"));
		Asia.set(nazioni.indexOf("giappone"));
		Asia.set(nazioni.indexOf("mongolia"));
		Asia.set(nazioni.indexOf("afghanistan"));
		Asia.set(nazioni.indexOf("medio_oriente"));
		Asia.set(nazioni.indexOf("india"));
		Asia.set(nazioni.indexOf("india"));
		Asia.set(nazioni.indexOf("cina"));
		Asia.set(nazioni.indexOf("siam"));
		
		America_Del_Nord.set(nazioni.indexOf("alaska"));
		America_Del_Nord.set(nazioni.indexOf("territori_del_nord_ovest"));
		America_Del_Nord.set(nazioni.indexOf("groenlandia"));
		America_Del_Nord.set(nazioni.indexOf("alberta"));
		America_Del_Nord.set(nazioni.indexOf("ontario"));
		America_Del_Nord.set(nazioni.indexOf("quebec"));
		America_Del_Nord.set(nazioni.indexOf("stati_uniti_occidentali"));
		America_Del_Nord.set(nazioni.indexOf("stati_uniti_orientali"));
		America_Del_Nord.set(nazioni.indexOf("america_centrale"));
		
		America_Del_Sud.set(nazioni.indexOf("venezuela"));
		America_Del_Sud.set(nazioni.indexOf("venezuela"));
		America_Del_Sud.set(nazioni.indexOf("brasile"));
		America_Del_Sud.set(nazioni.indexOf("argentina"));
		
		Europa.set(nazioni.indexOf("islanda"));
		Europa.set(nazioni.indexOf("scandinavia"));
		Europa.set(nazioni.indexOf("gran_bretagna"));
		Europa.set(nazioni.indexOf("europa_occidentale"));
		Europa.set(nazioni.indexOf("europa_meridionale"));
		Europa.set(nazioni.indexOf("ucraina"));
		Europa.set(nazioni.indexOf("europa_settentrionale"));
		
		Oceania.set(nazioni.indexOf("indonesia"));
		Oceania.set(nazioni.indexOf("nuova_guinea"));
		Oceania.set(nazioni.indexOf("australia_orientale"));
		Oceania.set(nazioni.indexOf("australia_occidentale"));
		
		for(int i = 0; i <numGiocatori; i++) {
			dadiTurnoGiocatori.add(0);
			coloriGiocatori.add(null);
			indiceGiocatoriOrdinati[i]=i;
			primaConquistaTurnoGiocatori.set(i);
			cartePosseduteAttualmenteDaiGiocatori[i]=new CustodiaCarte();
			nazioniGiocatori.add(new BitSet(42));
			giocatoriUccisiGiocatori.add(new BitSet(numGiocatori));
		}
		
	}
	
	
	
	
	
	public static int[] armateSulleNazioni = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	
	public static BitSet vitaGiocatori = new BitSet(numGiocatori);
	
	//(rosso,giallo,verde,blu,nero,viola)
	/*
	 * al rosso corrisponde il codice 0, al giallo il codice 1, etc..
	 */
	public static BitSet coloriScelti = new BitSet(6);
	//come compaiono sopra
	public static BitSet obbiettiviScelti = new BitSet(14);
	//come compaiono sopra
	public static BitSet nazioniScelte = new BitSet(42);
	public static BitSet carteDate=new BitSet(44);
	

	public static BitSet Africa = new BitSet(42);
	public static BitSet Oceania = new BitSet(42);
	public static BitSet America_Del_Sud = new BitSet(42);
	public static BitSet America_Del_Nord = new BitSet(42);
	public static BitSet Asia = new BitSet(42);
	public static BitSet Europa = new BitSet(42);
	
	

	public static ArrayList<String> giocatori = new ArrayList<String>();
	public static ArrayList<BitSet> nazioniGiocatori = new ArrayList<BitSet>();
	public static ArrayList<Integer> dadiTurnoGiocatori = new ArrayList<Integer>();
	public static ArrayList<Color> coloriGiocatori = new ArrayList<Color>();
	public static ArrayList<BitSet> giocatoriUccisiGiocatori = new ArrayList<BitSet>();
	public static ArrayList<Integer> obbiettiviGiocatori = new ArrayList<Integer>();
	public static BitSet primaConquistaTurnoGiocatori=new BitSet(numGiocatori);
	public static BitSet fineFasePre = new BitSet(numGiocatori);
	public static int armateGiocatoriSullaMappa[] = new int[numGiocatori];   //armateGiocatoriSullaMappa[i] == 0 -----> giocatori.get(i) è morto
	public static int indiceGiocatoriOrdinati[] = new int[numGiocatori];
	public static CustodiaCarte[] cartePosseduteAttualmenteDaiGiocatori=new CustodiaCarte[numGiocatori];
	
	
	public static String turnista;
	
	

}

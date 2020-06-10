package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Risiko {
	
	public void init() {
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
		
	}
	
	
	private static ArrayList<String> nazioni = new ArrayList<String>(Arrays.asList(new String[] {
			"urali", "siberia", "jacuzia", "cita", "kamchatka", "giappone", 
			"mongolia", "afghanistan", "medio_oriente", "india", "cina", "siam", "africa_del_nord", 
			"egitto", "congo", "africa_orientale", "africa_del_sud", "madagascar", "alaska", 
			"territori_del_nord_ovest", "groenlandia", "alberta", "ontario", "quebec", 
			"stati_uniti_occidentali", "stati_uniti_orientali", "america_centrale", "venezuela", 
			"peru", "brasile", "argentina", "islanda", "scandinavia", "gran_bretagna", 
			"europa_occidentale", "europa_meridionale", "ucraina", "europa_settentrionale", 
			"indonesia", "nuova_guinea", "australia_orientale", "australia_occidentale"}));
	
	
	private static int[] armate = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	private static final int numGiocatori = 1;
	
	private static BitSet vitaGiocatori = new BitSet(numGiocatori);
	
	//(rosso,giallo,verde,blu,nero,viola)
	private static BitSet coloreScelto = new BitSet(6);
	
	private static BitSet Africa = new BitSet(42);
	private static BitSet Oceania = new BitSet(42);
	private static BitSet America_Del_Sud = new BitSet(42);
	private static BitSet America_Del_Nord = new BitSet(42);
	private static BitSet Asia = new BitSet(42);
	private static BitSet Europa = new BitSet(42);

}

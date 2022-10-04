package server.risiko.obbiettivi;

public class ObbiettivoFactory {
	
	public static Obbiettivo crea(String testo) {
		switch(testo) {
		case "Devi distruggere le armate rosse. Se sei tu stesso il proprietario delle armate rosse o nessuno ha (più) le armate rosse, devi conquistare 24 territori" : return new DistruggiArmateRosse();
		case "Devi distruggere le armate gialle. Se sei tu stesso il proprietario delle armate gialle o nessuno ha (più) le armate gialle, devi conquistare 24 territori": return new DistruggiArmateGialle();
		case "Devi distruggere le armate verdi. Se sei tu stesso il proprietario delle armate verdi o nessuno ha (più) le armate verdi, devi conquistare 24 territori": return new DistruggiArmateVerdi();
		case "Devi distruggere le armate blu. Se sei tu stesso il proprietario delle armate blu o nessuno ha (più) le armate blu, devi conquistare 24 territori": return new DistruggiArmateBlu();
		case "Devi distruggere le armate viola. Se sei tu stesso il proprietario delle armate viola o nessuno ha (più) le armate viola, devi conquistare 24 territori": return new DistruggiArmateViola();
		case "Devi distruggere le armate nere. Se sei tu stesso il proprietario delle armate nere o nessuno ha (più) le armate nere, devi conquistare 24 territori": return new DistruggiArmateNere();
		case "Devi conquistare 24 territori": return new Conquista24Territori();
		case "Devi conquistare Nord America e Africa": return new ConquistaNordAmericaAfrica();
		case "Devi conquistare Nord America e Oceania": return new ConquistaNordAmericaOceania();
		case "Devi conquistare Asia e Africa": return new ConquistaAsiaAfrica();
		case "Devi conquistare Asia e Sud America": return new ConquistaAsiaSudAmerica();
		case "Devi conquistare Europa, Sud America e un terzo continente a tua scelta": return new ConquistaEuropaSudAmericaTerzoContinente();
		case "Devi conquistare Europa, Oceania e un terzo continente a tua scelta": return new ConquistaEuropaOceaniaTerzoContinente();
		case "Devi conquistare 18 territori e metterci sopra almeno 2 armate ciascuno": return new Conquista18Territori2ArmateSopra();
		}
		return null;
	}

}

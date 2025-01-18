package utilita;

import java.util.HashSet;
import java.util.LinkedList;

public class CustodiaCarte {
	
	private String[] carte;
	private LinkedList<Integer> indiciFanti;
	private LinkedList<Integer> indiciCavalieri;
	private LinkedList<Integer> indiciCannoni;
	private LinkedList<Integer> indiciJolly;
	private HashSet<Integer> indiciCarteAppenaTolte; //serve per mantenere consistenza con l'ambiente globale
	private int offset=0;
	public enum Combinazione{
		TRE_FANTI(6),TRE_CANNONI(4),TRE_CAVALIERI(8),FANTE_CANNONE_CAVALIERE(10),JOLLY_E_DUE_CARTE_UGUALI(12),NESSUNA_COMBINAZIONE(0);
		Combinazione(int valore) {
			this.valore=valore;
		}
		private int valore;
		public int getValore() {return valore;}
	} 

	private int fanti=0,cannoni=0,cavalieri=0,jolly=0;
	
	public CustodiaCarte() {
		carte=new String[44];
		indiciFanti=new LinkedList<Integer>();
		indiciCavalieri=new LinkedList<Integer>();
		indiciCannoni=new LinkedList<Integer>();
		indiciJolly=new LinkedList<Integer>();
		indiciCarteAppenaTolte=new HashSet<Integer>();
	}
	
	public void inserisciCarta(int indiceCarta,String carta) {
		carte[indiceCarta]=carta;
		switch(carta) {
		case"fante":fanti++;indiciFanti.add(indiceCarta);break;
		case"cannone":cannoni++;indiciCannoni.add(indiceCarta);break;
		case"cavaliere":cavalieri++;indiciCavalieri.add(indiceCarta);break;
		default:jolly++;indiciJolly.add(indiceCarta);
		}
	}
	
	public Combinazione submitCombinazione() {
		int i=0;
		if(jolly>0&&(fanti>=2||cannoni>=2||cavalieri>=2)) {
			jolly--;
			i=indiciJolly.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			if(fanti>=2) {
				offset=10;
				fanti-=2;
				i=indiciFanti.remove();
				carte[i]=null;
				indiciCarteAppenaTolte.add(i);
				i=indiciFanti.remove();
				carte[i]=null;
				indiciCarteAppenaTolte.add(i);
			}
			else if(cannoni>=2) {
				offset=11;
				cannoni-=2;
				i=indiciCannoni.remove();
				carte[i]=null;
				indiciCarteAppenaTolte.add(i);
				i=indiciCannoni.remove();
				carte[i]=null;
				indiciCarteAppenaTolte.add(i);
			}
			else {
				offset=12;
				cavalieri-=2;
				i=indiciCavalieri.remove();
				carte[i]=null;
				indiciCarteAppenaTolte.add(i);
				i=indiciCavalieri.remove();
				carte[i]=null;
				indiciCarteAppenaTolte.add(i);
			}
			return Combinazione.JOLLY_E_DUE_CARTE_UGUALI;
		}
		if(cavalieri>=1&&fanti>=1&&cannoni>=1) {
			cavalieri--;fanti--;cannoni--;
			i=indiciCannoni.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciCavalieri.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciFanti.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			return Combinazione.FANTE_CANNONE_CAVALIERE;
		}
		if(cavalieri>=3) {
			cavalieri-=3;
			i=indiciCavalieri.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciCavalieri.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciCavalieri.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			return Combinazione.TRE_CAVALIERI;
		}
		if(cannoni>=3) {
			cannoni-=3;
			i=indiciCannoni.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciCannoni.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciCannoni.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			return Combinazione.TRE_CANNONI;
		}
		if(fanti>=3) {
			fanti-=3;
			i=indiciFanti.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciFanti.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			i=indiciFanti.remove();
			carte[i]=null;
			indiciCarteAppenaTolte.add(i);
			return Combinazione.TRE_FANTI;
		}
		return Combinazione.NESSUNA_COMBINAZIONE;
	}
	
	public HashSet<Integer> getIndiciCarteAppenaTolte(){
		return indiciCarteAppenaTolte;
	}
	
	public int getOffset() {
		int ris=offset;
		offset=0;
		return ris;
	}
	
}

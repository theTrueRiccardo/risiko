package risiko;
import eccezioni.*;
import server.Giocatore;

import java.util.*;
public class ElementiDelGioco {
	
	public enum Territorio {
		URALI(new BitSet(42)), SIBERIA(new BitSet(42)), JACUZIA(new BitSet(42)), CITA(new BitSet(42)), KAMCHATKA(new BitSet(42)), GIAPPONE(new BitSet(42)), MONGOLIA(new BitSet(42)), AFGHANISTAN(new BitSet(42)), MEDIO_ORIENTE(new BitSet(42)), INDIA(new BitSet(42)), CINA(new BitSet(42)), SIAM(new BitSet(42)),
		AFRICA_DEL_NORD(new BitSet(42)), EGITTO(new BitSet(42)), CONGO(new BitSet(42)), AFRICA_ORIENTALE(new BitSet(42)), AFRICA_DEL_SUD(new BitSet(42)), MADAGASCAR(new BitSet(42)),
		ALASKA(new BitSet(42)), TERRITORI_DEL_NORD_OVEST(new BitSet(42)), GROENLANDIA(new BitSet(42)), ALBERTA(new BitSet(42)), ONTARIO(new BitSet(42)), QUEBEC(new BitSet(42)), STATI_UNITI_OCCIDENTALI(new BitSet(42)), STATI_UNITI_ORIENTALI(new BitSet(42)), AMERICA_CENTRALE(new BitSet(42)),
		VENEZUELA(new BitSet(42)), PERU(new BitSet(42)), BRASILE(new BitSet(42)), ARGENTINA(new BitSet(42)),
		ISLANDA(new BitSet(42)), SCANDINAVIA(new BitSet(42)), GRAN_BRETAGNA(new BitSet(42)), EUROPA_OCCIDENTALE(new BitSet(42)), EUROPA_MERIDIONALE(new BitSet(42)), UCRAINA(new BitSet(42)), EUROPA_SETTENTRIONALE(new BitSet(42)),
		INDONESIA(new BitSet(42)), NUOVA_GUINEA(new BitSet(42)), AUSTRALIA_ORIENTALE(new BitSet(42)), AUSTRALIA_OCCIDENTALE(new BitSet(42));
		private int carri = 0;
		private Giocatore posseditore;
		private BitSet confinanti;
		Territorio(BitSet confinanti){
			this.confinanti=confinanti;
			switch(this.ordinal()) {
			case 0: {confinanti.set(36);confinanti.set(7);confinanti.set(10);confinanti.set(1); break;}
			case 1: {confinanti.set(0);confinanti.set(10);confinanti.set(2);confinanti.set(3);confinanti.set(6); break;}
			case 2: {confinanti.set(1);confinanti.set(3);confinanti.set(4); break;}
			case 3: {confinanti.set(1);confinanti.set(2);confinanti.set(4);confinanti.set(6); break;}
			case 4: {confinanti.set(2);confinanti.set(3);confinanti.set(6);confinanti.set(5);confinanti.set(18); break;}
			case 5: {confinanti.set(4); confinanti.set(6); break;}
			case 6: {confinanti.set(5); confinanti.set(4); confinanti.set(3); confinanti.set(1); confinanti.set(10); break;}
			case 7: {confinanti.set(0); confinanti.set(10); confinanti.set(8); confinanti.set(36); break;}
			case 8: {confinanti.set(7); confinanti.set(10); confinanti.set(9); confinanti.set(13); confinanti.set(35); confinanti.set(36); break;}
			case 9: {confinanti.set(8); confinanti.set(10); confinanti.set(11); break;}
			case 10: {confinanti.set(6); confinanti.set(1); confinanti.set(0); confinanti.set(7); confinanti.set(8); confinanti.set(9); confinanti.set(11); break;}
			case 11: {confinanti.set(10); confinanti.set(9); confinanti.set(38); break;}
			case 12: {confinanti.set(34);confinanti.set(35); confinanti.set(13); confinanti.set(15); confinanti.set(14);confinanti.set(29); break;}
			case 13: {confinanti.set(8); confinanti.set(15); confinanti.set(12); confinanti.set(35); break;}
			case 14: {confinanti.set(12); confinanti.set(15); confinanti.set(16); break;}
			case 15: {confinanti.set(13); confinanti.set(12); confinanti.set(14); confinanti.set(16); confinanti.set(17); break;}
			case 16: {confinanti.set(17); confinanti.set(14); confinanti.set(15); break;}
			case 17: {confinanti.set(16); confinanti.set(15); break;}
			case 18: {confinanti.set(19); confinanti.set(4); confinanti.set(21); break;}
			case 19: {confinanti.set(18); confinanti.set(20); confinanti.set(21); confinanti.set(22); break;}
			case 20: {confinanti.set(31); confinanti.set(23); confinanti.set(22); confinanti.set(19); break;}
			case 21: {confinanti.set(18); confinanti.set(19); confinanti.set(22); confinanti.set(24); break;}
			case 22: {confinanti.set(19); confinanti.set(21); confinanti.set(24); confinanti.set(25); confinanti.set(20); confinanti.set(23); break;}
			case 23: {confinanti.set(20); confinanti.set(25); confinanti.set(22); break;}
			case 24: {confinanti.set(21); confinanti.set(22); confinanti.set(25); confinanti.set(26); break;}
			case 25: {confinanti.set(26);confinanti.set(24);confinanti.set(22); confinanti.set(23); break;}
			case 26: {confinanti.set(24); confinanti.set(25); confinanti.set(27); break;}
			case 27: {confinanti.set(26); confinanti.set(28); confinanti.set(29); break;}
			case 28: {confinanti.set(27); confinanti.set(29); confinanti.set(30); break;}
			case 29: {confinanti.set(27); confinanti.set(28); confinanti.set(30); confinanti.set(12); break;}
			case 30: {confinanti.set(28); confinanti.set(29); break;}
			case 31: {confinanti.set(20); confinanti.set(33); confinanti.set(32); break;}
			case 32: {confinanti.set(31); confinanti.set(33); confinanti.set(37); confinanti.set(36); break;}
			case 33: {confinanti.set(31); confinanti.set(32); confinanti.set(37); confinanti.set(34); break;}
			case 34: {confinanti.set(33); confinanti.set(37); confinanti.set(35); confinanti.set(12); break;}
			case 35: {confinanti.set(34); confinanti.set(37); confinanti.set(36); confinanti.set(8); confinanti.set(12); confinanti.set(13); break;}
			case 36: {confinanti.set(32); confinanti.set(0); confinanti.set(7); confinanti.set(8); confinanti.set(35); confinanti.set(37); break;}
			case 37: {confinanti.set(33); confinanti.set(32); confinanti.set(36); confinanti.set(35); confinanti.set(34); break;}
			case 38: {confinanti.set(11); confinanti.set(39); confinanti.set(40); break;}
			case 39: {confinanti.set(38);confinanti.set(41);confinanti.set(40); break;}
			case 40: {confinanti.set(39); confinanti.set(41); break;}
			case 41: {confinanti.set(38); confinanti.set(39); confinanti.set(40); break;}
			}
		}
		public boolean confinaCon(Territorio territorio) {
			return confinanti.get(territorio.ordinal());
		}
		public Giocatore posseditore() {return posseditore;}
		public int carri() {return carri;}
		public void depositaCarri(int carri) {this.carri+=carri;}
		public void rimuoviCarri(int carri) throws CarriNegativiException {
			if(this.carri-carri<0) throw new CarriNegativiException();
			this.carri-=carri;
		}
		public void depositaBandiere(int bandiere) {carri+=bandiere*10;}
		public String toString() {
			String conf ="";
			for(int i =0; i < confinanti.size();i++) {
				if(confinanti.get(i)) {
					conf += values()[i].name();
					conf+=", ";
				}
			}
			return name() + " confinante con: " + conf;
		}
	}
	
	public enum Figura {FANTE, CAVALIERE, CANNONE, JOLLY}
	
	public enum Continente {
		ASIA(7, new Territorio[] {Territorio.URALI, Territorio.SIBERIA, Territorio.JACUZIA, Territorio.CITA, Territorio.KAMCHATKA, Territorio.GIAPPONE, Territorio.MONGOLIA, Territorio.AFGHANISTAN, Territorio.MEDIO_ORIENTE, Territorio.INDIA, Territorio.CINA, Territorio.SIAM}), 
		AFRICA(3, new Territorio[] {Territorio.AFRICA_DEL_NORD, Territorio.EGITTO, Territorio.CONGO, Territorio.AFRICA_ORIENTALE, Territorio.AFRICA_DEL_SUD, Territorio.MADAGASCAR}), 
		AMERICA_DEL_NORD(5, new Territorio[] {Territorio.ALASKA, Territorio.TERRITORI_DEL_NORD_OVEST, Territorio.GROENLANDIA, Territorio.ALBERTA, Territorio.ONTARIO, Territorio.QUEBEC, Territorio.STATI_UNITI_OCCIDENTALI, Territorio.STATI_UNITI_ORIENTALI, Territorio.AMERICA_CENTRALE}), 
		AMERICA_DEL_SUD(2, new Territorio[] {Territorio.VENEZUELA, Territorio.PERU, Territorio.BRASILE, Territorio.ARGENTINA}), 
		EUROPA(5, new Territorio[] {Territorio.ISLANDA, Territorio.SCANDINAVIA, Territorio.GRAN_BRETAGNA, Territorio.EUROPA_OCCIDENTALE, Territorio.EUROPA_MERIDIONALE, Territorio.UCRAINA, Territorio.EUROPA_SETTENTRIONALE}), 
		OCEANIA(2, new Territorio[] {Territorio.INDONESIA, Territorio.NUOVA_GUINEA, Territorio.AUSTRALIA_ORIENTALE, Territorio.AUSTRALIA_OCCIDENTALE});
		private int rinforzi;
		private Territorio[] territori;
		Continente(int rinforzi, Territorio[] territori){
			this.rinforzi=rinforzi; this.territori=territori;
		}
		public int rinforzi() {
			return rinforzi;
		}
		public Territorio[] territori() {
			return territori;
		}
	}
	
	

}

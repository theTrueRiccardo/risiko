package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.BitSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import server.risiko.Risiko;
import server.risiko.obbiettivi.Obbiettivo;
import server.risiko.obbiettivi.ObbiettivoFactory;


class TestObbiettivi {
	
	@BeforeAll
	static void initAll() {
		Risiko.init();
		Risiko.numGiocatori=3;
		String g1="tizio",g2="caio",g3="sempronio";
		Risiko.giocatori.add(g1);
		Risiko.giocatori.add(g2);
		Risiko.giocatori.add(g3);
		Risiko.dadiTurnoGiocatori.add(1);
		Risiko.dadiTurnoGiocatori.add(2);
		Risiko.dadiTurnoGiocatori.add(3);
		Risiko.coloriGiocatori.set(0,Color.BLUE);
		Risiko.coloriGiocatori.set(1,Color.RED);
		Risiko.coloriGiocatori.set(2,Color.GREEN);
		BitSet b=Risiko.nazioniGiocatori.get(0); //nazioni di tizio
		//setta 20 nazioni a tizio, colui che ha l'obbiettivo 18 territori..etc
		for(int i=0;i<18;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		b.set(18); Risiko.armateSulleNazioni[18]=1;//importante 
		b.set(19); Risiko.armateSulleNazioni[19]=1;
		//setta nazioni a caio
		b=Risiko.nazioniGiocatori.get(1);
		for(int i=20;i<=30;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a sempronio
		b=Risiko.nazioniGiocatori.get(2);
		for(int i=31;i<Risiko.nazioni.size();i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		Risiko.obbiettiviGiocatori.add(0, 13); //18 territori
		Risiko.obbiettiviGiocatori.add(1, 0); //distruggi armate rosse
		Risiko.obbiettiviGiocatori.add(2, 3); //distruggi armate blu;
		
	}

	
	
	@Test
	void test18Territori2ArmateCiascuno() {
		Risiko.obbiettiviGiocatori.set(0, 13); //18 territori
		Risiko.obbiettiviGiocatori.set(1, 0); //distruggi armate rosse
		Risiko.obbiettiviGiocatori.set(2, 3); //distruggi armate blu;
		BitSet b=Risiko.nazioniGiocatori.get(0); //nazioni di tizio
		//setta 20 nazioni a tizio, colui che ha l'obbiettivo 18 territori..etc
		for(int i=0;i<18;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		b.set(18); Risiko.armateSulleNazioni[18]=1;//importante 
		b.set(19); Risiko.armateSulleNazioni[19]=1;
		//setta nazioni a caio
		b=Risiko.nazioniGiocatori.get(1);
		for(int i=20;i<=30;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a sempronio
		b=Risiko.nazioniGiocatori.get(2);
		for(int i=31;i<Risiko.nazioni.size();i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		Obbiettivo obbiettivo=ObbiettivoFactory.crea("Devi conquistare 18 territori e metterci sopra almeno 2 armate ciascuno");
		assertTrue(obbiettivo.eSoddisfatto());
	}
	
	
	@Test
	void test18Territori2ArmateCiascunoNegativo() {
		Risiko.obbiettiviGiocatori.set(0, 13); //18 territori
		Risiko.obbiettiviGiocatori.set(1, 0); //distruggi armate rosse
		Risiko.obbiettiviGiocatori.set(2, 3); //distruggi armate blu;
		BitSet b=Risiko.nazioniGiocatori.get(0); //nazioni di tizio
		//setta 20 nazioni a tizio, colui che ha l'obbiettivo 18 territori..etc
		for(int i=0;i<18;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		b.set(18); Risiko.armateSulleNazioni[18]=1;//importante 
		b.set(19); Risiko.armateSulleNazioni[19]=1;
		//fail
		b.flip(11);
		//setta nazioni a caio
		b=Risiko.nazioniGiocatori.get(1);
		for(int i=20;i<=30;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a sempronio
		b=Risiko.nazioniGiocatori.get(2);
		for(int i=31;i<Risiko.nazioni.size();i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		Obbiettivo obbiettivo=ObbiettivoFactory.crea("Devi conquistare 18 territori e metterci sopra almeno 2 armate ciascuno");
		assertFalse(obbiettivo.eSoddisfatto());
	}
	
	
	@Test
	void testDistruggiArmateRosseNegativo() {
		Risiko.obbiettiviGiocatori.set(0, 13); //18 territori
		Risiko.obbiettiviGiocatori.set(1, 0); //distruggi armate rosse
		Risiko.obbiettiviGiocatori.set(2, 3); //distruggi armate blu;
		BitSet b=Risiko.nazioniGiocatori.get(0); //nazioni di tizio
		//setta 20 nazioni a tizio, colui che ha l'obbiettivo 18 territori..etc
		for(int i=0;i<18;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		b.set(18); Risiko.armateSulleNazioni[18]=1;//importante 
		b.set(19); Risiko.armateSulleNazioni[19]=1;
		//setta nazioni a caio
		b=Risiko.nazioniGiocatori.get(1);
		for(int i=20;i<=30;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a sempronio
		b=Risiko.nazioniGiocatori.get(2);
		for(int i=31;i<Risiko.nazioni.size();i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		Obbiettivo obbiettivo=ObbiettivoFactory.crea("Devi distruggere le armate rosse. Se sei tu stesso il proprietario delle armate rosse o nessuno ha (più) le armate rosse, devi conquistare 24 territori");
		assertFalse(obbiettivo.eSoddisfatto());
	}
	
	
	@Test
	void testDistruggiArmateRosseCheDiventa24Territori() {
		Risiko.obbiettiviGiocatori.set(0, 13); //18 territori
		Risiko.obbiettiviGiocatori.set(1, 0); //distruggi armate rosse
		Risiko.obbiettiviGiocatori.set(2, 3); //distruggi armate blu;
		BitSet b=Risiko.nazioniGiocatori.get(0); //nazioni di tizio
		//setta 20 nazioni a tizio, colui che ha l'obbiettivo 18 territori..etc
		for(int i=0;i<10;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a caio..ha le armate rosse
		b=Risiko.nazioniGiocatori.get(1);
		for(int i=10;i<=34;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a sempronio
		b=Risiko.nazioniGiocatori.get(2);
		for(int i=35;i<Risiko.nazioni.size();i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		Obbiettivo obbiettivo=ObbiettivoFactory.crea("Devi distruggere le armate rosse. Se sei tu stesso il proprietario delle armate rosse o nessuno ha (più) le armate rosse, devi conquistare 24 territori");
		assertTrue(obbiettivo.eSoddisfatto());
	}
	
	
	@Test
	void testDistruggiArmateBlu() {
		Risiko.obbiettiviGiocatori.set(0, 13); //18 territori
		Risiko.obbiettiviGiocatori.set(1, 0); //distruggi armate rosse
		Risiko.obbiettiviGiocatori.set(2, 3); //distruggi armate blu; le ha 0
		BitSet b=Risiko.nazioniGiocatori.get(0); //nazioni di tizio
		//setta 20 nazioni a tizio, colui che ha l'obbiettivo 18 territori..etc
		for(int i=0;i<18;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		b.set(18); Risiko.armateSulleNazioni[18]=1;//importante 
		b.set(19); Risiko.armateSulleNazioni[19]=1;
		//setta nazioni a caio
		b=Risiko.nazioniGiocatori.get(1);
		for(int i=20;i<=30;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a sempronio
		b=Risiko.nazioniGiocatori.get(2);
		for(int i=31;i<Risiko.nazioni.size();i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		Risiko.giocatoriUccisiGiocatori.get(2).set(0);
		Risiko.vitaGiocatori.flip(0); 
		Obbiettivo obbiettivo=ObbiettivoFactory.crea("Devi distruggere le armate blu. Se sei tu stesso il proprietario delle armate blu o nessuno ha (più) le armate blu, devi conquistare 24 territori");
		assertTrue(obbiettivo.eSoddisfatto());
	}
	
	
	@Test
	void testDistruggiArmateBluNegativo() {
		Risiko.obbiettiviGiocatori.set(0, 13); //18 territori
		Risiko.obbiettiviGiocatori.set(1, 0); //distruggi armate rosse
		Risiko.obbiettiviGiocatori.set(2, 3); //distruggi armate blu; le ha 0
		BitSet b=Risiko.nazioniGiocatori.get(0); //nazioni di tizio
		//setta 20 nazioni a tizio, colui che ha l'obbiettivo 18 territori..etc
		for(int i=0;i<18;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		b.set(18); Risiko.armateSulleNazioni[18]=1;//importante 
		b.set(19); Risiko.armateSulleNazioni[19]=1;
		//setta nazioni a caio
		b=Risiko.nazioniGiocatori.get(1);
		for(int i=20;i<=30;i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//setta nazioni a sempronio
		b=Risiko.nazioniGiocatori.get(2);
		for(int i=31;i<Risiko.nazioni.size();i++) {
			b.set(i); Risiko.armateSulleNazioni[i]=2;
		}
		//Risiko.giocatoriUccisiGiocatori.get(2).set(0);
		Risiko.vitaGiocatori.flip(0); //morto...ma non ucciso dal proprietario dell'obbiettivo
		Obbiettivo obbiettivo=ObbiettivoFactory.crea("Devi distruggere le armate blu. Se sei tu stesso il proprietario delle armate blu o nessuno ha (più) le armate blu, devi conquistare 24 territori");
		assertFalse(obbiettivo.eSoddisfatto());
	}
	
	

}

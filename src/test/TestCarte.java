package test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

import client.model.Gioco;
import client.model.GiocoConcreto;

class TestCarte {

	@Test
	void testCacciaFanteCannoneCavaliere() {
		Gioco gioco=new GiocoConcreto();
		HashSet<String>expected=new HashSet<String>();
		expected.add("fante");
		expected.add("cannone");
		HashSet<String>actual=new HashSet<String>();
		gioco.daiCarta("fante");
		gioco.daiCarta("cannone");
		gioco.daiCarta("fante");
		gioco.daiCarta("cannone");
		gioco.daiCarta("cavaliere");
		gioco.cacciaCarte(3);
		String lista=gioco.listaCarte();
		StringTokenizer st=new StringTokenizer(lista,"\n");
		while(st.hasMoreTokens()) {
			String s=st.nextToken();
			if(!s.equals("Carte:"))actual.add(s);
		}
		assertEquals(expected,actual);
	}
	
	
	@Test
	void testCacciaJollyDueFanti() {
		Gioco gioco=new GiocoConcreto();
		HashSet<String>expected=new HashSet<String>();
		expected.add("cannone");
		expected.add("cannone");
		expected.add("cavaliere");
		HashSet<String>actual=new HashSet<String>();
		gioco.daiCarta("fante");
		gioco.daiCarta("cannone");
		gioco.daiCarta("fante");
		gioco.daiCarta("cannone");
		gioco.daiCarta("cavaliere");
		gioco.daiCarta("jolly");
		gioco.cacciaCarte(14);
		String lista=gioco.listaCarte();
		StringTokenizer st=new StringTokenizer(lista,"\n");
		while(st.hasMoreTokens()) {
			String s=st.nextToken();
			if(!s.equals("Carte:"))actual.add(s);
		}
		assertEquals(expected,actual);
	}

}

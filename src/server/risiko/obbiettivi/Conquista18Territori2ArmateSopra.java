package server.risiko.obbiettivi;


import java.util.BitSet;

import server.risiko.Risiko;

public class Conquista18Territori2ArmateSopra implements Obbiettivo{
	
	private String testo = "Devi conquistare 18 territori e metterci sopra almeno 2 armate ciascuno";
	
	@Override
	public boolean eSoddisfatto() {
		int indiceObbiettivo = indiceObbiettivo();
		int indiceGiocatorePosseditore = indiceGiocatore(indiceObbiettivo);
		BitSet nazioni=Risiko.nazioniGiocatori.get(indiceGiocatorePosseditore);
		if(nazioni.cardinality()<18) return false;
		int cont=0;
		for(int i=0;i<42;i++) {
			if(nazioni.get(i)&&Risiko.armateSulleNazioni[i]>=2)cont++;
		}
		return cont>=18;
		/*
		boolean[] paesi=new boolean[42];
		boolean[] tmp=new boolean[42];
		for(;;) {
			tmp=incr(paesi);
			if(sottoinsiemeOk(tmp, indiceGiocatorePosseditore))return true;
			paesi=tmp;
			if(vistiTutti(paesi))break;
		}
		return false;
		*/
	}
	/*
	private boolean vistiTutti(boolean[] a) {
		for(int i=0;i<a.length;i++)if(!a[i])return false;
		return true;
	}
			
	private boolean[] incr(boolean[]a) {
		boolean[] uno=new boolean[a.length];
		uno[a.length-1]=true;
		boolean[]riporto=new boolean[a.length];
		boolean[]ris=new boolean[a.length];
		for(int i=a.length-1;i>=0;i--) {
			int countUno=0;
			if(uno[i])countUno++;
			if(riporto[i])countUno++;
			if(a[i])countUno++;
			switch(countUno) {
			case 0:{ris[i]=false;if(i>0)riporto[i-1]=false;break;}
			case 1:{ris[i]=true;if(i>0)riporto[i-1]=false;break;}
			case 2:{ris[i]=false;if(i>0)riporto[i-1]=true;break;}
			default:{ris[i]=true;if(i>0)riporto[i-1]=true;}
			}
		}
		return ris;
	}
	
	
	
	private boolean sottoinsiemeOk(boolean[] a, int indiceGiocatore) {
		int cont=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]) {
				if(!Risiko.nazioniGiocatori.get(indiceGiocatore).get(i))return false;
				if(Risiko.armateSulleNazioni[i]<2)return false;
				cont++;
			}
			if(cont==18)return true;
		}
		return false;
	}
	*/
	private int indiceObbiettivo() {
		for(int i = 0; i < Risiko.obbiettivi.length; i++) {
			if(Risiko.obbiettivi[i].equals(testo)) return i;
		}
		return -1;
	}
	
	private int indiceGiocatore(int i) {
		for(int j = 0; j < Risiko.numGiocatori; j++) {
			if(Risiko.obbiettiviGiocatori.get(j)==i)return j;
		}
		return -1;
	}

}

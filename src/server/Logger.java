package server;

import java.awt.Color;
import java.util.BitSet;
import java.util.Scanner;

import server.risiko.Risiko;

public class Logger extends Thread{
	private Scanner sc;
	private StringBuilder sb;
	public Logger() {
		sc=new Scanner(System.in);
		sb=new StringBuilder(500);
	}
	public void run() {
		for(;;) {
			if(sc.hasNext()) {
				String comando=sc.nextLine();
				switch(comando) {
				case "assegnamento colori": logColori();break;
				case "armate sulle nazioni": logArmateNazioni();break;
				case "possedimenti": logPossedimenti();break;
				default:System.out.println("Non ho capito");
				}
			}
		}
	}
	
	
	private void logColori() {
		System.out.println();
		System.out.println("COLORI GIOCATORI:");
		for(int i=0;i<Risiko.numGiocatori;i++) {
			String giocatore=Risiko.giocatori.get(i);
			Color colore=Risiko.coloriGiocatori.get(i);
			sb.append(giocatore+": "+colore+"\n");
		}
		System.out.println(sb.toString());
		System.out.println();
		sb.delete(0, sb.length());
	}
	
	private void logArmateNazioni() {
		System.out.println();
		System.out.println("ARMATE SULLE NAZIONI:");
		for(int i=0;i<Risiko.armateSulleNazioni.length;i++) {
			String nazione=Risiko.nazioni.get(i);
			sb.append(nazione+": "+ Risiko.armateSulleNazioni[i]+"\n");
		}
		System.out.println(sb.toString());
		System.out.println();
		sb.delete(0, sb.length());
	}
	
	private void logPossedimenti() {
		System.out.println();
		System.out.println("POSSEDIMENTI GIOCATORI:");
		for(int i=0;i<Risiko.numGiocatori;i++) {
			String giocatore=Risiko.giocatori.get(i);
			sb.append(giocatore+":\n");
			BitSet b=Risiko.nazioniGiocatori.get(i);
			for(int j=0;j<42;j++) {
				if(b.get(j))sb.append(Risiko.nazioni.get(j)+"\n");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println();
		sb.delete(0, sb.length());
	}

}

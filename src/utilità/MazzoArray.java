package utilità;

import java.util.Iterator;
import java.util.Random;

public class MazzoArray extends MazzoAstratto{
	
	private int grandezza;
	
	private int numeroCarte=0;
	
	private Carta[] carte;
	
	public MazzoArray(int grandezza) {
		this.grandezza=grandezza;
		carte=new Carta[grandezza];
	}

	@Override
	public Carta pescaInCima() {
		Carta ris = carte[0];
		for(int i = 1; i < numeroCarte; i++) {
			carte[i-1]=carte[i];
		}
		carte[numeroCarte-1]=null;
		numeroCarte--;
		return ris;
	}

	@Override
	public Carta pescaRandom() {
		Random r = new Random();
		int indice = r.nextInt(numeroCarte);
		Carta ris = carte[indice];
		for(int i = indice+1; i < numeroCarte; i++) {
			carte[i-1] = carte[i];
		}
		carte[numeroCarte-1]=null;
		numeroCarte--;
		return ris;
	}

	@Override
	public Carta pescaInFondo() {
		Carta ris = carte[numeroCarte-1];
		carte[numeroCarte-1]=null;
		numeroCarte--;
		return ris;
	}

	@Override
	public void taglia() {
		int indexMedio = (numeroCarte-1)/2;
		Carta mazzettoAffianco[] = new Carta[indexMedio+1];
		System.arraycopy(carte, 0, mazzettoAffianco, 0, indexMedio+1);
		System.arraycopy(carte, indexMedio+1, carte, 0, numeroCarte-(indexMedio+1));
		System.arraycopy(mazzettoAffianco, 0, carte, numeroCarte-(indexMedio+1), indexMedio+1);
	}

	@Override
	public boolean vuoto() {
		return numeroCarte==0;
	}

	@Override
	public void mettiInCima(Carta carta) {
		for(int i = numeroCarte-1; i >=0; i--) {
			carte[i+1]=carte[i];
		}
		carte[0]=carta;
		numeroCarte++;
	}

	@Override
	public void mettiRandom(Carta carta) {
		if(numeroCarte==0) {
			mettiInCima(carta);
			return;
		}
		Random r = new Random();
		int indice = r.nextInt(numeroCarte);
		for(int i = numeroCarte-1; i >= indice; i--) {
			carte[i+1] = carte[i];
		}
		carte[indice]=carta;
		numeroCarte++;
	}

	@Override
	public void mettiInFondo(Carta carta) {
		carte[numeroCarte]=carta;
		numeroCarte++;
	}

	@Override
	public void mischia() {
		Carta nuovo[] = new Carta[numeroCarte];
		int carteVecchie=numeroCarte;
		Random r = new Random();
		int i = 0;
loop:	while(carteVecchie>0) {
			int indice = r.nextInt(numeroCarte);
			if(nuovo[indice]!=null) continue loop;
			nuovo[indice]=carte[i];
			carteVecchie--;
			i++;
		}
		carte=nuovo;
	}

	@Override
	public int grandezza() {
		return grandezza;
	}

	@Override
	public Iterator<Carta> iterator() {
		return new Iteratore();
	}

	@Override
	public int numeroCarte() {
		return numeroCarte;
	}
	

	private class Iteratore implements Iterator<Carta>{

		int corrente=-1;
		
		@Override
		public boolean hasNext() {
			if(corrente+1>grandezza-1) return false;
			if(MazzoArray.this.carte[corrente+1]==null) return false;
			return true;
		}

		@Override
		public Carta next() {
			corrente+=1;
			return MazzoArray.this.carte[corrente];
		}
		
	}
}

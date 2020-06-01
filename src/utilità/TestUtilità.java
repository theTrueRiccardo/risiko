package utilità;
import risiko.*;
import risiko.ElementiDelGioco.Figura;
import risiko.ElementiDelGioco.Territorio;
public class TestUtilità {

	public static void main(String[] args) {
		Territorio territori[] = Territorio.values();
		Mazzo mazzo = new MazzoArray(40);
		for(int i = 0; i < 10; i++) {
			ContenutoCartaTerritorio contenuto = new ContenutoCartaTerritorio(Figura.CAVALIERE,territori[i]);
			Carta c = new CartaTerritorio(contenuto);
			mazzo.mettiRandom(c);
		}
		System.out.println(mazzo);
		System.out.println();
		Carta c = mazzo.pescaInFondo();
		System.out.println("CARTA PESCATA " + c);
		System.out.println(mazzo);
		
		

	}

}

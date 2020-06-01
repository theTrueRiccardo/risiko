package risiko;

import java.util.Random;

import risiko.ElementiDelGioco.Territorio;

public class Test {

	public static void main(String[] args) {
		Territorio[] nazioni = Territorio.values();
		for(int i = 0; i < nazioni.length; i++) {
			System.out.println(nazioni[i]);
		}
	}

}

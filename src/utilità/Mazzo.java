package utilità;
import java.util.*;

import server.risiko.*;
public interface Mazzo extends Iterable<Carta> {
	
	Carta pescaInCima();
	
	Carta pescaRandom();
	
	Carta pescaInFondo();
	
	void taglia();
	
	boolean vuoto();
	
	void mettiInCima(Carta carta);
	
	void mettiRandom(Carta carta);
	
	void mettiInFondo(Carta carta);

	void mischia();
	
	int grandezza();
	
	int numeroCarte();
	
	
}

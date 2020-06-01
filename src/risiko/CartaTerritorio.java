package risiko;
import eccezioni.*;
import utilit�.Carta;
import utilit�.ContenutoCarta;
public class CartaTerritorio implements Carta {
	
	private ContenutoCartaTerritorio contenuto;

	public ContenutoCarta leggiContenuto() {
		return contenuto;
	}
	
	public CartaTerritorio(ContenutoCartaTerritorio contenuto) {
		this.contenuto = new ContenutoCartaTerritorio(contenuto);
	}
	
	public String toString() {
		return contenuto.getTerritorio().name()+"  " + contenuto.getFigura().name();
	}
	
}

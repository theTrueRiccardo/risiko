package risiko;
import eccezioni.*;
import utilità.Carta;
import utilità.ContenutoCarta;
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

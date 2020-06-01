package risiko;
import eccezioni.*;
import utilit�.*;
import utilit�.Carta;
public class CartaObbiettivo implements Carta {
	
	private ContenutoCartaObbiettivo contenuto;
	
	public ContenutoCarta leggiContenuto() {
		return contenuto;
	}
	
	public void inserisciContenuto(ContenutoCarta contenuto) throws ContenutoErratoException{
		if(!(contenuto instanceof ContenutoCartaObbiettivo)) throw new ContenutoErratoException();
		this.contenuto=(ContenutoCartaObbiettivo)contenuto;
	}

}

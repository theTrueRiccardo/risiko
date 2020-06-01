package eccezioni;

public class ContenutoErratoException extends Exception {
	
	public ContenutoErratoException() {}
	public ContenutoErratoException(String problema) {
		super(problema);
	}

}

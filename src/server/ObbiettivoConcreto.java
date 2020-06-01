package server;

public class ObbiettivoConcreto implements Obbiettivo{

	private String testo;
	
	private Giocatore proprietario;
	
	public ObbiettivoConcreto(String testoObbiettivo) {
		this.testo=testoObbiettivo;
		
	}

	@Override
	public String getTesto() {
		return testo;
	}

	@Override
	public Giocatore getProprietario() {
		return proprietario;
	}

}

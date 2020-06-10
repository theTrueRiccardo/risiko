package test;

public abstract class ElementoDelGioco {

	private Giocatore proprietario;
	
	public Giocatore getProprietario() {
		return new Giocatore(proprietario);
	}
	
	public void setProprietario(Giocatore giocatore) {
		this.proprietario = new Giocatore(giocatore);
	}
	
	
}

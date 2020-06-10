package test;

public abstract class ElementoConNome extends ElementoDelGioco{
	
	private String nome;
	
	public ElementoConNome(String nome) {
		this.nome = new String(nome);
	}
	
	public String getNome() {
		return new String(nome);
	}

}

package risiko;
import risiko.ElementiDelGioco.*;
import utilità.ContenutoCarta;
public class ContenutoCartaTerritorio implements ContenutoCarta{
	
	private Figura figura;
	
	private Territorio territorio;
	
	public ContenutoCartaTerritorio(ContenutoCartaTerritorio contenuto) {
		this.figura=contenuto.figura;
		this.territorio=contenuto.territorio;
	}
	
	public ContenutoCartaTerritorio(Figura figura, Territorio territorio) {
		this.figura=figura; this.territorio=territorio;
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Territorio getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Territorio territorio) {
		this.territorio = territorio;
	}

	
}

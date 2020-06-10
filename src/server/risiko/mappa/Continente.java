package server.risiko.mappa;



public enum Continente {
	
	ASIA(7, new Territorio[] {Territorio.URALI, Territorio.SIBERIA, Territorio.JACUZIA, Territorio.CITA, Territorio.KAMCHATKA, Territorio.GIAPPONE, Territorio.MONGOLIA, Territorio.AFGHANISTAN, Territorio.MEDIO_ORIENTE, Territorio.INDIA, Territorio.CINA, Territorio.SIAM}), 
	AFRICA(3, new Territorio[] {Territorio.AFRICA_DEL_NORD, Territorio.EGITTO, Territorio.CONGO, Territorio.AFRICA_ORIENTALE, Territorio.AFRICA_DEL_SUD, Territorio.MADAGASCAR}), 
	AMERICA_DEL_NORD(5, new Territorio[] {Territorio.ALASKA, Territorio.TERRITORI_DEL_NORD_OVEST, Territorio.GROENLANDIA, Territorio.ALBERTA, Territorio.ONTARIO, Territorio.QUEBEC, Territorio.STATI_UNITI_OCCIDENTALI, Territorio.STATI_UNITI_ORIENTALI, Territorio.AMERICA_CENTRALE}), 
	AMERICA_DEL_SUD(2, new Territorio[] {Territorio.VENEZUELA, Territorio.PERU, Territorio.BRASILE, Territorio.ARGENTINA}), 
	EUROPA(5, new Territorio[] {Territorio.ISLANDA, Territorio.SCANDINAVIA, Territorio.GRAN_BRETAGNA, Territorio.EUROPA_OCCIDENTALE, Territorio.EUROPA_MERIDIONALE, Territorio.UCRAINA, Territorio.EUROPA_SETTENTRIONALE}), 
	OCEANIA(2, new Territorio[] {Territorio.INDONESIA, Territorio.NUOVA_GUINEA, Territorio.AUSTRALIA_ORIENTALE, Territorio.AUSTRALIA_OCCIDENTALE});
	private int rinforzi;
	private Territorio[] territori;
	private String posseditore;
	Continente(int rinforzi, Territorio[] territori){
		this.rinforzi=rinforzi; this.territori=territori;
	}
	public int getRinforzi() {
		return rinforzi;
	}
	public Territorio[] getTerritori() {
		return territori;
	}
	
	public void setPosseditore(String posseditore) {
		this.posseditore=posseditore;
	}
	
	public String getPosseditore() {
		return posseditore;
	}

}

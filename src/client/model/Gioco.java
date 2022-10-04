package client.model;

import java.awt.Color;
import java.util.BitSet;

public interface Gioco {
	
	void setNomePartecipante(String nomePartecipante);
	
	String getNomePartecipante();
	
	void setTurnista(String turnista);
	String getTurnista();
	
	void setColoreArmate(Color coloreArmate);
	
	Color getColoreArmate();
	
	void azzeraArmateAttualmenteImpiegate();
	
	void setNazioneAttaccoA(String nazioneAttaccoA);
	void setNazioneAttaccoDA(String nazioneAttaccoDA);
	void setNazioneSpostaA(String nazioneSpostaPassaA);
	void setNazioneSpostaDA(String nazioneSpostaPassaDA);
	
	
	
	String getNazioneAttaccoDA();
	String getNazioneAttaccoA();
	String getNazioneSpostaDA();
	String getNazioneSpostaA();
	String getTerritori();
	
	void decrementaArmateDisponibili(int numero);
	void incrementaArmateDisponibili(int numero);
	int getArmateDisponibili();

	void incrementaArmateAttualmenteImpiegate();
	void decrementaArmateAttualmentaImpiegate();
	int getArmateAttualmenteImpiegate();
	
	
	void setDifensoreAttuale(String difensoreAttuale);
	String getDifensoreAttuale();
	
	
	
	boolean ePossibileIncrementareAttacco(String nazionaAttaccoDA);
	boolean ePossibileDecrementareAttacco(String nazioneAttaccoDA);
	boolean ePossibileIncrementareSposta(String nazioneSpostaDA);
	boolean ePossibileDecrementareSposta(String nazioneSpostaDA);
	boolean confinano(String nomeNazione1, String nomeNazione2);
	
	
	
	boolean possiedeNazione(String nomeNazione);

	void setPossedimenti(BitSet possedimenti);
	
	
	void incrementaArmatePosizionateInFasePre();
	void azzeraArmatePosizionateInFasePre();
	int getArmatePosizionateInFasePre();
	
	
	void setArmateSulleNazioni(int[] armateSulleNazioni);
	
	void settaPresaCarta();
	boolean haPresoCarta();
	void daiCarta(String carta);
	void cacciaCarte(int codiceCombinazione);
	String listaCarte();
	
	String getTelegrammi();
	void inserisciTelegramma(String telegramma);
	
	void setConquista(boolean c);
	boolean eConquista();

}

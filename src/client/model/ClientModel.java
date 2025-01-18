package client.model;
import java.awt.Color;

import comune.Ascoltatore;
import utilita.Console;
public interface ClientModel {
	
	void setAscoltatore(Ascoltatore ascoltatore);
	
	void setGioco(Gioco gioco);
	
	void registraFineFasePre(String nomePartecipante);
	
	void registraPartecipante(String nomePartecipante, String ip, String ipServer);
	
	void registraColoreArmate(String nomePartecipante,Color colore);
	
	void registraTiroDadoTurno(String nomePartecipante);
	
	void registraAttacco(String nomeNazioneDA, String nomeNazioneA, int armateImpiegate);
	
	void registraSpostamento(String nomeNazioneDA, String nomeNazioneA, int armateImpiegate,boolean easy);
	
	void registraPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmata, boolean eCarro,String nazioneInteressata);
	
	void registraPassaggioTurno();
	
	void setConsole(Console console);
	
	void inviaMessaggio(String messaggio);
	
	void verificaObbiettivo(String nomePartecipante);
	
	void inviaTelegramma(String telegramma,String destinatario);
}

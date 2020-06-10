package client.model;
import java.awt.Color;

import comune.Ascoltatore;
import utilità.Console;
public interface ClientModel {
	
	void setAscoltatore(Ascoltatore ascoltatore);
	
	void setGioco(Gioco gioco);
	
	
	
	void registraPartecipante(String nomePartecipante, String ip, String ipServer);
	
	void registraColoreArmate(String nomePartecipante,Color colore);
	
	void registraTiroDadoTurno(String nomePartecipante);
	
	void registraAttacco(String attaccante, String difensore, String nomeNazioneDA, String nomeNazioneA, int armateImpiegate);
	
	void registraAttaccanteAttuale(String nomePartecipante);
	
	void registraDifensoreAttuale(String nomeDifensore);
	
	void registraSpostamento(String nomePartecipante, String nomeNazioneDA, String nomeNazioneA, int armateImpiegate);
	
	void registraPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmata, boolean eCarro);
	
	void registraPassaggioTurno();
	
	void setConsole(Console console);
	
	void inviaMessaggio(String nomePartecipante,String messaggio);
	
}

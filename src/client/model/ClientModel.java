package client.model;
import java.awt.Color;

import comune.Ascoltatore;
import utilità.Console;
public interface ClientModel {
	
	void setAscoltatore(Ascoltatore ascoltatore);
	
	void registraPartecipante(String nomePartecipante, String ip, String ipServer);
	
	void settaColoreArmate(Color colore);
	
	void tiraDado();
	
	String getNomePartecipante();
	
	void setConsole(Console console);
}

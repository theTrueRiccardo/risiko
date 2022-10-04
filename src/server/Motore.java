package server;

import server.risiko.Azione;

public interface Motore extends Runnable{
	
	void schedula(Azione azione);
	
	

}

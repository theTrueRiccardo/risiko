package server;

import server.risiko.Azione;

public interface MotoreEasy extends Runnable {
	void schedulaEasy(Azione azione);
}

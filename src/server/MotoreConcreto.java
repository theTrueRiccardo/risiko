package server;

import server.risiko.Azione;

public class MotoreConcreto implements Motore{
	
	
	public void run() {
		while(true) {
			try {
				Risorse.possoPrendere.acquire();
				Risorse.mutex.acquire();
				Azione azione = Risorse.coda.removeFirst();
				azione.esegui();
				Risorse.mutex.release();
			}catch(Exception e) {e.printStackTrace();}
		}
	}

	
	
	@Override
	public void schedula(Azione azione) {
		try {
			Risorse.mutex.acquire();
			Risorse.coda.addLast(azione);
			Risorse.possoPrendere.release();
			Risorse.mutex.release();
		}catch(Exception e) {}
	}

}

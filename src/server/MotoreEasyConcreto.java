package server;

import server.risiko.Azione;

public class MotoreEasyConcreto implements MotoreEasy{

	@Override
	public void run() {
		while(true) {
			try {
				Risorse.possoPrendereEasy.acquire();
				Risorse.mutexEasy.acquire();
				Azione azione = Risorse.easyPass.removeFirst();
				azione.esegui();
				Risorse.mutexEasy.release();
			}catch(Exception e) {e.printStackTrace();}
		}
	}

	@Override
	public void schedulaEasy(Azione azione) {
		try {
			Risorse.mutexEasy.acquire();
			Risorse.easyPass.addLast(azione);
			Risorse.possoPrendereEasy.release();
			Risorse.mutexEasy.release();
		}catch(Exception e) {}
	}

}

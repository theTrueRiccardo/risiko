package test;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class MotoreConcreto extends Thread implements Motore{
	
	private LinkedList<Azione> coda = new LinkedList<Azione>();
	
	private Semaphore semaforo = new Semaphore(0);
	
	public void run() {
		while(true) {
			try {
				semaforo.acquire();
				Azione azione = coda.removeFirst();
				azione.esegui();
			}catch(Exception e) {e.printStackTrace();}
		}
	}

	
	
	@Override
	public synchronized void schedula(Azione azione) {
		coda.addLast(azione);
		semaforo.release();
	}

}

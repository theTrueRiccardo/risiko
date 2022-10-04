package server;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import server.risiko.Azione;

public class Risorse {
	
	static LinkedList<Azione> coda = new LinkedList<Azione>();
	
	static LinkedList<Azione> easyPass=new LinkedList<Azione>();
	
	static Semaphore mutex = new Semaphore(1);
	
	static Semaphore possoPrendere = new Semaphore(0);
	
	static Semaphore mutexEasy=new Semaphore(1);
	
	static Semaphore possoPrendereEasy=new Semaphore(0);
	
	
	
	

}

package server;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import comune.Server;

public class MainServer {
	
	private static Registry registro;

	public static void main(String[] args) throws Exception {
		String ipHamachi;
		Scanner sc = new Scanner(System.in);
		System.out.print("IP:");
		ipHamachi = sc.nextLine();
		sc.close();
		System.setProperty("java.rmi.server.hostname", ipHamachi);
		Server server = new ServerConcreto();
		registro = LocateRegistry.createRegistry(9000);
		registro.rebind("rmi://"+ipHamachi+":9000/SERVER", server);
		System.out.println("SERVER AVVIATO");
		//Logger logger=new Logger();
		//logger.start();
		
	}

}

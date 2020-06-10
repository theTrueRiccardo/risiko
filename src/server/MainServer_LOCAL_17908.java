package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import comune.Server;

public class MainServer {
	
	private static Registry registro;

	public static void main(String[] args) throws Exception {
		int a;
		Server server = new ServerConcreto();
		String ipHamachi;
		Scanner sc = new Scanner(System.in);
		System.out.print("IP:");
		ipHamachi = sc.nextLine();
		sc.close();
		System.setProperty("java.rmi.server.hostname", ipHamachi);
		registro = LocateRegistry.createRegistry(9000);
		registro.rebind("rmi://"+ipHamachi+":9000/SERVER", server);
		System.out.println("SERVER AVVIATO");
		
	}

}

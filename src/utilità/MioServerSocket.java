package utilità;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;
import java.net.*;
public class MioServerSocket implements RMIServerSocketFactory{

	private String ipHamachi;
	
	public MioServerSocket(String ipHamachi) {
		this.ipHamachi=ipHamachi;
	}
	
	
	
	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		return new ServerSocket(port,5,InetAddress.getByName(ipHamachi));
	}

}

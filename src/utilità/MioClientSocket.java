package utilità;

import java.io.IOException;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

public class MioClientSocket implements RMIClientSocketFactory {

	private String ipHamachi;
	
	public MioClientSocket(String ipHamachi) {
		this.ipHamachi=ipHamachi;
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException {
		return new Socket(ipHamachi,port);
	}

}

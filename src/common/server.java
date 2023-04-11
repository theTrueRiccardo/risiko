package comune;
import java.awt.Color;
import java.rmi.*;
public interface Server extends Remote {
	
	void registerPlayer(String playerName, String addressIP) throws RemoteException;
	
	void registerColorPlayer(String playerName, Color color) throws RemoteException;
	
	void registerDicePlayer(String playerName) throws RemoteException;
	
	void registerLocationArmy(String playerName,double percx, double percy,Color color, boolean isCarro, String nation) throws RemoteException;
	
	void registerPassTurn() throws RemoteException;
	
	void registerEndPreparation(String playerName) throws RemoteException;
	
	void sentMessage(String message) throws RemoteException;
	
	void registerAttack(String nationFrom, String nationTo, int usedArmy) throws RemoteException;
	
	void registerMovement(String nationFrom, String nationTo, int usedArmy,boolean easy) throws RemoteException;
	
	void registerCheckObjective(String playerName) throws RemoteException;
	
	void sentTelegram(String telegram,String recipient) throws RemoteException;

}

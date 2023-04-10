package comune;
import java.awt.Color;
import java.rmi.*;
public interface Server extends Remote {
	
	void registerPlayer(String namePlayer, String addressIP) throws RemoteException;
	
	void registerColorPlayer(String namePlayer, Color color) throws RemoteException;
	
	void registerDicePlayer(String namePlayer) throws RemoteException;
	
	void registerLocationArmy(String namePlayer,double percx, double percy,Color color, boolean isCarro, String nation) throws RemoteException;
	
	void registerPassTurn() throws RemoteException;
	
	void registerEndPreparation(String namePlayer) throws RemoteException;
	
	void sentMessage(String message) throws RemoteException;
	
	void registerAttack(String nationFrom, String nationTo, int armyUsed) throws RemoteException;
	
	void registerMovement(String nationFrom, String nationTo, int armyUsed,boolean easy) throws RemoteException;
	
	void registerCheckObjective(String namePlayer) throws RemoteException;
	
	void sentTelegram(String telegram,String recipient) throws RemoteException;

}

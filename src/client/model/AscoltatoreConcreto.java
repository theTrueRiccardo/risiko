package client.model;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.SwingUtilities;

import client.view.GiocoGUI;
import client.view.OpzioneGUI;
import client.view.RegistrazioneGUI;
import comune.Ascoltatore;

public class AscoltatoreConcreto implements Ascoltatore{
	
	private RegistrazioneGUI registrazioneGUI;
	
	private OpzioneGUI opzioneGUI;
	
	private GiocoGUI giocoGUI;
	
	private ClientModel clientModel;
	
	

	@Override
	public void ascoltaRegistrazionePartecipante(String nomePartecipante) throws RemoteException{
		System.out.println("Ascoltata registrazione " + nomePartecipante);
		registrazioneGUI.mostraMessaggio("Sei stato registrato come " + nomePartecipante + " con successo");
		System.out.println("Ascoltata registrazione " + nomePartecipante);
		registrazioneGUI.chiudiFinestra();
		opzioneGUI.apriFinestra();
	}

	@Override
	public void ascoltaSceltaColoreArmate(String nomePartecipante, Color coloreArmate) throws RemoteException {
		String suffisso ="";
		if(coloreArmate.equals(Color.RED)) suffisso="Rosse";
		else if(coloreArmate.equals(Color.BLACK)) suffisso="Nere";
		else if(coloreArmate.equals(Color.YELLOW)) suffisso="Gialle";
		else if(coloreArmate.equals(Color.BLUE)) suffisso="Blu";
		else if(coloreArmate.equals(Color.GREEN)) suffisso="Verdi";
		else suffisso="Viola";
		if(clientModel.getNomePartecipante().equals(nomePartecipante))opzioneGUI.disabilitaColori();
		opzioneGUI.disabilitaBottone("bottoneArmate" + suffisso);
		opzioneGUI.mostraAggiornamento(nomePartecipante + " ha scelto le armate " + suffisso);
		
	}

	@Override
	public void ascoltaRisultatoDadoTurno(String nomePartecipante,int faccia) throws RemoteException{
		opzioneGUI.mostraAggiornamento(nomePartecipante + " ha tirato " + faccia + " con il dado del turno");
		if(clientModel.getNomePartecipante().equals(nomePartecipante))opzioneGUI.disabilitaBottone("bottoneDado");
	}

	@Override
	public void ascoltaAvvioGioco(String testoObbiettivo, Color coloreArmate, String armateDisponibili, String turnista) throws RemoteException{
		opzioneGUI.mostraAggiornamento("Pronti a partire!!!!");
		opzioneGUI.mostraContoAllaRovescia();
		//apre la finestra di gioco
		giocoGUI.settaObbiettivo(testoObbiettivo);
		giocoGUI.settaColoreArmate(coloreArmate);
		giocoGUI.settaArmateDisponibili(armateDisponibili);
		giocoGUI.settaTurnista(turnista);
	}



	@Override
	public void ascoltaTurni(String giocatoriOrdinati) throws RemoteException {
		opzioneGUI.mostraAggiornamento(giocatoriOrdinati);
	}
	
	
	
	public void setRegistrazioneGUI(RegistrazioneGUI registrazioneGUI) {
		this.registrazioneGUI=registrazioneGUI;
	}

	
	public void setOpzioneGUI(OpzioneGUI opzioneGUI) {
		this.opzioneGUI=opzioneGUI;
	}

	
	public void setGiocoGUI(GiocoGUI giocoGUI) {
		this.giocoGUI=giocoGUI;
	}
	
	public void setClientModel(ClientModel clientModel) {
		this.clientModel=clientModel;
	}

}

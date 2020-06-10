package client.model;

import java.awt.Color;
import java.rmi.RemoteException;

import client.controller.gioco.ControllerApplicazione;
import client.controller.gioco.state.Posizionamento;
import client.controller.gioco.state.Pre;
import client.view.gioco.GiocoGUI;
import client.view.pregioco.OpzioneGUI;
import client.view.pregioco.RegistrazioneGUI;
import comune.Ascoltatore;
import utilità.Musica;

public class AscoltatoreConcreto implements Ascoltatore{
	
	private RegistrazioneGUI registrazioneGUI;
	
	private OpzioneGUI opzioneGUI;
	
	private GiocoGUI giocoGUI;
	
	private Gioco gioco;
	
	private ControllerApplicazione controllerApplicazione;
	
	
	public AscoltatoreConcreto(RegistrazioneGUI registrazioneGUI, OpzioneGUI opzioneGUI, GiocoGUI giocoGUI, Gioco gioco, ControllerApplicazione controllerApplicazione) {
		this.registrazioneGUI=registrazioneGUI;
		this.opzioneGUI=opzioneGUI;
		this.giocoGUI=giocoGUI;
		this.gioco=gioco;
		this.controllerApplicazione=controllerApplicazione;
	}


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
		if(gioco.getNomePartecipante().equals(nomePartecipante))opzioneGUI.disabilitaColori();
		opzioneGUI.disabilitaBottone("bottoneArmate" + suffisso);
		opzioneGUI.mostraAggiornamento(nomePartecipante + " ha scelto le armate " + suffisso);
		
	}

	@Override
	public void ascoltaRisultatoDadoTurno(String nomePartecipante,int faccia) throws RemoteException{
		opzioneGUI.mostraAggiornamento(nomePartecipante + " ha tirato " + faccia + " con il dado del turno");
		if(gioco.getNomePartecipante().equals(nomePartecipante))opzioneGUI.disabilitaBottone("bottoneDado");
	}

	@Override
	public void ascoltaAvvioGioco(String testoObbiettivo, Color coloreArmate, String armateDisponibili, String turnista, String[] posseditori) throws RemoteException{
		opzioneGUI.mostraAggiornamento("Pronti a partire!!!!");
		opzioneGUI.mostraContoAllaRovescia();
		//apre la finestra di gioco
		controllerApplicazione.setStato(Pre.STATO_PRE);
		giocoGUI.settaObbiettivo(testoObbiettivo);
		giocoGUI.settaColoreArmate(coloreArmate);
		gioco.incrementaArmateDisponibili(Integer.parseInt(armateDisponibili));
		gioco.setPosseditori(posseditori);
		giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		gioco.setTurnista(turnista);
		giocoGUI.scriviTurnista(gioco.getTurnista());
	}



	@Override
	public void ascoltaTurni(String giocatoriOrdinati) throws RemoteException {
		opzioneGUI.mostraAggiornamento(giocatoriOrdinati);
	}


	@Override
	public void ascoltaPosizionamentoArmata(String nomePartecipante, double percx, double percy, Color coloreArmate, boolean eCarro) throws RemoteException {
		if(nomePartecipante.equals(gioco.getNomePartecipante())) {
			giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		}
		giocoGUI.disegnaArmata(percx, percy, coloreArmate, eCarro);
	}


	@Override
	public void ascoltaPassaggioTurnoPre(String turnista, int rinforzi) throws RemoteException {
		Musica.suonaColtello();
		gioco.setTurnista(turnista);
		gioco.incrementaArmateDisponibili(rinforzi);
		if(turnista.equals(gioco.getNomePartecipante())) {
			controllerApplicazione.setStato(Pre.STATO_PRE);
		}
		giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		giocoGUI.scriviTurnista(gioco.getTurnista());
		giocoGUI.mostraMessaggio("E' il turno di " + gioco.getTurnista() + "!!");
		
	}


	@Override
	public void ascoltaPassaggioTurno(String turnista, int rinforzi) throws RemoteException {
		Musica.suonaColtello();
		gioco.setTurnista(turnista);
		gioco.incrementaArmateDisponibili(rinforzi);
		if(turnista.equals(gioco.getNomePartecipante())) {
			controllerApplicazione.setStato(Posizionamento.STATO_POSIZIONAMENTO);
		}
		giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		giocoGUI.scriviTurnista(gioco.getTurnista());
		giocoGUI.mostraMessaggio("E' il turno di " + gioco.getTurnista() + "!!");
		
	}
	

}

package client.model;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.BitSet;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import client.controller.gioco.ControllerApplicazione;
import client.controller.gioco.state.Passato;
import client.controller.gioco.state.Posizionamento;
import client.controller.gioco.state.Pre;
import client.controller.gioco.state.State;
import client.view.gioco.GiocoGUI;
import client.view.pregioco.OpzioneGUI;
import client.view.pregioco.RegistrazioneGUI;
import comune.Ascoltatore;
import utilita.Musica;

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
		registrazioneGUI.mostraMessaggio("Sei stato registrato come " + nomePartecipante + " con successo");
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
	public void ascoltaAvvioGioco(String testoObbiettivo, Color coloreArmate, String armateDisponibili, String turnista, BitSet possedimenti, int[] armateSulleNazioni) throws RemoteException{
		opzioneGUI.mostraAggiornamento("Pronti a partire!!!!");
		opzioneGUI.mostraContoAllaRovescia();
		//apre la finestra di gioco
		if(turnista.equals(gioco.getNomePartecipante())) {
			controllerApplicazione.setStato(Pre.STATO_PRE);
		}
		else {
			controllerApplicazione.setStato(Passato.STATO_PASSATO);
		}
		giocoGUI.settaObbiettivo(testoObbiettivo);
		giocoGUI.settaColoreArmate(coloreArmate);
		giocoGUI.scriviArmateAttacco(0);
		giocoGUI.scriviArmateSposta(0);
		gioco.incrementaArmateDisponibili(Integer.parseInt(armateDisponibili));
		gioco.setPossedimenti(possedimenti);
		gioco.setArmateSulleNazioni(armateSulleNazioni);
		giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		gioco.setTurnista(turnista);
		giocoGUI.scriviTurnista(gioco.getTurnista());
	}



	@Override
	public void ascoltaTurni(String giocatoriOrdinati) throws RemoteException {
		opzioneGUI.mostraAggiornamento("TURNI:");
		opzioneGUI.mostraAggiornamento(giocatoriOrdinati);
	}


	@Override
	public void ascoltaPosizionamentoArmata(String nomePartecipante, double percx, double percy, Color coloreArmate, boolean eCarro, int[] armateSulleNazioni,String nazione) throws RemoteException {
		Musica.suonaPosizione();
		gioco.setArmateSulleNazioni(armateSulleNazioni);
		if(nomePartecipante.equals(gioco.getNomePartecipante())) {
			giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		}
		giocoGUI.disegnaArmata(percx, percy, coloreArmate, eCarro,nazione);
	}


	@Override
	public void ascoltaPassaggioTurnoPre(String turnista) throws RemoteException {
		Musica.suonaColtello();
		gioco.setTurnista(turnista);
		if(turnista.equals(gioco.getNomePartecipante())) {
			controllerApplicazione.setStato(Pre.STATO_PRE);
		}
		giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		giocoGUI.scriviTurnista(gioco.getTurnista());
		giocoGUI.mostraMessaggio("E' il turno di " + gioco.getTurnista() + "!!");
		
	}


	@Override
	public void ascoltaPassaggioTurno(String turnista, int rinforzi,boolean fattaCombinazione,String combinazioneFatta,int codiceCombinazione) throws RemoteException {
		Musica.suonaColtello();
		gioco.setTurnista(turnista);
		if(turnista.equals(gioco.getNomePartecipante())) {
			gioco.incrementaArmateDisponibili(rinforzi);
			controllerApplicazione.setStato(Posizionamento.STATO_POSIZIONAMENTO);
		}
		giocoGUI.scriviArmateDisponibili(gioco.getArmateDisponibili()+"");
		giocoGUI.scriviTurnista(gioco.getTurnista());
		giocoGUI.mostraMessaggio("E' il turno di " + gioco.getTurnista() + "!!");
		if(fattaCombinazione) {
			giocoGUI.mostraMessaggio(turnista+" ha beccato una combinazione! Prende armate per avere "+combinazioneFatta);
			if(turnista.equals(gioco.getNomePartecipante())) {
				gioco.cacciaCarte(codiceCombinazione);
			}
		}
		
	}



	@Override
	public void ascoltaFineFasePre() throws RemoteException {
		Musica.suonaAnello();
		giocoGUI.mostraMessaggio("La fase preparatoria è finita. E' guerra.");
	}


	@Override
	public void ascoltaMessaggio(String messaggio) throws RemoteException {
		Musica.suonaMessaggio();
		giocoGUI.chat(messaggio);
	}


	@Override
	public void ascoltaRisultatoBattaglia(String attaccante, String difensore, String risultatoAttaccante,String risultatoDifensore, int[] armateSulleNazioni, BitSet possedimentiAttaccante,BitSet possedimentiDifensore) throws RemoteException {
		Musica.suonaGuerra();
		if(gioco.getNomePartecipante().equals(attaccante)) {
			gioco.setPossedimenti(possedimentiAttaccante);
		}
		if(gioco.getNomePartecipante().equals(difensore)) {
			gioco.setPossedimenti(possedimentiDifensore);
		}
		gioco.setArmateSulleNazioni(armateSulleNazioni);
		giocoGUI.settaAttaccante(attaccante);
		giocoGUI.settaDifensore(difensore);
		giocoGUI.settaRisultatoAttaccante(risultatoAttaccante);
		giocoGUI.settaRisultatoDifensore(risultatoDifensore);
	}


	@Override
	public void ascoltaConquistaNazione(String nazione, String conquistatore) throws RemoteException {
		giocoGUI.mostraMessaggio(conquistatore + " ha conquistato " + nazione + "!");
		if(conquistatore.equals(gioco.getNomePartecipante())) {
			gioco.setConquista(true);
			for(;;) {
				try {
					int armate = Integer.parseInt(JOptionPane.showInputDialog("Avendo conquistato la nazione, scrivi quante armate spostare"));
					if(armate<=0) throw new RuntimeException("Numero <= 0");
					for(int i = 0; i < armate; i++) {
						if(!gioco.ePossibileIncrementareAttacco(gioco.getNazioneAttaccoDA())) throw new RuntimeException("Problema incremento armate impiegate");
						gioco.incrementaArmateAttualmenteImpiegate();
					}
					controllerApplicazione.getClientModel().registraSpostamento(gioco.getNazioneAttaccoDA(), gioco.getNazioneAttaccoA(), gioco.getArmateAttualmenteImpiegate(),true);
					gioco.azzeraArmateAttualmenteImpiegate();
					gioco.setConquista(false);
					break;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Qualcosa è andato storto.\nEccezione:"+e.toString());
					gioco.azzeraArmateAttualmenteImpiegate();
				}
			}
		}
	}


	@Override
	public void ascoltaCancellamentoArmate(int armate, String nazione) throws RemoteException {
		giocoGUI.cancellaArmate(armate, nazione);
	}


	@Override
	public void ascoltaVittoria(String vincitore, String obbiettivo) throws RemoteException {
		giocoGUI.mostraMessaggio(vincitore + " Ha vinto. Il suo obbiettivo era: "+obbiettivo);
	}


	@Override
	public void ascoltaNonVittoria() throws RemoteException {
		giocoGUI.mostraMessaggio("Ancora non hai vinto");
	}


	@Override
	public void ascoltaCarta(String carta) throws RemoteException {
		gioco.daiCarta(carta);
		giocoGUI.mostraMessaggio("Hai ottenuto una carta: " + carta);
	}


	@Override
	public void ascoltaTelegramma(String telegramma) throws RemoteException {
		gioco.inserisciTelegramma(telegramma);
	}
	

}

package client.model;
import client.controller.gioco.ControllerApplicazione;
import client.controller.gioco.ControllerApplicazioneConcreto;
import client.controller.gioco.ControllerBottoneApriCodaTelegrammi;
import client.controller.gioco.ControllerBottoneAttacca;
import client.controller.gioco.ControllerBottoneBandiera;
import client.controller.gioco.ControllerBottoneCarro;
import client.controller.gioco.ControllerBottoneCarte;
import client.controller.gioco.ControllerBottoneDecrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneDecrementoArmateSposta;
import client.controller.gioco.ControllerBottoneFaseAttacco;
import client.controller.gioco.ControllerBottoneFaseSpostamento;
import client.controller.gioco.ControllerBottoneIncrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneIncrementoArmateSposta;
import client.controller.gioco.ControllerBottoneInvia;
import client.controller.gioco.ControllerBottoneInviaTelegramma;
import client.controller.gioco.ControllerBottoneObbiettivo;
import client.controller.gioco.ControllerBottonePassa;
import client.controller.gioco.ControllerBottoneSposta;
import client.controller.gioco.ControllerBottoneTerritori;
import client.controller.gioco.ControllerMappa;
import client.controller.pregioco.ControllerBottoneColoreArmate;
import client.controller.pregioco.ControllerBottoneDadoTurno;
import client.controller.pregioco.ControllerBottoneRegistrazione;
import client.view.gioco.GiocoGUI;
import client.view.gioco.GiocoGUIConcreto;
import client.view.pregioco.OpzioneGUI;
import client.view.pregioco.OpzioneGUIConcreto;
import client.view.pregioco.RegistrazioneGUI;
import client.view.pregioco.RegistrazioneGUIConcreto;
import utilita.Console;
import utilita.GloboGrafico;
import utilita.GloboGraficoConcreto;

public class MainClient {

	public static void main(String[] args) throws Exception{
		GloboGrafico globoGrafico = new GloboGraficoConcreto();
		ClientModel clientModel = new ClientModelConcreto();
		Gioco gioco = new GiocoConcreto();
		clientModel.setGioco(gioco);
		Console console = new Console();
		clientModel.setConsole(console);
		
		
		RegistrazioneGUI registrazioneGUI = new RegistrazioneGUIConcreto();
		OpzioneGUI opzioneGUI = new OpzioneGUIConcreto();
		GiocoGUI giocoGUI = new GiocoGUIConcreto();
		opzioneGUI.setGiocoGUI(giocoGUI);
		
		ControllerBottoneRegistrazione controllerBottoneRegistrazione = new ControllerBottoneRegistrazione(clientModel,gioco,registrazioneGUI);
		ControllerBottoneColoreArmate controllerBottoneColoreArmate = new ControllerBottoneColoreArmate(clientModel, gioco);
		ControllerBottoneDadoTurno controllerBottoneDadoTurno = new ControllerBottoneDadoTurno(clientModel, gioco);
		registrazioneGUI.setControllerBottoneRegistrazione(controllerBottoneRegistrazione);
		opzioneGUI.setControllerBottoneColoreArmate(controllerBottoneColoreArmate);
		opzioneGUI.setControllerBottoneDadoTurno(controllerBottoneDadoTurno);
		
		
		
		ControllerApplicazione controllerApplicazione = new ControllerApplicazioneConcreto(giocoGUI, globoGrafico, clientModel, gioco);
		ControllerBottoneAttacca controllerBottoneAttacca = new ControllerBottoneAttacca(controllerApplicazione);
		ControllerBottoneBandiera controllerBottoneBandiera = new ControllerBottoneBandiera(controllerApplicazione);
		ControllerBottoneCarro controllerBottoneCarro = new ControllerBottoneCarro(controllerApplicazione);
		ControllerBottoneDecrementoArmateAttacco controllerBottoneDecrementoArmateAttacco = new ControllerBottoneDecrementoArmateAttacco(controllerApplicazione);
		ControllerBottoneDecrementoArmateSposta controllerBottoneDecrementoArmateSposta = new ControllerBottoneDecrementoArmateSposta(controllerApplicazione);
		ControllerBottoneFaseAttacco controllerBottoneFaseAttacco = new ControllerBottoneFaseAttacco(controllerApplicazione);
		ControllerBottoneFaseSpostamento controllerBottoneFaseSpostamento = new ControllerBottoneFaseSpostamento(controllerApplicazione);
		ControllerBottoneIncrementoArmateAttacco controllerBottoneIncrementoArmateAttacco = new ControllerBottoneIncrementoArmateAttacco(controllerApplicazione);
		ControllerBottoneIncrementoArmateSposta controllerBottoneIncrementoArmateSposta = new ControllerBottoneIncrementoArmateSposta(controllerApplicazione);
		ControllerBottonePassa controllerBottonePassa = new ControllerBottonePassa(controllerApplicazione);
		ControllerBottoneSposta controllerBottoneSposta = new ControllerBottoneSposta(controllerApplicazione);
		ControllerMappa controllerMappa = new ControllerMappa(controllerApplicazione);
		ControllerBottoneTerritori controllerBottoneTerritori = new ControllerBottoneTerritori(controllerApplicazione);
		ControllerBottoneInvia controllerBottoneInvia = new ControllerBottoneInvia(controllerApplicazione);
		ControllerBottoneObbiettivo controllerBottoneObbiettivo=new ControllerBottoneObbiettivo(controllerApplicazione);
		ControllerBottoneCarte controllerBottoneCarte=new ControllerBottoneCarte(controllerApplicazione);
		ControllerBottoneInviaTelegramma controllerBottoneInviaTelegramma=new ControllerBottoneInviaTelegramma(controllerApplicazione);
		ControllerBottoneApriCodaTelegrammi controllerBottoneApriCodaTelegrammi=new ControllerBottoneApriCodaTelegrammi(controllerApplicazione);
		giocoGUI.setControllerBottoneAttacca(controllerBottoneAttacca);
		giocoGUI.setControllerBottoneBandiera(controllerBottoneBandiera);
		giocoGUI.setControllerBottoneCarro(controllerBottoneCarro);
		giocoGUI.setControllerBottoneDecrementoArmateAttacco(controllerBottoneDecrementoArmateAttacco);
		giocoGUI.setControllerBottoneDecrementoArmateSposta(controllerBottoneDecrementoArmateSposta);
		giocoGUI.setControllerBottoneFaseAttacco(controllerBottoneFaseAttacco);
		giocoGUI.setControllerBottoneFaseSpostamento(controllerBottoneFaseSpostamento);
		giocoGUI.setControllerBottoneIncrementoArmateAttacco(controllerBottoneIncrementoArmateAttacco);
		giocoGUI.setControllerBottoneIncrementoArmateSposta(controllerBottoneIncrementoArmateSposta);
		giocoGUI.setControllerBottonePassa(controllerBottonePassa);
		giocoGUI.setControllerBottoneSposta(controllerBottoneSposta);
		giocoGUI.setControllerMappa(controllerMappa);
		giocoGUI.setControllerBottoneTerritori(controllerBottoneTerritori);
		giocoGUI.setControllerBottoneInvia(controllerBottoneInvia);
		giocoGUI.setControllerBottoneObbiettivo(controllerBottoneObbiettivo);
		giocoGUI.setControllerBottoneInviaTelegramma(controllerBottoneInviaTelegramma);
		giocoGUI.setControllerBottoneCarte(controllerBottoneCarte);
		giocoGUI.setControllerBottoneApriCodaTelegrammi(controllerBottoneApriCodaTelegrammi);
		
			
		
		
		AscoltatoreConcreto ascoltatore = new AscoltatoreConcreto(registrazioneGUI, opzioneGUI, giocoGUI, gioco, controllerApplicazione);
		clientModel.setAscoltatore(ascoltatore);
		
			
	}

}

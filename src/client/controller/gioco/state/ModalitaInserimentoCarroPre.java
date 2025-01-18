package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.ClientModel;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;
import utilita.GloboGrafico;

public enum ModalitaInserimentoCarroPre implements State{
	
	STATO_MODALITA_INSERIMENTO_CARRO_PRE;

	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi andare nella fase attacco durante la fase preparatoria");
	}

	@Override
	public void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi andare nella fase di spostamento durante la fase preparatoria");
	}

	@Override
	public void cliccataBandiera(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare bandiere durante la fase preparatoria");
	}

	@Override
	public void cliccatoCarro(ControllerApplicazione controllerApplicazione) {
		//No op.
	}

	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y) {
		GiocoGUI giocoGUI = controllerApplicazione.getFinestraApplicazione();
		GloboGrafico globoGrafico = controllerApplicazione.getGloboGrafico();
		Gioco gioco = controllerApplicazione.getGioco();
		ClientModel clientModel = controllerApplicazione.getClientModel();
		
		double larghezzaMappa = giocoGUI.getLarghezzaMappa();
		double altezzaMappa = giocoGUI.getAltezzaMappa();
		double percx = (x/larghezzaMappa)*100;
		double percy = (y/altezzaMappa)*100;
		
		String nomeNazione = globoGrafico.nazioneAlPunto(percx, percy);
		
		if(nomeNazione.equals("Mare")) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi inserire il carro in mare");
		}
		else if(!gioco.possiedeNazione(nomeNazione)) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi inserire il carro in una nazione non tua");
		}
		
		else {
			gioco.decrementaArmateDisponibili(1);
			gioco.incrementaArmatePosizionateInFasePre();
			clientModel.registraPosizionamentoArmata(gioco.getNomePartecipante(),percx, percy,gioco.getColoreArmate(), true, nomeNazione);
			controllerApplicazione.setStato(Pre.STATO_PRE);
		}
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare durante la fase preparatoria");
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi spostare durante la fase preparatoria");
	}

	@Override
	public void cliccatoPassa(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima posizionare il carro");
	}

	@Override
	public void cliccatoIncrementoAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di attacco");
	}

	@Override
	public void cliccatoDecrementoAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di attacco");
	}

	@Override
	public void cliccatoIncrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di spostamento");
	}

	@Override
	public void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di spostamento");
	}
	
	

}

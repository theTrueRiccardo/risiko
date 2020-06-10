package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.controller.gioco.GloboGrafico;
import client.model.ClientModel;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;

public enum Modalit‡InserimentoCarro implements State{
	
	STATO_MODALITA_INSERIMENTO_CARRO;

	

	@Override
	public void cliccataBandiera(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(gioco.getArmateDisponibili()>10) {
			controllerApplicazione.setStato(Modalit‡InserimentoBandiera.STATO_MODALITA_INSERIMENTO_BANDIERA);
		}
		else {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non hai sufficienti armate per posizionare una bandiera");
		}
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
		
		if(gioco.possiedeNazione(nomeNazione)) {
			gioco.decrementaArmateDisponibili(1);
			clientModel.registraPosizionamentoArmata(gioco.getNomePartecipante(),percx, percy,gioco.getColoreArmate(), true);
			controllerApplicazione.setStato(Posizionamento.STATO_POSIZIONAMENTO);
		}
		else if(nomeNazione.equals("Mare")){
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare il carro in mare");
		}
		else {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare il carro in una nazione non tua");
		}
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima posizionare il carro");
	}


	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima posizionare il carro");		
	}

	@Override
	public void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima posizionare il carro");		
		
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima posizionare il carro");		
		
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

package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.Gioco;

public enum Posizionamento implements State{

	STATO_POSIZIONAMENTO;

	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(gioco.getArmateDisponibili()>0) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima posizionare tutte le tue armate disponibili");
		}
		else {
			controllerApplicazione.setStato(FaseAttacco.STATO_FASE_ATTACCO);
		}
	}

	@Override
	public void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(gioco.getArmateDisponibili()>0) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima posizionare tutte le tue armate disponibili");
		}
		else {
			controllerApplicazione.setStato(FaseSpostamento.STATO_FASE_SPOSTAMENTO);
		}
	}

	@Override
	public void cliccataBandiera(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(gioco.getArmateDisponibili()<10) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non hai armate sufficienti per posizionare una bandiera");
		}
		else {
			controllerApplicazione.setStato(ModalitàInserimentoBandiera.STATO_MODALITA_INSERIMENTO_BANDIERA);
		}
	}

	@Override
	public void cliccatoCarro(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(gioco.getArmateDisponibili()<1) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non hai armate sufficienti per posizionare un carro");
		}
		else {
			controllerApplicazione.setStato(ModalitàInserimentoCarro.STATO_MODALITA_INSERIMENTO_CARRO);
		}
		
	}

	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima passare nella fase di attacco");
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima passare nella fase di spostamento");
		
	}

	@Override
	public void cliccatoPassa(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima terminare la fase di spostamento");
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
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di attacco");
	}

	@Override
	public void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di attacco");
	}
}

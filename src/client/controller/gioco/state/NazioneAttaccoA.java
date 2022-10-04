package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.ClientModel;
import client.model.Gioco;

public enum NazioneAttaccoA implements State{

	STATO_NAZIONE_ATTACCO_A;

	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Sei gi� nella fase di attacco");
	}

	@Override
	public void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.setStato(FaseSpostamento.STATO_FASE_SPOSTAMENTO);
	}

	@Override
	public void cliccataBandiera(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare armate durante la fase di attacco");
	}

	@Override
	public void cliccatoCarro(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare armate durante la fase di attacco");
	}

	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		controllerApplicazione.getFinestraApplicazione().scriviNazioneAttaccoA("");
		controllerApplicazione.setStato(NazioneAttaccoDA.STATO_NAZIONE_ATTACCO_DA);
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(gioco.getArmateAttualmenteImpiegate()==0) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima decidere con quante armate attaccare");
			return;
		}
		ClientModel clientModel = controllerApplicazione.getClientModel();
		clientModel.registraAttacco(
				gioco.getNazioneAttaccoDA(),
				gioco.getNazioneAttaccoA(),
				gioco.getArmateAttualmenteImpiegate()
		);
		gioco.azzeraArmateAttualmenteImpiegate();
		controllerApplicazione.getFinestraApplicazione().scriviArmateAttacco(0);
		controllerApplicazione.getFinestraApplicazione().scriviNazioneAttaccoA("");
		controllerApplicazione.getFinestraApplicazione().scriviNazioneAttaccoDA("");
		controllerApplicazione.setStato(FaseAttacco.STATO_FASE_ATTACCO);
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di spostamento");
	}

	@Override
	public void cliccatoPassa(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entrare nella fase di spostamento");
	}
	
	
	@Override
	public void cliccatoIncrementoAttacco(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(!gioco.ePossibileIncrementareAttacco(gioco.getNazioneAttaccoDA())) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi impiegare altre truppe da questa nazione");
		}
		else {
			gioco.incrementaArmateAttualmenteImpiegate();
			controllerApplicazione.getFinestraApplicazione().scriviArmateAttacco(gioco.getArmateAttualmenteImpiegate());
		}
	}

	@Override
	public void cliccatoDecrementoAttacco(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(!gioco.ePossibileDecrementareAttacco(gioco.getNazioneAttaccoDA())) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi impiegare meno truppe da questa nazione");
		}
		else {
			gioco.decrementaArmateAttualmentaImpiegate();
			controllerApplicazione.getFinestraApplicazione().scriviArmateAttacco(gioco.getArmateAttualmenteImpiegate());
		}
	}

	@Override
	public void cliccatoIncrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entare nella fase di spostamento");
	}

	@Override
	public void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entare nella fase di spostamento");
	}
	
	
	
}

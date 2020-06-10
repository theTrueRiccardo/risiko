package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.ClientModel;
import client.model.Gioco;

public enum NazioneSpostaA implements State{
	
	STATO_NAZIONE_SPOSTA_A;

	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi entrare nella fase di attacco");
	}

	@Override
	public void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Sei già nella fase di spostamento");
	}

	@Override
	public void cliccataBandiera(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare armate durante la fase di spostamento");
	}

	@Override
	public void cliccatoCarro(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare armate durante la fase di spostamento");
	}

	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		controllerApplicazione.getFinestraApplicazione().scriviNazioneSpostaA("");
		controllerApplicazione.setStato(NazioneSpostaDA.STATO_NAZIONE_SPOSTA_DA);
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare durante la fase di spostamento");
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		ClientModel clientModel = controllerApplicazione.getClientModel();
		Gioco gioco = controllerApplicazione.getGioco();
		clientModel.registraSpostamento(
				gioco.getNomePartecipante(), 
				gioco.getNazioneAttaccoDA(), 
				gioco.getNazioneSpostaA(), 
				gioco.getArmateAttualmenteImpiegate()
		);
		controllerApplicazione.setStato(PrePassa.STATO_PRE_PASSA);
	}
	
	

	@Override
	public void cliccatoPassa(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getClientModel().registraPassaggioTurno();
		controllerApplicazione.setStato(Passato.STATO_PASSATO);
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
		Gioco gioco = controllerApplicazione.getGioco();
		if(!gioco.ePossibileIncrementareSposta(gioco.getNazioneSpostaDA())) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi impiegare altre truppe da questa nazione");
		}
		else {
			gioco.incrementaArmateAttualmenteImpiegate();
			controllerApplicazione.getFinestraApplicazione().scriviArmateSposta(gioco.getArmateAttualmenteImpiegate());
		}
	}

	@Override
	public void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(!gioco.ePossibileIncrementareSposta(gioco.getNazioneSpostaDA())) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi impiegare altre truppe da questa nazione");
		}
		else {
			gioco.decrementaArmateAttualmentaImpiegate();
			controllerApplicazione.getFinestraApplicazione().scriviArmateSposta(gioco.getArmateAttualmenteImpiegate());
		}
	}
	
}

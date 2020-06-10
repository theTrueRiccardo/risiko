package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;

public enum PrePassa implements State{
	
	STATO_PRE_PASSA;

	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccataBandiera(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoCarro(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoPassa(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getClientModel().registraPassaggioTurno();
		controllerApplicazione.setStato(Passato.STATO_PASSATO);
	}

	@Override
	public void cliccatoIncrementoAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoDecrementoAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoIncrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}

	@Override
	public void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi solo passare ora");
	}
	
	
	

}

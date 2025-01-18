package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;
import utilita.GloboGrafico;

public enum NazioneSpostaDA implements State{
	
	STATO_NAZIONE_SPOSTA_DA;

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
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare armate nella fase di spostamento");
	}

	@Override
	public void cliccatoCarro(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare armate nella fase di spostamento");
	}

	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y) {
		GloboGrafico globoGrafico = controllerApplicazione.getGloboGrafico();
		Gioco gioco = controllerApplicazione.getGioco();
		GiocoGUI finestraApplicazione = controllerApplicazione.getFinestraApplicazione();
		
		double larghezzaMappa = finestraApplicazione.getLarghezzaMappa();
		double altezzaMappa = finestraApplicazione.getAltezzaMappa();
		double percx = (x/larghezzaMappa)*100;
		double percy = (y/altezzaMappa)*100;
		
		String nomeNazione = globoGrafico.nazioneAlPunto(percx, percy);
		
		if(nomeNazione.equals("Mare")) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi spostarti sul mare");
		}
		else if(!gioco.possiedeNazione(nomeNazione)) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi spostarti verso una nazione non tua");
		}
		else if(!gioco.confinano(gioco.getNazioneSpostaDA(), nomeNazione)) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Le due nazioni non confinano");
		}
		else {
			finestraApplicazione.scriviNazioneSpostaA(nomeNazione);
			gioco.setNazioneSpostaA(nomeNazione);
			controllerApplicazione.setStato(NazioneSpostaA.STATO_NAZIONE_SPOSTA_A);
		}
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		controllerApplicazione.getFinestraApplicazione().scriviNazioneSpostaDA("");
		controllerApplicazione.setStato(FaseSpostamento.STATO_FASE_SPOSTAMENTO);
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare in fase spostamento");
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima scegliere la nazione sulla quale spostarti");
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

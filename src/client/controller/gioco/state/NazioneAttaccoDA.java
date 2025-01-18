package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;
import utilita.GloboGrafico;

public enum NazioneAttaccoDA implements State{
	
	STATO_NAZIONE_ATTACCO_DA;

	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Sei già nella fase di attacco");
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
		GloboGrafico globoGrafico = controllerApplicazione.getGloboGrafico();
		Gioco gioco = controllerApplicazione.getGioco();
		GiocoGUI finestraApplicazione = controllerApplicazione.getFinestraApplicazione();
		
		
		double larghezzaMappa = finestraApplicazione.getLarghezzaMappa();
		double altezzaMappa = finestraApplicazione.getAltezzaMappa();
		double percx = (x/larghezzaMappa)*100;
		double percy = (y/altezzaMappa)*100;
		
		String nomeNazione = globoGrafico.nazioneAlPunto(percx, percy);
		
		if(nomeNazione.equals("Mare")) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare il mare");
		}
		else if(gioco.possiedeNazione(nomeNazione)) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare una tua nazione");
		}
		else if(!gioco.confinano(gioco.getNazioneAttaccoDA(), nomeNazione)) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Le due nazioni non confinano");
		}
		else {
			finestraApplicazione.scriviNazioneAttaccoA(nomeNazione);
			gioco.setNazioneAttaccoA(nomeNazione);
			//gioco.setDifensoreAttuale(gioco.getPosseditoreNazione(nomeNazione));
			controllerApplicazione.setStato(NazioneAttaccoA.STATO_NAZIONE_ATTACCO_A);
		}
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		controllerApplicazione.getFinestraApplicazione().scriviNazioneAttaccoDA("");
		controllerApplicazione.setStato(FaseAttacco.STATO_FASE_ATTACCO);
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima selezionare la nazione da attaccare");
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entare nella fase di spostamento");
	}

	@Override
	public void cliccatoPassa(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima entare nella fase di spostamento");
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

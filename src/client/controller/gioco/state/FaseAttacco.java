package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;
import utilità.GloboGrafico;

public enum FaseAttacco implements State{
	
	STATO_FASE_ATTACCO;

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
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare dal mare");
		}
		else if(!gioco.possiedeNazione(nomeNazione)) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare da una nazione non tua");
		}
		else {
			finestraApplicazione.scriviNazioneAttaccoDA(nomeNazione);
			gioco.setNazioneAttaccoDA(nomeNazione);
			controllerApplicazione.setStato(NazioneAttaccoDA.STATO_NAZIONE_ATTACCO_DA);
		}
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima selezionare la nazione da cui parte l'attacco e la nazione che vuoi attaccare");
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
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima selezionare la nazione dalla quale vuoi attaccare");
	}

	@Override
	public void cliccatoDecrementoAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima selezionare la nazione dalla quale vuoi attaccare");
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

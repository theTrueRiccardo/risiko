package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;
import utilità.GloboGrafico;

public enum FaseSpostamento implements State{

	STATO_FASE_SPOSTAMENTO;

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
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare armate duarnte la fase di spostamento");
	}

	
	
	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y) {
		GloboGrafico globoGrafico = controllerApplicazione.getGloboGrafico();
		Gioco gioco = controllerApplicazione.getGioco();
		//MappaGUI mappa = controllerApplicazione.getMappa();
		GiocoGUI finestraApplicazione = controllerApplicazione.getFinestraApplicazione();
		
		
		double larghezzaMappa = finestraApplicazione.getLarghezzaMappa();
		double altezzaMappa = finestraApplicazione.getAltezzaMappa();
		double percx = (x/larghezzaMappa)*100;
		double percy = (y/altezzaMappa)*100;
		
		String nomeNazione = globoGrafico.nazioneAlPunto(percx, percy);
		
		if(nomeNazione.equals("Mare")) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi spostarti dal mare");
		}
		else if(!gioco.possiedeNazione(nomeNazione)) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi spostarti da una nazione non tua");
		}
		else {
			finestraApplicazione.scriviNazioneSpostaDA(nomeNazione);
			gioco.setNazioneSpostaDA(nomeNazione);
			controllerApplicazione.setStato(NazioneSpostaDA.STATO_NAZIONE_SPOSTA_DA);
		}
	}
	
	
	

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
	}

	@Override
	public void cliccatoAttacca(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi attaccare nella fase di spostamento");
	}

	@Override
	public void cliccatoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima selezionare la nazione dalla quale vuoi spostarti");
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
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima selezionare la nazione dalla quale ti vuoi spostare");
	}

	@Override
	public void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima selezionare la nazione dalla quale ti vuoi spostare");
	}
	
	
}

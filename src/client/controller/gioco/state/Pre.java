package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;
import client.model.Gioco;

public enum Pre implements State{
	
	STATO_PRE;

	@Override
	public void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi andare nella fase attacco durante la fase preparatoria");
	}

	@Override
	public void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi andare nella fase attacco durante la fase preparatoria");
	}

	@Override
	public void cliccataBandiera(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Non puoi posizionare bandiere durante la fase preparatoria");
	}

	@Override
	public void cliccatoCarro(ControllerApplicazione controllerApplicazione) {
		Gioco gioco = controllerApplicazione.getGioco();
		if(gioco.getArmateDisponibili()>0) {
			controllerApplicazione.setStato(ModalitàInserimentoCarroPre.STATO_MODALITA_INSERIMENTO_CARRO_PRE);
		}
		else {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Hai esaurito le armate disponibili");
		}
	}

	@Override
	public void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione,double x, double y) {
		//No op.
	}

	@Override
	public void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y) {
		//No op.
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
		if(controllerApplicazione.getGioco().getArmateDisponibili()>0) {
			controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi impiegare tutte le tue armate prima di passare");
		}
		else {
			controllerApplicazione.setStato(Passato.STATO_PASSATO);
		}
	}

	@Override
	public void cliccatoIncrementoAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima passare alla fase di attacco");
	}

	@Override
	public void cliccatoDecrementoAttacco(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima passare alla fase di attacco");
	}

	@Override
	public void cliccatoIncrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima passare alla fase di spostamento");
	}

	@Override
	public void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione) {
		controllerApplicazione.getFinestraApplicazione().mostraMessaggio("Devi prima passare alla fase di spostamento");
	}
	
	

}

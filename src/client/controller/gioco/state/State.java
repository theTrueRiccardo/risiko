package client.controller.gioco.state;

import client.controller.gioco.ControllerApplicazione;

public interface State {
	
	void cliccatoBottoneFaseAttacco(ControllerApplicazione controllerApplicazione);
	
	void cliccatoBottoneFaseSposta(ControllerApplicazione controllerApplicazione);
	
	void cliccataBandiera(ControllerApplicazione controllerApplicazione);
	
	void cliccatoCarro(ControllerApplicazione controllerApplicazione);
	
	void cliccataMappaTastoSinistro(ControllerApplicazione controllerApplicazione, double x, double y);
	
	void cliccataMappaTastoDestro(ControllerApplicazione controllerApplicazione, double x, double y);
	
	void cliccatoAttacca(ControllerApplicazione controllerApplicazione);
	
	void cliccatoSposta(ControllerApplicazione controllerApplicazione);
	
	void cliccatoPassa(ControllerApplicazione controllerApplicazione);
	
	void cliccatoIncrementoAttacco(ControllerApplicazione controllerApplicazione);

	void cliccatoDecrementoAttacco(ControllerApplicazione controllerApplicazione);
	
	void cliccatoIncrementoSposta(ControllerApplicazione controllerApplicazione);
	
	void cliccatoDecrementoSposta(ControllerApplicazione controllerApplicazione);
	
}

package client.controller.gioco;

import client.controller.gioco.state.State;
import client.model.ClientModel;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;

public interface ControllerApplicazione{

	void inviaMessaggio(String messaggio);
	
	void apriCodaTelegrammi();
	
	void inviaTelegramma(String telegramma);
	
	void mostraCarte();
	
	void mostraTerritori();
	
	void setStato(State stato);
	
	GiocoGUI getFinestraApplicazione();
	
	GloboGrafico getGloboGrafico();
	
	Gioco getGioco();
	
	ClientModel getClientModel();
	
	//-----------------------------------------------------------------------
	
	void cliccatoBottoneFaseAttacco();
	
	void cliccatoBottoneFaseSposta();
	
	void cliccataBandiera();
	
	void cliccatoCarro();
	
	void cliccataMappaTastoSinistro(double x, double y);
	
	void cliccataMappaTastoDestro(double x, double y);
	
	void cliccatoAttacca();
	
	void cliccatoSposta();
	
	void cliccatoPassa();
	
	void cliccatoIncrementoAttacco();

	void cliccatoDecrementoAttacco();
	
	void cliccatoIncrementoSposta();
	
	void cliccatoDecrementoSposta();
	
	
	

}

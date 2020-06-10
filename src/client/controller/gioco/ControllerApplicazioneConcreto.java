package client.controller.gioco;

import client.controller.gioco.state.State;
import client.model.ClientModel;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;


public class ControllerApplicazioneConcreto implements ControllerApplicazione {
	

	
	private GiocoGUI giocoGUI;
	private GloboGrafico globoGrafico;
	private ClientModel clientModel;
	private Gioco gioco;
	
	
	
	
	public ControllerApplicazioneConcreto(GiocoGUI giocoGUI, GloboGrafico globoGrafico, ClientModel clientModel, Gioco gioco) {
		this.giocoGUI=giocoGUI;
		this.globoGrafico=globoGrafico;
		this.clientModel=clientModel;
		this.gioco=gioco;
	}
	
	
	
	private State statoCorrente;
	


	@Override
	public void inviaMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void apriCodaTelegrammi() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inviaTelegramma(String telegramma) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mostraCarte() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mostraTerritori() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setStato(State stato) {
		this.statoCorrente=stato;
	}
	@Override
	public GiocoGUI getFinestraApplicazione() {
		return giocoGUI;
	}
	@Override
	public GloboGrafico getGloboGrafico() {
		return globoGrafico;
	}
	@Override
	public Gioco getGioco() {
		return gioco;
	}
	@Override
	public ClientModel getClientModel() {
		return clientModel;
	}
	
	
	
	//--------------------------------------------------
	
	
	
	@Override
	public void cliccatoBottoneFaseAttacco() {
		statoCorrente.cliccatoBottoneFaseAttacco(this);
	}
	@Override
	public void cliccatoBottoneFaseSposta() {
		statoCorrente.cliccatoBottoneFaseSposta(this);
	}
	@Override
	public void cliccataBandiera() {
		statoCorrente.cliccataBandiera(this);
	}
	@Override
	public void cliccatoCarro() {
		statoCorrente.cliccatoCarro(this);
	}
	@Override
	public void cliccataMappaTastoSinistro(double x, double y) {
		statoCorrente.cliccataMappaTastoSinistro(this,x,y);
	}
	@Override
	public void cliccataMappaTastoDestro(double x, double y) {
		statoCorrente.cliccataMappaTastoDestro(this,x,y);
	}
	@Override
	public void cliccatoAttacca() {
		statoCorrente.cliccatoAttacca(this);
	}
	@Override
	public void cliccatoSposta() {
		statoCorrente.cliccatoSposta(this);
	}
	@Override
	public void cliccatoPassa() {
		statoCorrente.cliccatoPassa(this);
	}
	@Override
	public void cliccatoIncrementoAttacco() {
		statoCorrente.cliccatoIncrementoAttacco(this);
	}
	@Override
	public void cliccatoDecrementoAttacco() {
		statoCorrente.cliccatoDecrementoAttacco(this);
	}
	@Override
	public void cliccatoIncrementoSposta() {
		statoCorrente.cliccatoIncrementoSposta(this);
	}
	@Override
	public void cliccatoDecrementoSposta() {
		statoCorrente.cliccatoDecrementoSposta(this);
	}
	
	

	
	


}

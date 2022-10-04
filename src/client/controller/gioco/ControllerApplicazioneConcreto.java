package client.controller.gioco;

import javax.swing.JOptionPane;

import client.controller.gioco.state.State;
import client.model.ClientModel;
import client.model.Gioco;
import client.view.gioco.GiocoGUI;
import client.view.gioco.MappaGUI;
import utilità.GloboGrafico;


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
	public void chat() {
		String messaggio = giocoGUI.getMessaggioUtente();
		if(messaggio.equals("")) {
			JOptionPane.showMessageDialog(null, "Devi prima scrivere qualcosa");
			return;
		}
		String daMandare = gioco.getNomePartecipante() + ": " + messaggio;
		clientModel.inviaMessaggio(daMandare);
	}
	@Override
	public void apriCodaTelegrammi() {
		String tel=gioco.getTelegrammi();
		giocoGUI.report(tel);
	}
	@Override
	public void inviaTelegramma() {
		String telegramma="Da "+gioco.getNomePartecipante()+":\n";
		String destinatario=giocoGUI.getDestinatario();
		telegramma+=giocoGUI.getMessaggioUtente();
		clientModel.inviaTelegramma(telegramma,destinatario);
	}
	@Override
	public void verificaObbiettivo() {
		clientModel.verificaObbiettivo(gioco.getNomePartecipante());
	}
	@Override
	public void cliccatoCarte() {
		String carte=gioco.listaCarte();
		giocoGUI.report(carte);
	}
	@Override
	public void mostraTerritori() {
		String listaTerritori = gioco.getTerritori();
		giocoGUI.report(listaTerritori);
	}
	@Override
	public void setStato(State stato) {
		this.statoCorrente=stato;
		giocoGUI.report("Sei nello stato di " + stato);
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
	@Override
	public State getStatoCorrente() {
		return statoCorrente;
	}
	
	
	
	

	
	


}

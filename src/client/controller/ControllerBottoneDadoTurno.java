package client.controller;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import utilità.Musica;

public class ControllerBottoneDadoTurno extends Controller{

	@Override
	public void actionPerformed(ActionEvent e) {
		Musica.suonaDado();
		clientModel.tiraDado();
		
	}

}

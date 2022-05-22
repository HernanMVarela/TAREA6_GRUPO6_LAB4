package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controller.ControladorPrincipal;
import presentacion.vista.VentanaPrincipal;

public class Principal {
	
	public static void main(String[] args) {
		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		ControladorPrincipal controlador = new ControladorPrincipal(vista, negocio);
		controlador.inicializar();
	}

}

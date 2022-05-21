package presentacion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import entidades.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelListar;

public class ListarController  implements ActionListener{

	private PanelListar PanLi;
	private PersonaNegocio PerNeg;
	private DefaultListModel<Persona> listmodel;
	

public ListarController(PanelListar panel, PersonaNegocio negocio) {
		this.PanLe = panel;
		this.PerNeg = negocio;
		cargarLista();
		PanLe.getBtnListar().addActionListener(l -> ListarPersona(l));
	}del;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

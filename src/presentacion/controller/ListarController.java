package presentacion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelListar;

public class ListarController  implements ActionListener{

	private PanelListar PanLi;
	private PersonaNegocio PerNeg;
	private DefaultListModel<Persona> listmodel;
	

public ListarController(PanelListar panel, PersonaNegocio negocio) {
		this.PanLi = panel;
		this.PerNeg = negocio;
		//cargarLista();
		//PanLi.getBtnListar().addActionListener(l -> ListarPersona(l));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

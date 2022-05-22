package presentacion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelModificar;

public class ModificarController implements ActionListener {
	
	private PanelModificar PanMo;
	private PersonaNegocio PerNeg;
	private DefaultListModel<Persona> listmodel;
	
	public ModificarController(PanelModificar panel, PersonaNegocio negocio) {
		this.PanMo = panel;
		this.PerNeg = negocio;
		cargarLista();
		PanMo.getBtnModificar().addActionListener(m -> ModificarPersona(m));
	}

	private void ModificarPersona(ActionEvent m) {
		Persona Modificar = new Persona();
		int DNI = PanMo.getListPersonas().getSelectedValue().getDNI();
		Modificar.setNombre(PanMo.getTxfNombre().getText());
		Modificar.setApellido(PanMo.getTxfApellido().getText());
		Modificar.setDNI(Integer.parseInt(PanMo.getTxfDNI().getText()));
		
		if(PerNeg.modificarPersona(Modificar, DNI)){
			JOptionPane.showMessageDialog(null, "Persona modificada");
		}else {
			JOptionPane.showMessageDialog(null, "No se puedo modificar persona");
		}
		
	}
	
	private void cargarLista() {
		List<Persona> lista = PerNeg.listar();			// METODO PARA LISTAR TODOS - DEBE DEVOLVER LISTA DE PERSONAS
		listmodel = new DefaultListModel<Persona>();
		listmodel = PanMo.getModel();
		PanMo.getModel().clear();
		for (int x=0; x< lista.size(); x++) {
			listmodel.addElement((Persona)lista.get(x));
		}
		PanMo.setModel(listmodel);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}

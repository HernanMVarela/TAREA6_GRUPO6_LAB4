package presentacion.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

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
		PanMo.getListPersonas().addListSelectionListener(l -> SeleccionarPersona(l));
	}

	private void SeleccionarPersona(ListSelectionEvent l){
		if(!PanMo.getListPersonas().isSelectionEmpty()) {
		PanMo.getTxfNombre().setText(PanMo.getListPersonas().getSelectedValue().getNombre());
		PanMo.getTxfApellido().setText(PanMo.getListPersonas().getSelectedValue().getApellido());
		PanMo.getTxfDNI().setText(PanMo.getListPersonas().getSelectedValue().getDni());
		}else {
			PanMo.getTxfNombre().setText("");
			PanMo.getTxfApellido().setText("");
			PanMo.getTxfDNI().setText("");
		}
	}

	private void ModificarPersona(ActionEvent m) {
		if(validarTextfield()) {
			Persona Modificar = new Persona();
			String DNI = PanMo.getListPersonas().getSelectedValue().getDni();
			Modificar.setNombre(PanMo.getTxfNombre().getText());
			Modificar.setApellido(PanMo.getTxfApellido().getText());
			Modificar.setDni(PanMo.getTxfDNI().getText());
			if(PerNeg.modificarPersona(Modificar, DNI)){
				JOptionPane.showMessageDialog(null, "Persona modificada");
			}else {
				JOptionPane.showMessageDialog(null, "No se puedo modificar persona");
			}
			limpiarTextfield();
			PanMo.repaint();
			PanMo.revalidate();
		}
	}
	
	private void cargarLista() {
		List<Persona> lista = PerNeg.readAll();			// METODO PARA LISTAR TODOS - DEBE DEVOLVER LISTA DE PERSONAS
		listmodel = new DefaultListModel<Persona>();
		listmodel = PanMo.getModel();
		PanMo.getModel().clear();
		for (int x=0; x< lista.size(); x++) {
			listmodel.addElement((Persona)lista.get(x));
		}
		PanMo.setModel(listmodel);
	}
	
	private boolean validarTextfield() {
		boolean pass=true;
		if(PanMo.getTxfApellido().getText().isEmpty()) {
			PanMo.getTxfApellido().setBackground(Color.red);
			pass=false;
		}else {
			PanMo.getTxfApellido().setBackground(Color.white);
		}
		
		if(PanMo.getTxfNombre().getText().isEmpty()) {
			PanMo.getTxfNombre().setBackground(Color.red);
			pass=false;
		}else {
			PanMo.getTxfNombre().setBackground(Color.white);
		}
		
		if(PanMo.getTxfDNI().getText().isEmpty()) {
			PanMo.getTxfDNI().setBackground(Color.red);
			pass=false;
		}else {
			PanMo.getTxfDNI().setBackground(Color.white);
		}
		if(PanMo.getListPersonas().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "No se seleccionó ninguna persona");
			limpiarTextfield();
			pass=false;
		}
		return pass;
	}
	
	private void limpiarTextfield() {
		PanMo.getTxfApellido().setText("");
		PanMo.getTxfNombre().setText("");
		PanMo.getTxfDNI().setText("");
		
		cargarLista();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}

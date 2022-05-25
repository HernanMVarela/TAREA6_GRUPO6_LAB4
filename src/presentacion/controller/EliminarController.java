package presentacion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminar;

public class EliminarController implements ActionListener {

	private PanelEliminar pEliminarTMP;
	private PersonaNegocio negocioTMP;
	private DefaultListModel<Persona> listmodel;
	
	
	public EliminarController(PanelEliminar pEliminar, PersonaNegocio negocio) {
		this.pEliminarTMP = pEliminar;
		this.negocioTMP = negocio;
	
		this.pEliminarTMP.getBtnEliminar().addActionListener(e->eliminarPersona(e));
		
	}
	
	private void eliminarPersona(ActionEvent e) {
		
		if (!pEliminarTMP.getListaPersonas().isSelectionEmpty()) {
			Persona delete = pEliminarTMP.getListaPersonas().getSelectedValue();
			if (negocioTMP.eliminarPersona(delete)) {
				JOptionPane.showMessageDialog(null, "Persona ELIMINADA");
				cargarLista();
				pEliminarTMP.repaint();
				pEliminarTMP.revalidate();
			} else {
				JOptionPane.showMessageDialog(null, "ERROR - No se pudo procesar la solicitud");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "ERROR - No hay una persona seleccionada");
		}
	}
	
	private void cargarLista() {
		listmodel = pEliminarTMP.getModel();
		pEliminarTMP.getModel().clear();
		for (int x=0; x< negocioTMP.readAll().size(); x++) {
			listmodel.addElement(negocioTMP.readAll().get(x));
		}
		pEliminarTMP.setModel(listmodel);
	}
	
	public void inicializar() {
		cargarLista();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	

}

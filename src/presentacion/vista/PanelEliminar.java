package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entidad.Persona;

import javax.swing.JList;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelEliminar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<Persona> listaPersonas;
	private JButton btnEliminar;
	private DefaultListModel<Persona> model;
	private JScrollPane Scroll;
	


	public PanelEliminar() {
		setLayout(null);
		model = new DefaultListModel<Persona>();
		
		listaPersonas = new JList<Persona>();
		listaPersonas.setFont(new Font("Tahoma", Font.PLAIN, 16));
						
		Scroll = new JScrollPane();
		Scroll.setBounds(25, 25, 450, 180);
		Scroll.setViewportView(listaPersonas);
	    listaPersonas.setLayoutOrientation(JList.VERTICAL);
	    add(Scroll);
	    
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(137, 230, 208, 39);
		add(btnEliminar);

	}


	public JList<Persona> getListaPersonas() {
		return listaPersonas;
	}


	public void setListaPersonas(JList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public DefaultListModel<Persona> getModel() {
		return model;
	}


	public void setModel(DefaultListModel<Persona> model) {
		this.model = model;
		this.listaPersonas.setModel(this.model);
	}


	public JScrollPane getScroll() {
		return Scroll;
	}


	public void setScroll(JScrollPane scroll) {
		Scroll = scroll;
	}
	
	
}

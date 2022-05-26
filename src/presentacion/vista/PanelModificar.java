package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;

import entidad.Persona;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelModificar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txfNombre;
	private JTextField txfDNI;
	private JTextField txfApellido;
	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> model;
	private JScrollPane Scroll;
	private JButton btnModificar;
	private JLabel lblSeleccioneLaPersona;

	public PanelModificar() {
		setLayout(null);
		model = new DefaultListModel<Persona>();
		
		listPersonas = new JList<Persona>();
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		Scroll = new JScrollPane();
		Scroll.setBounds(25, 33, 450, 172);
		Scroll.setViewportView(listPersonas);
	    listPersonas.setLayoutOrientation(JList.VERTICAL);
	    add(Scroll);
		
		txfNombre = new JTextField();
		txfNombre.setBounds(25, 216, 125, 20);
		add(txfNombre);
		txfNombre.setColumns(10);
		
		txfDNI = new JTextField();
		txfDNI.setBackground(Color.WHITE);
		txfDNI.setEditable(false);
		txfDNI.setBounds(350, 216, 125, 20);
		add(txfDNI);
		txfDNI.setColumns(10);
		
		txfApellido = new JTextField();
		txfApellido.setColumns(10);
		txfApellido.setBounds(189, 216, 125, 20);
		add(txfApellido);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(189, 253, 125, 23);
		add(btnModificar);
		
		lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccioneLaPersona.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeleccioneLaPersona.setBounds(25, 11, 344, 20);
		add(lblSeleccioneLaPersona);

	}
	
	public JTextField getTxfNombre() {
		return txfNombre;
	}

	public void setTxfNombre(JTextField txfNombre) {
		this.txfNombre = txfNombre;
	}

	public JTextField getTxfDNI() {
		return txfDNI;
	}

	public void setTxfDNI(JTextField txfDNI) {
		this.txfDNI = txfDNI;
	}

	public JTextField getTxfApellido() {
		return txfApellido;
	}

	public void setTxfApellido(JTextField txfApellido) {
		this.txfApellido = txfApellido;
	}

	public JList<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(JList<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public DefaultListModel<Persona> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Persona> model) {
		this.model = model;
		listPersonas.setModel(this.model);
	}

	public JScrollPane getScroll() {
		return Scroll;
	}

	public void setScroll(JScrollPane scroll) {
		Scroll = scroll;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
}

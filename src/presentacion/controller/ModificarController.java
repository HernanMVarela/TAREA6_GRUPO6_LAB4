package presentacion.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
		
		PanMo.getBtnModificar().addActionListener(m -> ModificarPersona(m));
		PanMo.getListPersonas().addListSelectionListener(l -> SeleccionarPersona(l));
		PanMo.getTxfDNI().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {soloNumerosDNI(e);}
		});
		PanMo.getTxfNombre().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {soloLetras(e, PanMo.getTxfNombre().getText());}
		});
		PanMo.getTxfApellido().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)  {soloLetras(e, PanMo.getTxfApellido().getText());}
		});
	}

	private void soloNumerosDNI(KeyEvent e) {
		char c = e.getKeyChar();
		if(PanMo.getTxfDNI().getText().length()>=8 || ((c<'0') || (c>'9'))) {
			e.consume();
		}
	}
	
	private void soloLetras(KeyEvent e, String s) {
		char c = e.getKeyChar();
		if(s.length()>=25 || !Character.isAlphabetic(c)) {
			e.consume();
		}
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
			inicializar();
			PanMo.repaint();
			PanMo.revalidate();
		}
	}
	
	private void cargarLista() {
		listmodel = PanMo.getModel();
		PanMo.getModel().clear();
		List<Persona> list = PerNeg.ordenarLista(PerNeg.readAll());
		
		for (int x=0; x< list.size(); x++) {
			listmodel.addElement(list.get(x));
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
			inicializar();
			pass=false;
		}
		return pass;
	}
	
	public void inicializar() {
		PanMo.getTxfApellido().setText("");
		PanMo.getTxfNombre().setText("");
		PanMo.getTxfDNI().setText("");
		
		cargarLista();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {}

}

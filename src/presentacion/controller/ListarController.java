package presentacion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelListar;

public class ListarController  implements ActionListener{

	private PanelListar PanLi;
	private PersonaNegocio PerNeg;	

public ListarController(PanelListar panel, PersonaNegocio negocio) {
		this.PanLi = panel;
		this.PerNeg = negocio;
		List<Persona> lista = PerNeg.readAll();
		
		for (int x=0; x< lista.size(); x++) {
			this.PanLi.getModelPersonas().addRow(new Object[] {lista.get(x).getNombre(),lista.get(x).getApellido(), lista.get(x).getDni()});
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package presentacion.vista;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class PanelListar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido", "Dni"};
	private JTable tablaPersona;
	private JScrollPane scrollPane;

	public PanelListar() {
		setLayout(null);

		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersona = new JTable(modelPersonas);
		
		tablaPersona.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablaPersona.getColumnModel().getColumn(0).setResizable(false);
		tablaPersona.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersona.getColumnModel().getColumn(1).setResizable(false);
		tablaPersona.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersona.getColumnModel().getColumn(2).setResizable(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 25, 438, 200);
		scrollPane.setViewportView(tablaPersona);
		add(scrollPane);
	}
	
	public void llenarTabla(List<Persona> personasEnTabla) {
			this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.getModelPersonas().setColumnCount(0);
			this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());
			for (Persona p  : personasEnTabla)
			{
				String nombre = p.getNombre();
				String apellido = p.getApellido();
				String dni = p.getDni();
				Object[] fila = {nombre, apellido, dni};
				this.getModelPersonas().addRow(fila);
			}

		}

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public void setModelPersonas(DefaultTableModel modelPersonas) {
		this.modelPersonas = modelPersonas;
	}

	public JTable getTablaPersona() {
		return tablaPersona;
	}

	public void setTablaPersona(JTable tablaPersona) {
		this.tablaPersona = tablaPersona;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}
	
}

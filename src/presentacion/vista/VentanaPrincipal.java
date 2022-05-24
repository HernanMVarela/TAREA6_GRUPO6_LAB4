package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar; 
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersonas = new JMenu("Persona");
		menuBar.add(mnPersonas);
		
		mntmAgregar = new JMenuItem("Agregar");
		mnPersonas.add(mntmAgregar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnPersonas.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mnPersonas.add(mntmEliminar);
		
		mntmListar = new JMenuItem("Listar");
		mnPersonas.add(mntmListar);
	}

	public JMenu getMnPersonas() {
		return mnPersonas;
	}

	public void setMnPersonas(JMenu mnPersonas) {
		this.mnPersonas = mnPersonas;
	}

	public JMenuItem getMenuAgregar() {
		return mntmAgregar;
	}

	public void setMenuAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}
	
	public JMenuItem getMenuModificar() {
		return mntmModificar;
	}

	public void setMenuModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMenuEliminar() {
		return mntmEliminar;
	}

	public void setMenuEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}

	public JMenuItem getMenuListar() {
		return mntmListar;
	}

	public void setMenuListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}

}

package presentacion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminar;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;

public class ControladorPrincipal implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregar panelAgregar;
	private PanelEliminar panelEliminar;
	private PersonaNegocio personaNegocio;
	private PanelListar panelListar;
	private PanelModificar panelModificar;
	
	//Constructor
	public ControladorPrincipal(VentanaPrincipal vista, PersonaNegocio personaNegocio)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.personaNegocio = personaNegocio;
		
		//Instancio los paneles
		this.panelAgregar = new PanelAgregar();
		this.panelModificar = new PanelModificar();
		this.panelEliminar = new PanelEliminar();
		this.panelListar = new PanelListar();
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_Agregar(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_Modificar(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_Eliminar(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_Listar(a));
		 
		}
	
	//EventoClickMenu abrir PanelAgregar
	public void  EventoClickMenu_AbrirPanel_Agregar(ActionEvent a)
	{	
		panelAgregar = new PanelAgregar();
		//AgregarController si se usa
		AgregarController agregarController = new AgregarController(panelAgregar,personaNegocio);
		this.ventanaPrincipal.setContentPane(panelAgregar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelModificar
	public void  EventoClickMenu_AbrirPanel_Modificar(ActionEvent a)
	{		
		panelModificar = new PanelModificar();
		ModificarController PenModCont = new ModificarController(panelModificar,personaNegocio);
		PenModCont.inicializar();
		this.ventanaPrincipal.setContentPane(panelModificar);
		this.ventanaPrincipal.repaint();
		this.ventanaPrincipal.revalidate();
	}
	
	//EventoClickMenu abrir PanelEliminar
	public void EventoClickMenu_AbrirPanel_Eliminar(ActionEvent a)
	{		
		panelEliminar = new PanelEliminar();
		EliminarController PenEliCont = new EliminarController(panelEliminar,personaNegocio);
		PenEliCont.inicializar();
		this.ventanaPrincipal.setContentPane(panelEliminar);
		this.ventanaPrincipal.repaint();
		this.ventanaPrincipal.revalidate();
	}
	
	//EventoClickMenu abrir PanelListar
	public void EventoClickMenu_AbrirPanel_Listar(ActionEvent a)
	{		
		panelListar = new PanelListar();
		ListarController PenLisCont = new ListarController(panelListar,personaNegocio);
		PenLisCont.inicializar();
		this.ventanaPrincipal.setContentPane(panelListar);
		this.ventanaPrincipal.repaint();
		this.ventanaPrincipal.revalidate();
	}

	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
}


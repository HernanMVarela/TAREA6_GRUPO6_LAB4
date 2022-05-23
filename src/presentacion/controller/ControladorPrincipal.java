package presentacion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
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
	private ArrayList<Persona> personasEnTabla;
	
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
		
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_Agregar(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_Modificar(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_Eliminar(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_Listar(a));

		//Eventos PanelAgregar
//		 this.panelAgregar.getBtnAgregar().addActionListener(a->EventoClickBoton_Agregar_PanelAgregar(a));
//		 this.panelAgregar.getBtnEliminar().addActionListener(s->EventoClickBoton_Eliminar_PanelAgregar(s));
		 
		 //Eventos PanelModificar
//		 this.panelModificar.getBtnModificar().addActionListener(a->EventoClickBoton_Modificar_PanelModificar(a));
//		 this.panelModificar.getBtnEliminar().addActionListener(s->EventoClickBoton_Eliminar_PanelModificar(s));
			
		//Eventos PanelEliminar
//		 this.panelEliminar.getBtnEliminar().addActionListener(s->EventoClickBoton_Eliminar_PanelEliminar(s));
		 
		}
	
	//EventoClickMenu abrir PanelAgregar
	public void  EventoClickMenu_AbrirPanel_Agregar(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelAgregar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelModificar
	public void  EventoClickMenu_AbrirPanel_Modificar(ActionEvent a)
	{		
		panelModificar = new PanelModificar();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		ModificarController PenModCont = new ModificarController(panelModificar,negocio);
		this.ventanaPrincipal.setContentPane(panelModificar);
		this.ventanaPrincipal.repaint();
		this.ventanaPrincipal.revalidate();
	}
	
	//EventoClickMenu abrir PanelEliminar
	public void EventoClickMenu_AbrirPanel_Eliminar(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelEliminar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelListar
		public void EventoClickMenu_AbrirPanel_Listar(ActionEvent a)
		{		
			ventanaPrincipal.getContentPane().removeAll();
			ventanaPrincipal.getContentPane().add(panelListar);
			ventanaPrincipal.getContentPane().repaint();
			ventanaPrincipal.getContentPane().revalidate();
		}

	//EventoClickBoton agregar persona en PanelAgregar
//	private void EventoClickBoton_Agregar_PanelAgregar(ActionEvent a) {
//		
//		String nombre = this.panelAgregar.getTxtNombreApe().getText();
//		String tel = this.panelAgregar.getTxtTelefono().getText();
//		Persona nuevaPersona = new Persona(0, nombre, tel);
//		
//		boolean estado = personaNegocio.insert(nuevaPersona);
//		String mensaje;
//		if(estado==true)
//		{
//			mensaje="Persona agregada con exito";
//			this.panelAgregar.getTxtNombreApe().setText("");
//			this.panelAgregar.getTxtTelefono().setText("");
//		}
//		else
//			mensaje="Persona no agregada, complete todos los campos";
//		
//		this.panelAgregar.mostrarMensaje(mensaje);
//		this.refrescarTabla();
//	
//	}

	//EventoClickBoton borrar persona en PanelAgregar
//	public void EventoClickBoton_BorrarPersona_PanelAgregar(ActionEvent s)
//	{
//		boolean estado=false;
//		int[] filasSeleccionadas = this.panelAgregar.getTablaPersonas().getSelectedRows();
//		for (int fila : filasSeleccionadas)
//		{
//			estado = personaNegocio.delete(this.personasEnTabla.get(fila));
//			if(estado==true)
//			{
//				String mensaje="Persona eliminada con exito";
//				this.panelAgregar.mostrarMensaje(mensaje);
//			}
//		}
//		this.refrescarTabla();
//	}
	
	//EventoClickBoton borrar persona en PanelEliminar
//	public void EventoClickBoton_Eliminar_PanelEliminar(ActionEvent s)
//		{
//			String id_eliminar = this.panelEliminar.getTxtIdEliminar().getText();
//			Persona persona = new Persona();
//			persona.setIdPersona(Integer.parseInt(id_eliminar));
//			
//			boolean estado=false;
//			String mensaje;
//			estado = personaNegocio.delete(persona);
//			if(estado==true)
//			{
//				mensaje="Persona eliminada con exito";	
//			}
//			else
//			{
//				 mensaje="Id inexistente";
//			}
//			this.panelEliminar.getTxtIdEliminar().setText("");
//			this.panelEliminar.mostrarMensaje(mensaje);
//			
//		}
		
	private void refrescarTabla()
	{
//		this.personasEnTabla = (ArrayList<Persona>) personaNegocio.readAll();
//		this.panelAgregar.llenarTabla(this.personasEnTabla);
	}

	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


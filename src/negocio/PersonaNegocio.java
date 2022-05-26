package negocio;

import java.util.List;
import entidad.Persona;

public interface PersonaNegocio {

	public boolean modificarPersona(Persona Modificar);
	public List<Persona> readAll();
	public boolean eliminarPersona(Persona Eliminar);
	public boolean agregarPersona (Persona Agregar);
	public boolean getPersonaPorDni(Persona persona);
	public List<Persona> ordenarLista(List<Persona> list);
}

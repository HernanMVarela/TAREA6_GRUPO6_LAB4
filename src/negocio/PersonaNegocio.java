package negocio;

import java.util.List;
import entidad.Persona;

public interface PersonaNegocio {

	public boolean modificarPersona(Persona Modificar, String dNI);
	public List<Persona> readAll();
	public boolean eliminarPersona(Persona Eliminar);
	public boolean agregarPersona (Persona Agregar);
	public String getPersonaPorDni(String dni);
	
}

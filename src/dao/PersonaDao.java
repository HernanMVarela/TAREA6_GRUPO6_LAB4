package dao;

import java.util.List;
import entidad.Persona;

public interface PersonaDao {
	public boolean modificarPersona(Persona Modificar);
	public boolean eliminarPersona(Persona Eliminar);
	public List<Persona> readAll();
	public boolean agregarPersona (Persona Agregar);
}

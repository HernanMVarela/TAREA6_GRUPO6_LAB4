package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	public boolean modificarPersona(Persona Modificar, String dni);
	public List<Persona> readAll();
}

package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	public boolean modificarPersona(Persona Modificar, String dni) {
		PersonaDao modificar = new PersonaDaoImpl();
		return modificar.modificarPersona(Modificar, dni);
	}

	@Override
	public List<Persona> readAll() {
		PersonaDao perdao = new PersonaDaoImpl();
		return perdao.readAll();
	}

	@Override
	public boolean eliminarPersona(Persona Eliminar) {
		PersonaDao eliminar = new PersonaDaoImpl();
		if (eliminar.readAll().contains(Eliminar)) {		
				return eliminar.eliminarPersona(Eliminar);
		} else
		{ return false; }
	}

	@Override
	public boolean agregarPersona(Persona Agregar) {
		PersonaDao agregar = new PersonaDaoImpl();
		return agregar.agregarPersona(Agregar);
	}

	@Override
	public String getPersonaPorDni(String dni) {
		String dniExistente = new PersonaDaoImpl().getPersonaPorDni(dni);
		return dniExistente;
	}
}

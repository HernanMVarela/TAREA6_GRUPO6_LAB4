package negocioImpl;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	public boolean modificarPersona(Persona Modificar, int dni) {
		PersonaDao modificar = new PersonaDaoImpl();
		return modificar.modificarPersona(Modificar, dni);
	}
}

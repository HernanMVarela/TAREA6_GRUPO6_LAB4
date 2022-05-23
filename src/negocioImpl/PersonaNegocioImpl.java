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
}

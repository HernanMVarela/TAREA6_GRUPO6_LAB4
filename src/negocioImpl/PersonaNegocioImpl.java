package negocioImpl;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

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
	public boolean getPersonaPorDni(Persona persona) {
		PersonaDao dao = new PersonaDaoImpl();
		if(dao.readAll().contains(persona)) {
			return true;
		}
		return false;
		
	}
	
	@Override
	public List<Persona> ordenarLista(List<Persona> list) {
		TreeSet<Persona> lista = new TreeSet<Persona>();
		if (list.isEmpty()) return list;
		try {
			for (int x=0; x<list.size(); x++)
				lista.add(list.get(x));
			Iterator<Persona> ite = lista.iterator();
			list.clear();
			while (ite.hasNext())
				list.add(ite.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

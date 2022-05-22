package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao  {

	@Override
	public boolean modificarPersona(Persona Modificar, int dni) {
		
		return false;
	}
	
	public List<Persona> listarPersonas() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		
		try {
			st = conexion.prepareStatement("SELECT * FROM personas");
			rs = st.executeQuery();
			while(rs.next()) {
				Persona p = new Persona();
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				p.setDni(rs.getString("Dni"));
				personas.add(p);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return personas;
	}
	
	public ArrayList<Persona> readAll() {
		ArrayList<Persona> lpersonas = new ArrayList<Persona>();
		String query= "select * from personas";
		Connection conexion = Conexion.getConexion().getSQLConexion();
			
		Statement st;
		try {
			st =  (Statement) conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Persona x = new Persona();
				x.setDni(rs.getString("Dni"));
				x.setNombre(rs.getString("Nombre"));
				x.setApellido(rs.getString("Apellido"));
				lpersonas.add(x);
				
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	return lpersonas;
		
		
	}
}

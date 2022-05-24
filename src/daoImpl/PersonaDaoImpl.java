package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao  {
	
	private String modifi = "UPDATE personas SET Dni = ?, Nombre = ?, Apellido = ? WHERE Dni LIKE ?;";
	private String readall = "SELECT * FROM personas";
	private String delete = "DELETE FROM personas WHERE DNI = ?";

	@Override
	public boolean modificarPersona(Persona Modificar, String dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modificarOk = false;
		try {
			statement = conexion.prepareStatement(modifi);
			statement.setString(1, Modificar.getDni());
			statement.setString(2, Modificar.getNombre());
			statement.setString(3, Modificar.getApellido());
			statement.setString(4, dni);
			
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				modificarOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return modificarOk;
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
	
	public List<Persona> readAll() {
		List<Persona> lpersonas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		PreparedStatement st;
		ResultSet rs;
		try {
			st = conexion.getSQLConexion().prepareStatement(readall);
			rs = st.executeQuery();
			while(rs.next()) {
				lpersonas.add(getPersona(rs));
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	return lpersonas;
			
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, nombre, apellido);
	}

	@Override
	public boolean eliminarPersona(Persona Eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean eliminarOK = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Eliminar.getDni());
			
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				eliminarOK = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return eliminarOK;
	}
}

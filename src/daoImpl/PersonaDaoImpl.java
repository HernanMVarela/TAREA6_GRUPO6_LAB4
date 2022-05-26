package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao  {
	
	private String add = "INSERT INTO personas (Dni, Nombre, Apellido) VALUES (?,?,?)";
	private String modifi = "UPDATE personas SET Nombre = ?, Apellido = ? WHERE Dni LIKE ?;";
	private String readall = "SELECT * FROM personas";
	private String delete = "DELETE FROM personas WHERE DNI = ?";
	private String getPersonaPorDni = "SELECT Dni FROM personas WHERE Dni = ?";

	@Override
	public boolean modificarPersona(Persona Modificar, String dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modificarOk = false;
		try {
			statement = conexion.prepareStatement(modifi);
			statement.setString(1, Modificar.getNombre());
			statement.setString(2, Modificar.getApellido());
			statement.setString(3, dni);
			
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
	
	public String getPersonaPorDni(String dni) {
		String dniExistente = null;
		Conexion conn = Conexion.getConexion();
		PreparedStatement st;
		ResultSet rs;
		try {
			st = conn.getSQLConexion().prepareStatement(getPersonaPorDni);
			st.setString(1, dni);
			rs = st.executeQuery();
			while(rs.next()) {
				dniExistente=rs.getString("Dni");
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return dniExistente;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, apellido, nombre);
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
	
	@Override 
	public boolean agregarPersona(Persona Agregar) {
		PreparedStatement statement;
		Connection con = Conexion.getConexion().getSQLConexion();
		boolean agregar = false;
		try {
			statement = con.prepareStatement(add);
			statement.setString(1, Agregar.getDni());
			statement.setString(2, Agregar.getNombre());
			statement.setString(3, Agregar.getApellido());
			
			if(statement.executeUpdate() > 0) {
				con.commit();
				agregar = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return agregar;
		
	}
}

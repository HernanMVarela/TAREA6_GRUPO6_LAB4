package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
		public static Conexion instancia;
	    private String host = "jdbc:mysql://localhost:3306/"; //Tube que cambiarlo porque no podia instalar el XAMPP
	    private String user = "root";
	    private String pass = "root"; // "joaquin";
	    private String dbName = "bdPersonas"; /////Extencion de la profe bdPersonas?useUnicode=yes&characterEncoding=UTF-8&useSSL=false
	    private Connection conexion;

	    private Conexion() {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
	            this.conexion = DriverManager.getConnection(host+dbName,user,pass);
	           // this.conexion.setAutoCommit(false);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

	    public static Conexion getConexion()
	    {
	        if(instancia == null)
	        {
	            instancia = new Conexion();
	        }
	        return instancia;
	    }

	    public Connection getSQLConexion() 
	    {
	        return this.conexion;
	    }

	    public void cerrarConexion()
	    {
	        try 
	        {
	            this.conexion.close();
	        }
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        instancia = null;
	    }
}

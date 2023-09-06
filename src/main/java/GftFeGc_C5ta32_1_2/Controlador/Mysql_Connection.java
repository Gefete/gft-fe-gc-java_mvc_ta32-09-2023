package GftFeGc_C5ta32_1_2.Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import GftFeGc_C5ta32_1_2.Modelo.Cliente;

public class Mysql_Connection {
	String dB="TA32";
	String jdbcUrl = "jdbc:mysql://localhost:3307/"+dB;
	String usuario = "root";
	String contraseña = "root";
	Connection conexion;
	
	//Connexion
	public Mysql_Connection() {
		try 
		{
		    this.conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
		    System.out.println("Conexión exitosa a la base de datos.");
	
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Error al conectar a la base de datos.");
		}
	}
	
	//Cerrar Connexion
	public void closeConnection() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, conexion);
		}catch(SQLException ex){
			Logger.getLogger(Mysql_Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void createDB(String name) {
		try {
			String Query = "CREATE DATABASE "+name;
			Statement st =  conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Database creada");
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error creando Base de Datos.");
			System.out.println();
			//Logger.getLogger(Mysql_Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void createTable(String db, String name, String queryData) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			//Creacion de tabla
			String Query = "Create table "+name+" ("
					+queryData
					+" );";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Tabla creada con exito!");
		}catch(SQLException ex) {
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
			System.out.println();
		}
	}
	
	
	//Metodo general para insertar registros
	/*public void insertData(String db, String table_name, String valuesName, String values) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String Query = "INSERT INTO "+table_name+" ("+valuesName+") Value ("
			+values+")";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Insertados con exito!");
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error en el almacenamiento");
			System.out.println();
		}
	}*/
	
	//Metodo general para obtener registros de la tabla
	/*public void getValues(String db, String table_name, String[] selectValues) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String Query = "Select * from "+table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				for (int i = 0; i < selectValues.length; i++) {
					System.out.println(""+selectValues[i]+": "
							+resultSet.getString(selectValues[i]));
				}
				System.out.println("-----------");
				
			}
			
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error al leer almacenamiento");
			System.out.println();
		}
	}*/
	
	//Borrar cliente
	public void deleteRecord(String db, String table_name, String ID) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String Query = "Delete from "+table_name+" Where ID=\""+ID+"\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error borrando registro");
			System.out.println();
		}
	}
	
	//Crea cliente
	public void crearCliente(String db, String table_name, Cliente cliente) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String fechaFormateada = new SimpleDateFormat("dd-MM-yyyy").format(cliente.getFecha());
			
			String Query = "INSERT INTO "+table_name+" (nombre, apellido, direccion, dni) Value ('"
					+cliente.getNombre()+"', '"
					+cliente.getApellido()+"', '"
					+cliente.getDireccion()+"', "
					+String.valueOf(cliente.getDni())+" );";
					//+fechaFormateada+"
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Insertados con exito!");
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error en el almacenamiento");
			System.out.println();
		}
	}
	
	//Lee los registros de clientes
	public List<Cliente> getValuesClientes(String db, String table_name, String[] selectValues) {
		List<Cliente> clientes = new ArrayList<>();
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String Query = "Select * from "+table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			
			while (resultSet.next()) {
	            Cliente cliente = new Cliente();

	            for (String columnName : selectValues) {
	                // Obtener el valor de la columna y establecerlo en el objeto Cliente
	                String columnValue = resultSet.getString(columnName);
	                if (columnName.equalsIgnoreCase("nombre")) {
	                    cliente.setNombre(columnValue);
	                } else if (columnName.equalsIgnoreCase("id")) {
	                    cliente.setId(Integer.valueOf(columnValue));
	                } else if (columnName.equalsIgnoreCase("apellido")) {
	                    cliente.setApellido(columnValue);
	                } else if (columnName.equalsIgnoreCase("direccion")) {
	                    cliente.setDireccion(columnValue);
	                } else if (columnName.equalsIgnoreCase("dni")) {
	                    cliente.setDni(Integer.parseInt(columnValue));
	                }
	            }

	            // Agregar el objeto Cliente a la lista
	            clientes.add(cliente);
	        }
			return clientes;
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error al leer almacenamiento");
			System.out.println();
			return null;
		}
		
	}
}

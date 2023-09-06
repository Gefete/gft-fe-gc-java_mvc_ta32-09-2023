package GftFeGc_C5ta32_1_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import GftFeGc_C5ta32_1_2.Controlador.ClienteController;
import GftFeGc_C5ta32_1_2.Controlador.Mysql_Connection;
import GftFeGc_C5ta32_1_2.Modelo.Cliente;
import GftFeGc_C5ta32_1_2.Vista.ClienteView;

public class GftFeGc_C5ta32_1_2 {

	public static void main(String[] args) throws ParseException {
		Mysql_Connection connexion= new Mysql_Connection();
		
		//No funciona correctamente tiene que estar creado en la base de datos (pendiente de revision)
		//connexion.createDB("TA_32");
		//en algunos controller tambien se ponen a mano la base de datos por lo que se requiere ir a ellos y cambiarlos
		//Ahora mismo el programa gira en torno a que la base de datos se llame "TA32"
		
		
		connexion.createTable("TA32", "Clientes", 
					"id int AUTO_INCREMENT,"
					+ "Nombre nvarchar(250),"
					+ "Apellido nvarchar(250),"
					+ "Direccion nvarchar(250),"
					+ "Dni int DEFAULT NULL,"
					+ "Fecha date DEFAULT NULL,"
					+ "Primary key(id)"
				);
		

		// Define el formato de fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        //Inserta valores en la base de datos
        connexion.crearCliente("TA32", "Clientes", new Cliente("Gerard", "Fernandez", "sant Benilde", 354125,  (Date) formato.parse("25/10/2023")));
        connexion.crearCliente("TA32", "Clientes", new Cliente("Jose", "Gonzalez", "sant Benilde", 124566,  (Date) formato.parse("25/10/2023")));
        connexion.crearCliente("TA32", "Clientes", new Cliente("Joel", "Tarzan", "sant Benilde", 234677,  (Date) formato.parse("25/10/2023")));
        connexion.crearCliente("TA32", "Clientes", new Cliente("Marco", "Santoro", "sant Benilde", 2342216,  (Date) formato.parse("25/10/2023")));
        connexion.crearCliente("TA32", "Clientes", new Cliente("Nuria", "Fernandez", "sant Benilde", 2135512,  (Date) formato.parse("25/10/2023")));
		
		
		
		Cliente cliente=new Cliente();
		ClienteView clienteView=new ClienteView();
		String[] valuesArticulos= {"Id", "Nombre", "Apellido", "Direccion", "Dni", "Fecha"};
		List<Cliente> lista = connexion.getValuesClientes("TA32", "Clientes", valuesArticulos);
		ClienteController clienteController=new ClienteController(cliente, clienteView, lista);
		clienteController.iniciarVista();

	}

}

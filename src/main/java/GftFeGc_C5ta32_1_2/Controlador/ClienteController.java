package GftFeGc_C5ta32_1_2.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import GftFeGc_C5ta32_1_2.Modelo.Cliente;
import GftFeGc_C5ta32_1_2.Vista.ClienteView;

public class ClienteController implements ActionListener{

	private Cliente cliente;
	private ClienteView clienteView;
	
	
	
	public ClienteController() {
	}

	public ClienteController(Cliente cliente, ClienteView clienteView, List<Cliente> clientes) {
		this.cliente = cliente;
		this.clienteView = clienteView;
		this.clienteView.btnCREAR.addActionListener(this);
		this.clienteView.btnMODIFICAR.addActionListener(this);
		this.clienteView.btnBORRAR.addActionListener(this);
		this.clienteView.setTextArea(clientes);
	}

	public void iniciarVista() {
		clienteView.setTitle("Cliente");
		clienteView.pack();
		clienteView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clienteView.setBounds(100, 100, 679, 473);
		clienteView.setLocationRelativeTo(null);
		clienteView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Crear usuarios
		if(clienteView.btnCREAR==e.getSource()) {
			if(!"".equals(clienteView.txtDni.getText())) {
				//Para añadir formato a la fecha
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
				try {
					//Coge la fecha de la vista y la transforma a Date
					Date fecha = formato.parse(clienteView.txtFecha.getText());
					
					//Crea el Cliente para añadirlo en la lista (necesita todos los atributos si no no lo añade)
					cliente=new Cliente(
								clienteView.txtNombre.getText(),
								clienteView.txtApellido.getText(),
								clienteView.txtDireccion.getText(),
								Integer.valueOf(clienteView.txtDni.getText()),
								fecha
							);
					//Crea una conexion con la base de datos por medio del controller Mysql
					Mysql_Connection crearCliente=new Mysql_Connection();
					
					//Crea el cliente
					crearCliente.crearCliente("TA32", "Clientes", cliente);
					
					//Se le asignan los valores de la tabla
					String[] valuesArticulos= {"Id", "Nombre", "Apellido", "Direccion", "Dni", "Fecha"};
					
					//genera la lista con los clientes que hay en la base de datos
					List<Cliente> lista = crearCliente.getValuesClientes("TA32", "Clientes", valuesArticulos);
					
					//Luego pasamos la lista a la vista para que actualice visualmente la lista 
					this.clienteView.setTextArea(lista);
					
					//Por ultimo cerramos la connexion
					crearCliente.closeConnection();
				} catch (Exception e2) {
					System.out.println("error en la creación cliente prueba en la fecha introducir el siguiente formato (\"dd/MM/yyyy\")");
				}
			}
		//Borrar por medio de ID
		}else if(clienteView.btnBORRAR==e.getSource()) {
			if(!"".equals(clienteView.getTextid().getText())) {
				try {
					//Crea una conexion con la base de datos por medio del controller Mysql
					Mysql_Connection borrarCliente=new Mysql_Connection();
					
					//Recoge la id de la vista
					String id = clienteView.getTextid().getText();
					
					//Metodo del controller Mysql que borra datos de la tabla
					borrarCliente.deleteRecord("TA32", "Clientes", id);
					
					//Se le asignan los valores de la tabla
					String[] valuesArticulos= {"Id", "Nombre", "Apellido", "Direccion", "Dni", "Fecha"};
					
					//genera la lista con los clientes que hay en la base de datos
					List<Cliente> lista = borrarCliente.getValuesClientes("TA32", "Clientes", valuesArticulos);
					
					//Luego pasamos la lista a la vista para que actualice visualmente la lista 
					this.clienteView.setTextArea(lista);
					
					//Por ultimo cerramos la connexion
					borrarCliente.closeConnection();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
	}

}

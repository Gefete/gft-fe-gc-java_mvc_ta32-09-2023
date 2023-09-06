package GftFeGc_C5ta32_1_2.Vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GftFeGc_C5ta32_1_2.Modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class ClienteView extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombre, txtApellido, txtDireccion,
	txtDni,txtFecha;
	public JButton btnCREAR,btnMODIFICAR,btnBORRAR;
	private JTextArea textArea;
	private JTextField textid;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	/**
	 * Create the frame.
	 */
	public ClienteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(20, 42, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(20, 67, 55, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion:");
		lblNewLabel_3.setBounds(20, 92, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setBounds(20, 117, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha :");
		lblNewLabel_5.setBounds(20, 138, 55, 20);
		contentPane.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 38, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(90, 63, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(90, 88, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(90, 113, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(90, 138, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		btnCREAR = new JButton("Crear");
		
		btnCREAR.setBounds(204, 38, 75, 23);
		contentPane.add(btnCREAR);
		
		JLabel lblNewLabel_6 = new JLabel("Clientes");
		lblNewLabel_6.setBounds(390, 11, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		btnMODIFICAR = new JButton("Modificar");
		btnMODIFICAR.setEnabled(false);
		btnMODIFICAR.setBounds(204, 83, 75, 23);
		//contentPane.add(btnMODIFICAR);
		
		btnBORRAR = new JButton("Borrar");
		btnBORRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBORRAR.setBounds(204, 232, 75, 23);
		contentPane.add(btnBORRAR);
		
		textArea = new JTextArea();
		textArea.setBounds(384, 37, 269, 386);
		contentPane.add(textArea);
		
		textid = new JTextField();
		textid.setBounds(90, 233, 86, 20);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Id:");
		lblNewLabel_7.setBounds(20, 236, 65, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\"dd/MM/yyyy\"");
		lblNewLabel_8.setBounds(90, 167, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Borrar:");
		lblNewLabel_9.setBounds(10, 211, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Modelo: Create Read Delete");
		lblNewLabel_10.setBounds(10, 409, 176, 14);
		contentPane.add(lblNewLabel_10);
		
		
		}

		
	
	public JTextField getTextid() {
		return textid;
	}



	public void setTextid(JTextField textid) {
		this.textid = textid;
	}



	public void setTextArea(List<Cliente> clientes) {
		String txtCliente="";
		textArea.setText("");
		for (int i = 0; i < clientes.size(); i++) {
			txtCliente=clientes.get(i).getId()+" "
					+clientes.get(i).getNombre()+" "
					+clientes.get(i).getApellido()+" "
					+clientes.get(i).getDireccion()+" "
					+clientes.get(i).getDni()+" "
					+clientes.get(i).getFecha()+" ";
			textArea.setText(textArea.getText()+"\n"+txtCliente);
			
		}
	}
}

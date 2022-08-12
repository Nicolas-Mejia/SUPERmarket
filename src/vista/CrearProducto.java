package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorProductos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigoProducto;
	private JTextField descripcionProducto;
	private JTextField precioProducto;
	private JTextField stockProducto;
	private JTextField stockMinimoProducto;



	/**
	 * Create the frame.
	 */
	public CrearProducto() {
		setTitle("Crear Producto");
		setBounds(100, 100, 350, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(24, 26, 56, 20);
		contentPane.add(lblNewLabel);
		
		codigoProducto = new JTextField();
		codigoProducto.setBounds(238, 26, 86, 20);
		contentPane.add(codigoProducto);
		codigoProducto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(24, 91, 87, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(24, 156, 49, 20);
		contentPane.add(lblNewLabel_2);
		
			JLabel lblNewLabel_4 = new JLabel("Stock M\u00EDnimo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(24, 221, 101, 20);
		contentPane.add(lblNewLabel_4);
		
		descripcionProducto = new JTextField();
		descripcionProducto.setBounds(238, 91, 86, 20);
		contentPane.add(descripcionProducto);
		descripcionProducto.setColumns(10);
		
		precioProducto = new JTextField();
		precioProducto.setBounds(238, 156, 86, 20);
		contentPane.add(precioProducto);
		precioProducto.setColumns(10);
		
		stockMinimoProducto = new JTextField();
		stockMinimoProducto.setBounds(238, 221, 86, 20);
		contentPane.add(stockMinimoProducto);
		stockMinimoProducto.setColumns(10);
		
		JButton btnNewButton = new JButton("Crear Producto");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (codigoProducto.getText().isEmpty() || descripcionProducto.getText().isEmpty() || precioProducto.getText().isEmpty() || stockMinimoProducto.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);

					}
					int codigo = Integer.parseInt(codigoProducto.getText());
					String desc = descripcionProducto.getText();
					float precio = Float.parseFloat(precioProducto.getText());
					int stockMin = Integer.parseInt(stockMinimoProducto.getText());
					
					
					boolean respuesta = AdministradorProductos.getAdministradorProductos().crearProducto(codigo, desc, precio, stockMin);
					if (respuesta) {
						JOptionPane.showMessageDialog(null, "El producto se ha creado exitosamente.", "Producto creado", JOptionPane.INFORMATION_MESSAGE);
						codigoProducto.setText("");
						descripcionProducto.setText("");
						precioProducto.setText("");
						stockMinimoProducto.setText("");
						}
					else {
						JOptionPane.showMessageDialog(null, "El producto ya existe en el sistema. Si fue dado de baja, utilice el modificar para activarlo nuevamente.", "Producto duplicado", JOptionPane.ERROR_MESSAGE);
						}
					
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres en los campos código, precio, stock ni stock mínimo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(85, 266, 166, 29);
		contentPane.add(btnNewButton);
	}
}

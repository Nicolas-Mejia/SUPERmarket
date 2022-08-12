package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorProductos;
import Kiosco.ProductoView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigoProducto;
	private JTextField descripcionProducto;
	private JTextField precioProducto;
	private JTextField stockProducto;
	private JTextField stockMinimoProducto;



	/**
	 * Create the frame.
	 */
	public ModificarProducto() {
		setTitle("Modificar Producto");
		setBounds(100, 100, 350, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 26, 56, 20);
		contentPane.add(lblNewLabel);
		
		codigoProducto = new JTextField();
		codigoProducto.setBounds(152, 26, 86, 20);
		contentPane.add(codigoProducto);
		codigoProducto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 72, 87, 20);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(25, 118, 49, 20);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Stock:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(25, 164, 44, 20);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("Stock M\u00EDnimo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(25, 210, 101, 20);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		descripcionProducto = new JTextField();
		descripcionProducto.setBounds(152, 72, 86, 20);
		contentPane.add(descripcionProducto);
		descripcionProducto.setColumns(10);
		descripcionProducto.setVisible(false);
		
		precioProducto = new JTextField();
		precioProducto.setBounds(152, 118, 86, 20);
		contentPane.add(precioProducto);
		precioProducto.setColumns(10);
		precioProducto.setVisible(false);
		
		stockProducto = new JTextField();
		stockProducto.setBounds(152, 164, 86, 20);
		contentPane.add(stockProducto);
		stockProducto.setColumns(10);
		stockProducto.setVisible(false);
		
		stockMinimoProducto = new JTextField();
		stockMinimoProducto.setBounds(152, 210, 86, 20);
		contentPane.add(stockMinimoProducto);
		stockMinimoProducto.setColumns(10);
		stockMinimoProducto.setVisible(false);
		
		JButton btnNewButton = new JButton("Modificar Producto");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (codigoProducto.getText().isEmpty() || descripcionProducto.getText().isEmpty() || precioProducto.getText().isEmpty() || stockProducto.getText().isEmpty() || stockMinimoProducto.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					int codigo = Integer.parseInt(codigoProducto.getText());
					String desc = descripcionProducto.getText();
					float precio = Float.parseFloat(precioProducto.getText());
					int stock = Integer.parseInt(stockProducto.getText());
					int stockMin = Integer.parseInt(stockMinimoProducto.getText());
					
					
					boolean respuesta = AdministradorProductos.getAdministradorProductos().modificarProducto(codigo, desc, precio, stock, stockMin);
					if (respuesta) 
					{
						JOptionPane.showMessageDialog(null, "El producto se ha modificado exitosamente.", "Producto modificado", JOptionPane.INFORMATION_MESSAGE);
						codigoProducto.setText("");
						descripcionProducto.setText("");
						precioProducto.setText("");
						stockProducto.setText("");
						stockMinimoProducto.setText("");
						codigoProducto.setEnabled(true);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "El producto no existe en el sistema.", "Producto no existente", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres no numéricos en los campos código, precio, stock ni stock mínimo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(69, 266, 187, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (codigoProducto.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe rellenar el campo.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					int codigo = Integer.parseInt(codigoProducto.getText());
					if (AdministradorProductos.getAdministradorProductos().existeProducto(codigo)) 
					{
						ProductoView prod = AdministradorProductos.getAdministradorProductos().getProductoView(codigo);
						descripcionProducto.setText(prod.getDescripcion());
						precioProducto.setText(String.valueOf(prod.getPrecio()));
						stockProducto.setText(String.valueOf(prod.getStock()));
						stockMinimoProducto.setText(String.valueOf(prod.getStockMinimo()));
						lblNewLabel_1.setVisible(true);
						lblNewLabel_2.setVisible(true);
						lblNewLabel_3.setVisible(true);
						lblNewLabel_4.setVisible(true);
						descripcionProducto.setVisible(true);
						precioProducto.setVisible(true);
						stockProducto.setVisible(true);
						stockMinimoProducto.setVisible(true);
						codigoProducto.setEnabled(false);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "El producto no existe en el sistema.", "Producto no existente", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres no numéricos en el campo código.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(248, 25, 76, 23);
		contentPane.add(btnNewButton_1);
	}
}

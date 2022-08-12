package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorProductos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class EliminarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigoProducto;


	/**
	 * Create the frame.
	 */
	public EliminarProducto() {
		setTitle("Eliminar Producto");
		setBounds(100, 100, 351, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(42, 52, 56, 20);
		contentPane.add(lblNewLabel);
		
		codigoProducto = new JTextField();
		codigoProducto.setBounds(238, 52, 86, 20);
		contentPane.add(codigoProducto);
		codigoProducto.setColumns(10);
		
		JButton btnNewButton = new JButton("Eliminar Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (codigoProducto.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe llenar el campo código.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					int codigo = Integer.parseInt(codigoProducto.getText());
					
					boolean respuesta = AdministradorProductos.getAdministradorProductos().eliminarProducto(codigo);
					if (respuesta) {
						JOptionPane.showMessageDialog(null, "El producto se ha eliminado exitosamente.", "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
						codigoProducto.setText("");
						}
					else 
					{
						JOptionPane.showMessageDialog(null, "El producto no existe en el sistema.", "Producto no existente", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres en el campo código.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(82, 158, 174, 29);
		contentPane.add(btnNewButton);
	}
}

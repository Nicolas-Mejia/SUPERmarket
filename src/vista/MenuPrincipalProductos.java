package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class MenuPrincipalProductos extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public MenuPrincipalProductos() {
		setTitle("Men\u00FA de Productos");
		setBounds(100, 100, 567, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		
		JButton btnNewButton = new JButton("Crear Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProducto ventanaCrearProducto = new CrearProducto();
				ventanaCrearProducto.setVisible(true);
			}
		});
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Producto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto ventanaModificarProducto = new ModificarProducto();
				ventanaModificarProducto.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar Producto");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto ventanaEliminarProducto = new EliminarProducto();
				ventanaEliminarProducto.setVisible(true);

			}
		});
		contentPane.add(btnNewButton_2);
	}

}

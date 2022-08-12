package vista;

import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorVentas;

public class ConsultaProductosCredito extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ConsultaProductosCredito(int nroVenta) {
		super("Consulta de Productos");
		setBounds(100, 100, 778, 413);
		
		//Array bidimensional de objetos con los datos de la tabla
		
		Vector<Vector<String>> data = AdministradorVentas.getAdministradorVentas().getProductosVentaCredito(nroVenta);
	
		
		//Array titulos de tabla		
		Vector<String>columnNames = new Vector<String>();
		columnNames.add("Producto");
		columnNames.add("Cantidad");
		columnNames.add("Subtotal");
		
		//Creacion de la tabla
		final JTable table = new JTable(data, columnNames);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
	
		//Creamos un scrollpanel y se lo agregamos a la tabla
		JScrollPane scrollpane = new JScrollPane(table);
	
		//Agregamos el scrollpanel al contenedor
		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}

}

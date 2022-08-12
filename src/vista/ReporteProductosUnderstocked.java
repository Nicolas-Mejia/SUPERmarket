package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorProductos;
import Kiosco.AdministradorVentas;

public class ReporteProductosUnderstocked extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public ReporteProductosUnderstocked() {
		super("Consulta de Productos que llegaron a su Stock Minimo");
		setBounds(100, 100, 778, 413);
		
		//Array bidimensional de objetos con los datos de la tabla
		
		Vector<Vector<String>> data = AdministradorProductos.getAdministradorProductos().getProductosUnderstocked();
	
		
		//Array titulos de tabla		
		Vector<String>columnNames = new Vector<String>();
		columnNames.add("Descripción");
		columnNames.add("Precio");
		columnNames.add("Stock");
		columnNames.add("Stock Mínimo");
		
		//Creacion de la tabla
		final JTable table = new JTable(data, columnNames);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
	
		//Creamos un scrollpanel y se lo agregamos a la tabla
		JScrollPane scrollpane = new JScrollPane(table);
	
		//Agregamos el scrollpanel al contenedor
		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}

}

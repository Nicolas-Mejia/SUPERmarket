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

import Kiosco.AdministradorCajas;
import Kiosco.AdministradorProductos;
import Kiosco.AdministradorVentas;

public class ReporteVentasMensuales extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public ReporteVentasMensuales(int mes, int año) {
		super("Ventas diarias totalizadas.");
		setBounds(100, 100, 778, 413);
		
		//Array bidimensional de objetos con los datos de la tabla
		
		Vector<Vector<String>> data = AdministradorCajas.getAdministradorCajas().getImportesVentasMensuales(mes, año);
	
		
		//Array titulos de tabla		
		Vector<String>columnNames = new Vector<String>();
		columnNames.add("Dia");
		columnNames.add("Mes");
		columnNames.add("Año");
		columnNames.add("Total");
		
		//Creacion de la tabla
		final JTable table = new JTable(data, columnNames);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
	
		//Creamos un scrollpanel y se lo agregamos a la tabla
		JScrollPane scrollpane = new JScrollPane(table);
	
		//Agregamos el scrollpanel al contenedor
		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}

}

package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorProductos;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class MenuPrincipalReportes extends JFrame {

	private JPanel contentPane;
	private JTextField mesField;
	private JTextField añoField;

	

	/**
	 * Create the frame.
	 */
	public MenuPrincipalReportes() {
		setBounds(100, 100, 680, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JButton btnNewButton = new JButton("Productos A Stockear");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(5, 191, 218, 193);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteProductosUnderstocked ventanaProductos = new ReporteProductosUnderstocked();
				ventanaProductos.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ventas Mensuales");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (mesField.getText().isEmpty() || añoField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					else
					{
						int mes = Integer.parseInt(mesField.getText());
						int año = Integer.parseInt(añoField.getText());
						
						ReporteVentasMensuales ventanaReportesMensuales = new ReporteVentasMensuales(mes, año);
						ventanaReportesMensuales.setVisible(true);
					}

				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres en los campos código, precio, stock ni stock mínimo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(223, 191, 218, 193);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ventas Mensuales por Medio de Pago");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (mesField.getText().isEmpty() || añoField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					else
					{
						int mes = Integer.parseInt(mesField.getText());
						int año = Integer.parseInt(añoField.getText());
						
						ReporteVentasMensualesAbiertas ventanaReportesAbiertos = new ReporteVentasMensualesAbiertas(mes, año);
						ventanaReportesAbiertos.setVisible(true);
					}

				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres en los campos código, precio, stock ni stock mínimo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(441, 191, 218, 193);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Mes:");
		lblNewLabel.setBounds(310, 69, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A\u00F1o:");
		lblNewLabel_1.setBounds(310, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		mesField = new JTextField();
		mesField.setBounds(488, 66, 86, 20);
		contentPane.add(mesField);
		mesField.setColumns(10);
		
		añoField = new JTextField();
		añoField.setBounds(488, 105, 86, 20);
		contentPane.add(añoField);
		añoField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Formato MM/AAAA");
		lblNewLabel_2.setBounds(483, 27, 126, 14);
		contentPane.add(lblNewLabel_2);
	}
}

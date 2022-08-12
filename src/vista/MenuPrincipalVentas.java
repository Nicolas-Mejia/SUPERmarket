package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorVentas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class MenuPrincipalVentas extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public MenuPrincipalVentas() {
		setTitle("Men\u00FA de Ventas");
		setBounds(100, 100, 688, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		
		JButton btnNewButton = new JButton("Iniciar Venta Contado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentaContado ventanaVentaContado = new VentaContado();
				ventanaVentaContado.setVisible(true);
			}
		});
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar Venta Credito");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentaCredito ventanaVentaCredito = new VentaCredito();
				ventanaVentaCredito.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Iniciar Venta Debito");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentaDebito ventanaVentaDebito = new VentaDebito();
				ventanaVentaDebito.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
	}

}

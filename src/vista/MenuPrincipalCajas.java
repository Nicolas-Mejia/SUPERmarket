package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorCajas;
import Kiosco.AdministradorVentas;
import Kiosco.VentaContadoView;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalCajas extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public MenuPrincipalCajas() {
		setTitle("Men\u00FA de Cajas");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		setResizable(false);

		
		JButton btnNewButton = new JButton("Abrir Caja");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean respuesta = AdministradorCajas.getAdministradorCajas().iniciarCaja();
					
				if (respuesta) {
					JOptionPane.showMessageDialog(null, "Se ha iniciado la caja correctamente.", "Caja iniciada", JOptionPane.INFORMATION_MESSAGE);
					}
					
				else {
					JOptionPane.showMessageDialog(null, "Debe cerrar la caja del día anterior primero.", "Caja previa aún abierta.", JOptionPane.ERROR_MESSAGE);
					}
					
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar Caja");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float total = AdministradorCajas.getAdministradorCajas().cerrarCaja();
				
				if (total != -1) {
					JOptionPane.showMessageDialog(null, "Se ha cerrado la caja correctamente. El total fue de " + total, "Caja iniciada", JOptionPane.INFORMATION_MESSAGE);
					}
					
				else {
					JOptionPane.showMessageDialog(null, "No hay ninguna caja abierta.", "Caja no abierta.", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Saldo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saldo ventanaSaldo = new Saldo();
				ventanaSaldo.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
	}
	
	

}

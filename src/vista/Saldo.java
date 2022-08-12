package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorCajas;
import Kiosco.AdministradorVentas;
import Kiosco.VentaContadoView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Saldo extends JFrame {

	private JPanel contentPane;
	private JTextField saldo;
	private JTextField descontado;
	private float desc;
	private boolean respuesta;

	

	/**
	 * Create the frame.
	 */
	public Saldo() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		
		JLabel lblNewLabel = new JLabel("Saldo:");
		lblNewLabel.setBounds(131, 13, 53, 14);
		contentPane.add(lblNewLabel);
		
		saldo = new JTextField(AdministradorCajas.getAdministradorCajas().getSaldo() + "");
		saldo.setEnabled(false);
		saldo.setBounds(257, 10, 86, 20);
		contentPane.add(saldo);
		saldo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descontado:");
		lblNewLabel_1.setBounds(131, 83, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		descontado = new JTextField();
		descontado.setBounds(257, 80, 86, 20);
		contentPane.add(descontado);
		descontado.setColumns(10);
		
		JButton btnNewButton = new JButton("Actualizar Saldo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (descontado.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar el campo descontado.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					desc = Float.parseFloat(descontado.getText());
					if (desc <= AdministradorCajas.getAdministradorCajas().getSaldo())
					{
						respuesta = AdministradorCajas.getAdministradorCajas().actualizarSaldo(desc);
						
						if (respuesta) {
							descontado.setText("");
							saldo.setText(AdministradorCajas.getAdministradorCajas().getSaldo() + "");
							JOptionPane.showMessageDialog(null, "Se ha actualizado el saldo correctamente.", "Saldo actualizado.", JOptionPane.INFORMATION_MESSAGE);
							}
						
						else {
							JOptionPane.showMessageDialog(null, "No hay una caja abierta.", "Error.", JOptionPane.ERROR_MESSAGE);
							}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No puede descontar más que el saldo actual.", "Error.", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres en los campos código ni cantidad.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(160, 154, 147, 23);
		contentPane.add(btnNewButton);
	}

}

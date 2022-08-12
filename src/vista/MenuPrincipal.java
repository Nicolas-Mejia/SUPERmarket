package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorCajas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("Men\u00FA Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		
		JButton btnNewButton = new JButton("Productos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalProductos menuProductos = new MenuPrincipalProductos();
				menuProductos.setVisible(true);
			}
		});
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ventas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate fechaCaja = AdministradorCajas.getAdministradorCajas().getFechaCajaActual();
				if (fechaCaja != null)
				{
					if (LocalDate.now().isEqual(fechaCaja))
					{
						MenuPrincipalVentas menuVentas = new MenuPrincipalVentas();
						menuVentas.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No cerró la caja de ayer.", "Caja previa aún abierta.", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No hay ninguna caja abierta.", "Caja no abierta.", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Caja");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalCajas menuCajas = new MenuPrincipalCajas();
				menuCajas.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reportes");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalReportes menuReportes = new MenuPrincipalReportes();
				menuReportes.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);
	}

}

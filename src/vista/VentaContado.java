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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTree;

public class VentaContado extends JFrame {

	private JPanel contentPane;
	private JTextField fieldNumVenta;
	private JTextField codigoProducto;
	private JTextField cantProducto;
	private int nroVenta;
	private JTextField total;
	private JTextField efvo;
	private JTextField vuelto;
	private Vector<Integer> codigosUsados;


	

	/**
	 * Create the frame.
	 */
	
	public VentaContado() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Venta Contado");
		setBounds(100, 100, 631, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		codigosUsados = new Vector<>();

		nroVenta = AdministradorVentas.getAdministradorVentas().iniciarVentaContado();
		
		JLabel lblNumVenta = new JLabel("N\u00FAmero venta:");
		lblNumVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumVenta.setBounds(36, 32, 107, 20);
		contentPane.add(lblNumVenta);
		
		fieldNumVenta = new JTextField();
		fieldNumVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		fieldNumVenta.setBounds(465, 32, 88, 20);
		contentPane.add(fieldNumVenta);
		fieldNumVenta.setColumns(10);
		fieldNumVenta.setText(String.valueOf(nroVenta));
		fieldNumVenta.setEnabled(false);
		
		JButton btnNewButton = new JButton("Agregar Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (codigoProducto.getText().isEmpty() || cantProducto.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					int codigo = Integer.parseInt(codigoProducto.getText());
					int cantidad = Integer.parseInt(cantProducto.getText());
					
					if (cantidad > 0)
					{
						if (!codigosUsados.contains(codigo))
						{
							if (cantidad <= AdministradorVentas.getAdministradorVentas().getStockProducto(codigo))
							{
								int respuesta = AdministradorVentas.getAdministradorVentas().agregarProductoVentaContado(nroVenta, codigo, cantidad);
								
								if (respuesta == 0) 
									{
									codigoProducto.setText("");
									cantProducto.setText("");
									VentaContadoView ventaView = AdministradorVentas.getAdministradorVentas().getVentaContadoView(nroVenta);
									total.setText(ventaView.getTotal() + "");
									JOptionPane.showMessageDialog(null, "Se ha agregado el producto correctamente.", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
									}
								
								else if (respuesta == 1) 
									{
									JOptionPane.showMessageDialog(null, "No hay stock suficiente de ese producto.", "Stock insuficiente.", JOptionPane.ERROR_MESSAGE);
									}
								else
									{
									JOptionPane.showMessageDialog(null, "El código de producto ingresado es incorrecto.", "Código incorrecto.", JOptionPane.ERROR_MESSAGE);
									}
}
							
							else
							{
								JOptionPane.showMessageDialog(null, "No hay stock suficiente.", "Stock insuficiente.", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El producto ya está en la venta.", "Producto ya agregado.", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "No se puede agregar stock inferior a 1.", "Stock erróneo.", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres no numéricos en los campos código ni cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(26, 168, 150, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver Productos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProductosContado ventanaConsultaProductosContado = new ConsultaProductosContado(nroVenta);
				ventanaConsultaProductosContado.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(231, 168, 150, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo Producto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(36, 73, 107, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(36, 114, 88, 20);
		contentPane.add(lblNewLabel_1);
		
		codigoProducto = new JTextField();
		codigoProducto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		codigoProducto.setBounds(465, 73, 86, 20);
		contentPane.add(codigoProducto);
		codigoProducto.setColumns(10);
		
		cantProducto = new JTextField();
		cantProducto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cantProducto.setBounds(465, 114, 86, 20);
		contentPane.add(cantProducto);
		cantProducto.setColumns(10);
		
		
		JButton btnNewButton_2 = new JButton("Cancelar Venta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministradorVentas.getAdministradorVentas().cancelarVentaContado(nroVenta);
				VentaContado.this.dispose();
				}
		});
		
		
		btnNewButton_2.setBounds(340, 378, 150, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(36, 250, 88, 20);
		contentPane.add(lblNewLabel_2);
		
		total = new JTextField();
		total.setFont(new Font("Tahoma", Font.PLAIN, 11));
		total.setBounds(465, 250, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
		total.setEnabled(false);
		
		JButton btnNewButton_3 = new JButton("Quitar Producto");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (codigoProducto.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar el campo código del producto.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					int codigo = Integer.parseInt(codigoProducto.getText());
					
					boolean respuesta = AdministradorVentas.getAdministradorVentas().quitarProductoVentaContado(nroVenta, codigo);
					
					if (respuesta) {
						codigoProducto.setText("");
						VentaContadoView ventaView = AdministradorVentas.getAdministradorVentas().getVentaContadoView(nroVenta);
						total.setText(ventaView.getTotal() + "");
						JOptionPane.showMessageDialog(null, "Se ha quitado el producto correctamente.", "Producto quitado", JOptionPane.INFORMATION_MESSAGE);
						}
					
					else {
						JOptionPane.showMessageDialog(null, "El producto no está en esta venta / no existe en el sistema.", "Error.", JOptionPane.ERROR_MESSAGE);
						}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres no numéricos en los campos código ni cantidad.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_3.setBounds(437, 168, 150, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cerrar Venta");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (efvo.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar el campo pago efectivo.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					float pago = Float.parseFloat(efvo.getText());
					float respuesta = AdministradorVentas.getAdministradorVentas().cerrarVentaContado(nroVenta);
					if (pago - Float.parseFloat(total.getText()) <= AdministradorCajas.getAdministradorCajas().getSaldo() - Float.parseFloat(total.getText()))
					{
						if (respuesta != 0) {
							efvo.setEnabled(false);
							vuelto.setText(AdministradorVentas.getAdministradorVentas().calcularVuelto(nroVenta, pago) + "");
							JOptionPane.showMessageDialog(null, "Venta concretada correctamente.", "Venta concretada.", JOptionPane.INFORMATION_MESSAGE);
							VentaContado.this.dispose();
							}
						
						else {
							JOptionPane.showMessageDialog(null, "No se agregó ningún producto.", "Error.", JOptionPane.ERROR_MESSAGE);
							}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No posee saldo suficiente para el vuelto.", "Vuelto insuficiente.", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres no numéricos en los campos código ni cantidad.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_4.setBounds(118, 378, 150, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("Pago Efectivo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(36, 294, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		efvo = new JTextField();
		efvo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		efvo.setBounds(465, 288, 86, 20);
		contentPane.add(efvo);
		efvo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Vuelto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(36, 337, 56, 14);
		contentPane.add(lblNewLabel_4);
		
		vuelto = new JTextField();
		vuelto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		vuelto.setEnabled(false);
		vuelto.setBounds(465, 331, 86, 20);
		contentPane.add(vuelto);
		vuelto.setColumns(10);
		
	}
}

package vista;

import java.awt.BorderLayout;
import java.util.Vector;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kiosco.AdministradorVentas;
import Kiosco.VentaContadoView;
import Kiosco.VentaCreditoView;
import Kiosco.VentaDebitoView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.YearMonth;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTree;

public class VentaDebito extends JFrame {

	private JPanel contentPane;
	private JTextField fieldNumVenta;
	private JTextField codigoProducto;
	private JTextField cantProducto;
	private int nroVenta;
	private JTextField total;
	private JTextField mes;
	private JTextField año;
	private JTextField codigoTarjeta;
	private JTextField banco;
	private Vector<Integer> codigosUsados;

	

	/**
	 * Create the frame.
	 */
	
	public VentaDebito() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Venta Debito");
		setBounds(100, 100, 611, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		codigosUsados = new Vector<>();
		
		nroVenta = AdministradorVentas.getAdministradorVentas().iniciarVentaDebito();
		
		JLabel lblNumVenta = new JLabel("N\u00FAmero venta:");
		lblNumVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumVenta.setBounds(50, 32, 88, 14);
		contentPane.add(lblNumVenta);
		
		fieldNumVenta = new JTextField();
		fieldNumVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		fieldNumVenta.setBounds(464, 32, 88, 20);
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
								int respuesta = AdministradorVentas.getAdministradorVentas().agregarProductoVentaDebito(nroVenta, codigo, cantidad);
								
								if (respuesta == 0) {
									codigosUsados.add(codigo);
									codigoProducto.setText("");
									cantProducto.setText("");
									VentaDebitoView ventaView = AdministradorVentas.getAdministradorVentas().getVentaDebitoView(nroVenta);
									total.setText(ventaView.getTotal() + "");
									codigoTarjeta.setEnabled(true);
									banco.setEnabled(true);
									mes.setEnabled(true);
									año.setEnabled(true);
									JOptionPane.showMessageDialog(null, "Se ha agregado el producto correctamente.", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
									}
								
								else if (respuesta == 1)
								{
									JOptionPane.showMessageDialog(null, "No hay stock suficiente de ese producto.", "Stock insuficiente.", JOptionPane.ERROR_MESSAGE);
								}
								
								else {
									JOptionPane.showMessageDialog(null, "El código de producto ingresado es incorrecto.", "Codigo incorrecto", JOptionPane.ERROR_MESSAGE);
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
				ConsultaProductosDebito ventanaConsultaProductosDebito = new ConsultaProductosDebito(nroVenta);
				ventanaConsultaProductosDebito.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(236, 168, 150, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo Producto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(50, 73, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(50, 114, 88, 14);
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
				AdministradorVentas.getAdministradorVentas().cancelarVentaDebito(nroVenta);
				VentaDebito.this.dispose();
				}
		});
		
		
		btnNewButton_2.setBounds(338, 380, 150, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(50, 250, 86, 20);
		contentPane.add(lblNewLabel_2);
		
		total = new JTextField();
		total.setFont(new Font("Tahoma", Font.PLAIN, 11));
		total.setBounds(466, 250, 86, 20);
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
					
					boolean respuesta = AdministradorVentas.getAdministradorVentas().quitarProductoVentaDebito(nroVenta, codigo);
					
					if (respuesta) {
						codigosUsados.removeElement(codigo);
						codigoProducto.setText("");
						VentaDebitoView ventaView = AdministradorVentas.getAdministradorVentas().getVentaDebitoView(nroVenta);
						total.setText(ventaView.getTotal() + "");
						JOptionPane.showMessageDialog(null, "Se ha quitado el producto correctamente.", "Producto quitado", JOptionPane.INFORMATION_MESSAGE);
						}
					
					else {
						JOptionPane.showMessageDialog(null, "El producto no está en esta venta / no existe en el sistema.", "Error.", JOptionPane.ERROR_MESSAGE);
						}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres no numéricos en los campos código del producto ni cantidad.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_3.setBounds(429, 168, 150, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cerrar Venta");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (codigoTarjeta.getText().isEmpty() || banco.getText().isEmpty() || mes.getText().isEmpty() || año.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
					}
					
					
					int codTarjeta = Integer.parseInt(codigoTarjeta.getText());
					String bancoTarjeta = banco.getText();
					YearMonth fechaTarjeta = YearMonth.of(Integer.parseInt(año.getText()), Integer.parseInt(mes.getText()));
					
					
					float respuesta = AdministradorVentas.getAdministradorVentas().cerrarVentaDebito(nroVenta, codTarjeta, bancoTarjeta, fechaTarjeta);
					
					if (respuesta != 0) {
						JOptionPane.showMessageDialog(null, "Venta concretada correctamente.", "Venta concretada.", JOptionPane.INFORMATION_MESSAGE);
						VentaDebito.this.dispose();
						}
					
					else {
						JOptionPane.showMessageDialog(null, "No se agregó ningún producto.", "Error.", JOptionPane.ERROR_MESSAGE);
						}
				}
				
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "No ingrese caracteres no numéricos en los campos código tarjeta ni vencimiento.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
				
				catch (DateTimeException ErrDTE)
				{
					JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnNewButton_4.setBounds(136, 380, 150, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo Tarjeta:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(50, 284, 88, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Banco:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(50, 315, 88, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vencimiento:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(50, 347, 88, 14);
		contentPane.add(lblNewLabel_5);
		
		mes = new JTextField();
		mes.setEnabled(false);
		mes.setBounds(465, 341, 36, 20);
		contentPane.add(mes);
		mes.setColumns(10);
		
		año = new JTextField();
		año.setEnabled(false);
		año.setBounds(517, 341, 36, 20);
		contentPane.add(año);
		año.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("/");
		lblNewLabel_6.setBounds(508, 344, 9, 14);
		contentPane.add(lblNewLabel_6);
		
		codigoTarjeta = new JTextField();
		codigoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		codigoTarjeta.setEnabled(false);
		codigoTarjeta.setBounds(466, 278, 86, 20);
		contentPane.add(codigoTarjeta);
		codigoTarjeta.setColumns(10);
		
		banco = new JTextField();
		banco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		banco.setEnabled(false);
		banco.setBounds(466, 309, 86, 20);
		contentPane.add(banco);
		banco.setColumns(10);
		
	}
}

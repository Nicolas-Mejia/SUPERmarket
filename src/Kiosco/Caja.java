package Kiosco;

import java.util.Vector;
import java.time.LocalDate;

public class Caja {
	private LocalDate fecha;
	private float saldoEfectivo;
	private Vector<Venta> ventasDiarias;
	private Vector<VentaContado> ventasContadoDiarias;
	private Vector<VentaCredito> ventasCreditoDiarias;
	private Vector<VentaDebito> ventasDebitoDiarias;
	private float total;
	private boolean abierta;
	
	public Caja(float saldoEfectivo) {
		this.saldoEfectivo = saldoEfectivo;
		this.fecha = LocalDate.now();
		ventasDiarias = new Vector<Venta>();
		this.ventasContadoDiarias = new Vector<VentaContado>();
		this.ventasCreditoDiarias = new Vector<VentaCredito>();
		this.ventasDebitoDiarias = new Vector<VentaDebito>();
		this.abierta = true;
	}
	
	public void actualizarSaldo(float pago) {
		saldoEfectivo = saldoEfectivo + pago;
	}
	
	public float calcularTotalCaja() {
		total = 0;
		for (Venta venta : ventasDiarias) {
			total = total + venta.getTotal();
		}
		return total;
	}
	
	public float calcularSubtotalCajaContado() {
		total = 0;
		for (VentaContado venta : ventasContadoDiarias) {
			total = total + venta.getTotal();
		}
		return total;
	}
	
	public float calcularSubtotalCajaCredito() {
		total = 0;
		for (VentaCredito venta : ventasCreditoDiarias) {
			total = total + venta.getTotal();
		}
		return total;
	}
	
	public float calcularSubtotalCajaDebito() {
		total = 0;
		for (VentaDebito venta : ventasDebitoDiarias) {
			total = total + venta.getTotal();
		}
		return total;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public void agregarVentaContado(VentaContado v) {
		ventasContadoDiarias.add(v);
		ventasDiarias.add(v);
	}
	
	public void agregarVentaCredito(VentaCredito v) {
		ventasCreditoDiarias.add(v);
		ventasDiarias.add(v);
	}
	
	public void agregarVentaDebito(VentaDebito v) {
		ventasDebitoDiarias.add(v);
		ventasDiarias.add(v);
	}
	
	public boolean sosLaCaja(LocalDate fecha) {
		return (this.fecha == fecha);
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}
	
	public Vector<String> getVentaTotalizadaGeneral()
	{
		Vector<String> datos = new Vector<String>();
		datos.add(fecha.getDayOfMonth() + "");
		datos.add(fecha.getMonthValue() + "");
		datos.add(fecha.getYear() + "");
		datos.add("$"+ total);
		
		return datos;
	}
	
	public Vector<String> getVentaTotalizadaContado()
	{
		Vector<String> datos = new Vector<String>();
		datos.add(fecha.getDayOfMonth() + "");
		datos.add(fecha.getMonthValue() + "");
		datos.add(fecha.getYear() + "");
		datos.add("Contado");
		datos.add("$"+ calcularSubtotalCajaContado());
		
		return datos;
	}
	
	public Vector<String> getVentaTotalizadaCredito()
	{
		Vector<String> datos = new Vector<String>();
		datos.add(fecha.getDayOfMonth() + "");
		datos.add(fecha.getMonthValue() + "");
		datos.add(fecha.getYear() + "");
		datos.add("Credito");
		datos.add("$"+ calcularSubtotalCajaCredito());
		
		return datos;
	}
	
	public Vector<String> getVentaTotalizadaDebito()
	{
		Vector<String> datos = new Vector<String>();
		datos.add(fecha.getDayOfMonth() + "");
		datos.add(fecha.getMonthValue() + "");
		datos.add(fecha.getYear() + "");
		datos.add("Debito");
		datos.add("$"+ calcularSubtotalCajaDebito());
		
		return datos;
	}
}

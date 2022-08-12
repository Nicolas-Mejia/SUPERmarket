package Kiosco;

import java.time.LocalDate;
import java.util.Vector;

public class VentaContadoView {
	
	private LocalDate fecha;
	private int numero;
	private float total;
	private float montoPagado;
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(float montoPagado) {
		this.montoPagado = montoPagado;
	}
	public VentaContadoView(LocalDate fecha, int numero, float total, float montoPagado) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.montoPagado = montoPagado;
	}
	
	


}

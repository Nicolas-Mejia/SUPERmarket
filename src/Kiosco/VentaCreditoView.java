package Kiosco;

import java.time.LocalDate;
import java.time.YearMonth;

public class VentaCreditoView {

	private LocalDate fecha;
	private int numero;
	private float total;
	private int codigoAutorizacion;
	private String financiera;
	private YearMonth fechaVto;
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	public int getNumero() {
		return numero;
	}
	public float getTotal() {
		return total;
	}
	public int getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	public String getFinanciera() {
		return financiera;
	}
	public YearMonth getFechaVto() {
		return fechaVto;
	}
	public VentaCreditoView(LocalDate fecha, int numero, float total, int codigoAutorizacion, String financiera, YearMonth fechaVto) {
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.codigoAutorizacion = codigoAutorizacion;
		this.financiera = financiera;
		this.fechaVto = fechaVto;
	}
	
}

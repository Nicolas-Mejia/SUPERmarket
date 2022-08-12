package Kiosco;

import java.time.LocalDate;
import java.time.YearMonth;

public class VentaDebitoView {
	
	private LocalDate fecha;
	private int numero;
	private float total;
	private int codigoAutorizacion;
	private String banco;
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
	public String getBanco() {
		return banco;
	}
	public YearMonth getFechaVto() {
		return fechaVto;
	}
	
	
	public VentaDebitoView(LocalDate fecha, int numero, float total, int codigoAutorizacion, String banco, YearMonth fechaVto) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.codigoAutorizacion = codigoAutorizacion;
		this.banco = banco;
		this.fechaVto = fechaVto;
	}
	
	

}

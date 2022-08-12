package Kiosco;

import java.time.YearMonth;

public class VentaDebito extends Venta {

	private int codigoAutorizacion;
	private String banco;
	private YearMonth fechaVto;
	
	public VentaDebito() {
		super();
	}

	public void cerrar(int codigo, String banco, YearMonth vto) {
		this.codigoAutorizacion = codigo;
		this.banco = banco;
		this.fechaVto = vto;
	}
	
	public VentaDebitoView getView() {
		return new VentaDebitoView(fecha, numero, total, codigoAutorizacion, banco, fechaVto);
	}
}

package Kiosco;

import java.time.YearMonth;

public class VentaCredito extends Venta {
	
	private int codigoAutorizacion;
	private String financiera;
	private YearMonth fechaVto;

	public VentaCredito() {
		super();
	}
	
	public void cerrar (int codigo, String financiera, YearMonth vto) {
		this.codigoAutorizacion = codigo;
		this.financiera = financiera;
		this.fechaVto = vto;
	}

	public VentaCreditoView getView() {
		return new VentaCreditoView(fecha, numero, total, codigoAutorizacion, financiera, fechaVto);
	}
	

}

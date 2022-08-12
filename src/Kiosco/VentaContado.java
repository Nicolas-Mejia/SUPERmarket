package Kiosco;

public class VentaContado extends Venta {
	
	private float montoPagado;
	private float vuelto;

	public VentaContado() {
		super();
	}

	public float calcularVuelto(float montoPagado) {
		this.montoPagado = montoPagado;
		vuelto = montoPagado - total;
		return vuelto;
	}
	
	public float getVuelto() {
		return vuelto;
	}

	public VentaContadoView getView() {
		return new VentaContadoView(fecha, numero, total, montoPagado);
	}

}

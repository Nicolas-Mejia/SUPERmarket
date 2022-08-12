package Kiosco;

import java.util.Vector;

public class ItemVenta {

	private int cantidad;
	private Producto producto;
	
	public ItemVenta(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public float calcularSubtotal() {
		return (producto.getPrecio() * cantidad);
	}
	
	public void actualizarStock() {
		producto.descontarStock(cantidad);
	}
	
	public Vector<String> getDatosItem()
	{
		Vector<String> datos = new Vector<String>();
		datos.add(producto.getDescripcion());
		datos.add(cantidad + "");
		datos.add(calcularSubtotal() + "");
		
		return datos;
	}
}

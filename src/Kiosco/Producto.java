package Kiosco;

import java.util.Vector;

public class Producto {

	private int codigo;
	private String descripcion;
	private float precio;
	private int stock;
	private int stockMinimo;
	private boolean understocked;
	private boolean activo;
	
	public Producto(int codigo, String descripcion, float precio, int stockMinimo) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stockMinimo = stockMinimo;
		this.activo = true;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
		if (stock >= stockMinimo) {
			understocked = false;
		}
	}

	public void setStock(int stock) {
		this.stock = stock;
		
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	
	public boolean sosElProducto (int codigo) {
		if (this.codigo == codigo) {
			return true;
		}
		return false;
	}
	
	public void descontarStock (int cant) {
		stock = stock - cant;
		if (stock < stockMinimo) {
			understocked = true;
		}
	}

	public float getPrecio() {
		return precio;
	}
	
	public boolean eliminar() 
	{
		if (activo)
		{
			activo = false;
			return true;
		}
		return false;
	}

	public boolean isUnderstocked() {
		return understocked;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getStock() {
		return stock;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public boolean isActivo() {
		return activo;
	}

	public ProductoView getView() {
		return new ProductoView(codigo, descripcion, precio, stock, stockMinimo);
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public Vector<String> getProductoVector()
	{
		Vector<String> datos = new Vector<String>();
		datos.add(descripcion);
		datos.add(precio + "");
		datos.add(stock + "");
		datos.add(stockMinimo + "");
		
		return datos;
	}
	
	

}

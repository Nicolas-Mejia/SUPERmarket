package Kiosco;

public class ProductoView {

	private int codigo;
	private String descripcion;
	private float precio;
	private int stock;
	private int stockMinimo;
	
	public ProductoView(int codigo, String descripcion, float precio, int stock, int stockMinimo) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	
	
	
}

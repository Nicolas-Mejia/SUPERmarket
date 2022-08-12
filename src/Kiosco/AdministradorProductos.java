package Kiosco;

import java.util.Vector;


public class AdministradorProductos {

	private Vector<Producto> productos;
	private static AdministradorProductos instancia;


	private AdministradorProductos() {
		this.productos = new Vector<Producto>();
	}
	
	public static AdministradorProductos getAdministradorProductos()
	{
		if (instancia==null)
		{
			instancia= new AdministradorProductos();
		}
		
		return instancia;
	}
	
	public Producto buscarProducto(int cod) {
		for (Producto prod : productos) {
			if (prod.sosElProducto(cod)) {
				return prod;
			}
		}
		return null;
	}
	
	
	public boolean crearProducto(int codigo, String desc, float precio, int stockMin) {
		Producto prod = buscarProducto(codigo);
		if (prod == null) {
			prod = new Producto(codigo, desc, precio, stockMin);
			productos.add(prod);
			return true;
		}
		return false;
	}
	
	public boolean modificarProducto(int codigo, String desc, float precio, int stock, int stockMin) {
		Producto prod = buscarProducto(codigo);
		if (prod != null) {
			prod.setCodigo(codigo);
			prod.setDescripcion(desc);
			prod.setPrecio(precio);
			prod.setStock(stock);
			prod.setStockMinimo(stockMin);
			prod.setActivo(true);
			return true;
		}
		return false;
	}
	
	public boolean eliminarProducto(int codigo) {
		Producto prod = buscarProducto(codigo);
		if (prod != null) {
			return prod.eliminar();
		}
		return false;
	}
	
	public void emitirListadoStockMinimo() {
		for (Producto producto : productos) {
			if (producto.isUnderstocked() && producto.isActivo()) {
				System.out.print(producto.getDescripcion());
			}
		}
	}
	
	public String getDescripcionProducto(int codigo) {
		Producto prod = buscarProducto(codigo);
		if (prod != null) {
			return prod.getDescripcion();
		}
		return "";
	}

	public int getStockProducto(int codigo) {
		Producto prod = buscarProducto(codigo);
		if (prod != null) {
			return prod.getStock();
		}
		return -1;
	}

	public int getStockMinimoProducto(int codigo) {
		Producto prod = buscarProducto(codigo);
		if (prod != null) {
			return prod.getStockMinimo();
		}
		return -1;
	}
	
	public float getPrecioProducto(int codigo) {
		Producto prod = buscarProducto(codigo);
		if (prod != null) {
			return prod.getPrecio();
		}
		return -1;
	}
	
	public boolean existeProducto(int codigo) {
		Producto prod = buscarProducto(codigo);
		if (prod != null) {
			return true;
		}
		return false;
	}
	
	public ProductoView getProductoView(int codigo) {
		for (Producto prod : productos) {
			if (prod.sosElProducto(codigo)) {
				return prod.getView();
			}
		}
		return null;
	}
	
	public Vector<Vector<String>> getProductosUnderstocked()
	{
		Vector<Vector<String>> productosUnderstocked = new Vector<Vector<String>>();
		for (Producto prod : productos)
		{
			if (prod.isUnderstocked())
			{
				productosUnderstocked.add(prod.getProductoVector());
			}
		}
		return productosUnderstocked;
	}

}

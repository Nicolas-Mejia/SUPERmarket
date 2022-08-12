package Kiosco;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Vector;


public class AdministradorVentas {
	
	private Vector<VentaContado> ventasContado;
	private Vector<VentaCredito> ventasCredito;
	private Vector<VentaDebito> ventasDebito;
	private String razonSocial;
	private int cuit;
	private static AdministradorVentas instancia;
	private int total;
	
	
	private AdministradorVentas() {
		ventasContado = new Vector<VentaContado>();
		ventasCredito = new Vector<VentaCredito>();
		ventasDebito = new Vector<VentaDebito>();
		this.razonSocial = "Arcos Dorados S.A.";
		this.cuit = 30256789;
		
	}
	
	
	public static AdministradorVentas getAdministradorVentas()
	{
		if (instancia==null)
		{
			instancia= new AdministradorVentas();
		}
		return instancia;
	}

	public int iniciarVentaContado()
	{
		VentaContado newVenta = new VentaContado();
		ventasContado.add(newVenta);
		return newVenta.getNumero();
	}
	
	public int iniciarVentaCredito()
	{
		VentaCredito newVenta = new VentaCredito();
		ventasCredito.add(newVenta);
		return newVenta.getNumero();
	}
	
	public int iniciarVentaDebito()
	{
		VentaDebito newVenta = new VentaDebito();
		ventasDebito.add(newVenta);
		return newVenta.getNumero();
	}
	
	private VentaContado buscarVentaContado(int nroVenta)
	{
		for (VentaContado venta : ventasContado)
		{
			if (venta.sosLaVenta(nroVenta))
				return venta;
		}
		return null;
	}
	
	private VentaCredito buscarVentaCredito(int nroVenta)
	{
		for (VentaCredito venta : ventasCredito)
		{
			if (venta.sosLaVenta(nroVenta))
				return venta;
		}
		return null;
	}
	
	private VentaDebito buscarVentaDebito(int nroVenta)
	{
		for (VentaDebito venta : ventasDebito)
		{
			if (venta.sosLaVenta(nroVenta))
				return venta;
		}
		return null;
	}
	
	public int agregarProductoVentaContado(int nroVenta, int cod, int cantidad)
	{
		VentaContado venta = buscarVentaContado(nroVenta);
		AdministradorProductos AP = AdministradorProductos.getAdministradorProductos();
		if (venta!=null)
		{
			Producto prod = AP.buscarProducto(cod);
			if(prod!=null)
			{
				if (prod.getStock() >= cantidad)
				{
					venta.agregarItem(cantidad, prod);
					return 0;
				}
				return 1;
			}
			return 2;
		}
		return 3;
	}
	
	public boolean quitarProductoVentaContado(int nroVenta, int cod)
	{
		VentaContado venta = buscarVentaContado(nroVenta);
		AdministradorProductos AP = AdministradorProductos.getAdministradorProductos();
		if (venta!=null)
		{
			Producto prod = AP.buscarProducto(cod);
			if(prod!=null)
			{
				return (venta.quitarItem(prod));
			}
			return false;
		}
		return false;
	}
	
	public int agregarProductoVentaCredito(int nroVenta, int cod, int cantidad)
	{
		VentaCredito venta = buscarVentaCredito(nroVenta);
		AdministradorProductos AP = AdministradorProductos.getAdministradorProductos();
		if (venta!=null)
		{
			Producto prod = AP.buscarProducto(cod);
			if(prod!=null)
			{
				if (prod.getStock() >= cantidad)
				{
					venta.agregarItem(cantidad, prod);
					return 0;
				}
				return 1;
			}
			return 2;
		}
		return 3;
	}
	
	public boolean quitarProductoVentaCredito(int nroVenta, int cod)
	{
		VentaCredito venta = buscarVentaCredito(nroVenta);
		AdministradorProductos AP = AdministradorProductos.getAdministradorProductos();
		if (venta!=null)
		{
			Producto prod = AP.buscarProducto(cod);
			if(prod!=null)
			{
				venta.quitarItem(prod);;
				return true;
			}
			return false;
		}
		return false;
	}
	
	public int agregarProductoVentaDebito(int nroVenta, int cod, int cantidad)
	{
		VentaDebito venta = buscarVentaDebito(nroVenta);
		AdministradorProductos AP = AdministradorProductos.getAdministradorProductos();
		if (venta!=null)
		{
			Producto prod = AP.buscarProducto(cod);
			if(prod!=null)
			{
				if (prod.getStock() >= cantidad)
				{
					venta.agregarItem(cantidad, prod);
					return 0;
				}
				return 1;
			}
			return 2;
		}
		return 3;
	}
	
	public boolean quitarProductoVentaDebito(int nroVenta, int cod)
	{
		VentaDebito venta = buscarVentaDebito(nroVenta);
		AdministradorProductos AP = AdministradorProductos.getAdministradorProductos();
		if (venta!=null)
		{
			Producto prod = AP.buscarProducto(cod);
			if(prod!=null)
			{
				venta.quitarItem(prod);;
				return true;
			}
			return false;
		}
		return false;
	}
	
	public float cerrarVentaContado(int nroVenta) {
		VentaContado venta = buscarVentaContado(nroVenta);
		if (venta != null) {
			venta.actualizarStock();
			AdministradorCajas.getAdministradorCajas().agregarVentaContadoaCaja(venta);
			return venta.calcularTotal();
		}
		return 0;
	}
	
	public float calcularVuelto(int nroVenta, float montoPagado) {
		VentaContado venta = buscarVentaContado(nroVenta);
		if (venta != null) {
			return venta.calcularVuelto(montoPagado);
		}
		return 0;
	}
	
	public float cerrarVentaCredito(int nroVenta, int codigoTarjeta, String financiera, YearMonth vto) {
		VentaCredito venta = buscarVentaCredito(nroVenta);
		if (venta != null) {
			venta.actualizarStock();
			venta.cerrar(codigoTarjeta, financiera, vto);
			AdministradorCajas.getAdministradorCajas().agregarVentaCreditoaCaja(venta);
			return venta.calcularTotal();
		}
		return 0;
	}
	
	public float cerrarVentaDebito(int nroVenta, int codigo, String banco, YearMonth vto) {
		VentaDebito venta = buscarVentaDebito(nroVenta);
		if (venta != null) {
			venta.actualizarStock();
			venta.cerrar(codigo, banco, vto);
			AdministradorCajas.getAdministradorCajas().agregarVentaDebitoaCaja(venta);
			return venta.calcularTotal();
		}
		return 0;
	}
	
	public boolean cancelarVentaContado(int nroVenta)
	{
		VentaContado venta = buscarVentaContado(nroVenta);
		if (venta != null) {
			Venta.cancelarVenta();
			ventasContado.remove(venta);
			return true;
		}
		return false;
	}
	
	public boolean cancelarVentaCredito(int nroVenta)
	{
		VentaCredito venta = buscarVentaCredito(nroVenta);
		if (venta != null) {
			Venta.cancelarVenta();
			ventasCredito.remove(venta);
			return true;
		}
		return false;
	}
	
	public boolean cancelarVentaDebito(int nroVenta)
	{
		VentaDebito venta = buscarVentaDebito(nroVenta);
		if (venta != null) {
			Venta.cancelarVenta();
			ventasDebito.remove(venta);
			return true;
		}
		return false;
	}
	
	public Vector <Vector<String>> getProductosVentaContado(int nroVenta)
	{
		VentaContado venta = buscarVentaContado(nroVenta);
		if (venta != null) {
			return venta.getDatosItems();
		}
		return null;
	}
	
	public Vector <Vector<String>> getProductosVentaCredito(int nroVenta)
	{
		VentaCredito venta = buscarVentaCredito(nroVenta);
		if (venta != null) {
			return venta.getDatosItems();
		}
		return null;
	}
	
	public Vector <Vector<String>> getProductosVentaDebito(int nroVenta)
	{
		VentaDebito venta = buscarVentaDebito(nroVenta);
		if (venta != null) {
			return venta.getDatosItems();
		}
		return null;
	}
	
	public VentaContadoView getVentaContadoView(int nroVenta) {
		VentaContado venta = buscarVentaContado(nroVenta);
		if (venta != null) {
			return venta.getView();
		}
		return null;
	}
	
	public VentaCreditoView getVentaCreditoView(int nroVenta) {
		VentaCredito venta = buscarVentaCredito(nroVenta);
		if (venta != null) {
			return venta.getView();
		}
		return null;
	}
	
	public VentaDebitoView getVentaDebitoView(int nroVenta) {
		VentaDebito venta = buscarVentaDebito(nroVenta);
		if (venta != null) {
			return venta.getView();
		}
		return null;
	}
	
	public int getStockProducto(int codigoProducto)
	{
		Producto prod = AdministradorProductos.getAdministradorProductos().buscarProducto(codigoProducto);
		if(prod!=null)
		{
			return prod.getStock();
		}
		return -1;
	}
	
}

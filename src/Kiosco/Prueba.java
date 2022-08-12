package Kiosco;

import java.time.LocalDate;

public class Prueba {

	public static void main(String[] args) {
		Prueba Kiosco = new Prueba();
		Kiosco.iniciarKiosco();
	}

	
	public void iniciarKiosco()
	{
		//inicio el supermercado
		AdministradorVentas AV = AdministradorVentas.getAdministradorVentas();
		AdministradorProductos AP = AdministradorProductos.getAdministradorProductos();
		AdministradorCajas AC = AdministradorCajas.getAdministradorCajas();
		
		//iniciar caja
		AC.iniciarCaja();

		//agregar productos
		AP.crearProducto(1, "Yerba Amanda", 199, 20);
		AP.crearProducto(2, "Azucar Ledesma", 275, 20);
		
		//modificar stock  y precio
		AP.modificarProducto(1, "Yerba Amanda 500g", 240, 150, 20);
		
		//crear venta
		int nroVenta = AV.iniciarVentaContado();
		AV.agregarProductoVentaContado(nroVenta, 1, 2);
		AV.agregarProductoVentaContado(nroVenta, 2, 1);
		float total = AV.cerrarVentaContado(nroVenta);
		VentaContadoView ventaView = AdministradorVentas.getAdministradorVentas().getVentaContadoView(nroVenta);
		float a = ventaView.getTotal();
		System.out.println("El total de la venta es: " + total);
		
	}
}

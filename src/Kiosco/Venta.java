package Kiosco;

import java.time.LocalDate;
import java.util.Vector;

public abstract class Venta {

	protected Vector<ItemVenta> items;
	protected LocalDate fecha;
	protected int numero;
	protected float total;
	private static int proximoNumero;
	boolean cambio;
	int i;
	
	
	public static int getProximoNumero()
	{
		return ++proximoNumero;
	}
	
	public static void cancelarVenta()
	{
		proximoNumero--;
	}
	
	public Venta() {
		fecha = LocalDate.now();
		items = new Vector<ItemVenta>();
		numero = getProximoNumero();
	}
	
	public void agregarItem(int cantidad, Producto producto) {
		ItemVenta newItem = new ItemVenta(cantidad, producto);
		items.add(newItem);
		total = calcularTotal();
	}
	
	public boolean quitarItem(Producto producto) {
		cambio = false;
		i = 0;
		while (i < items.size()) {
			if (items.get(i).getProducto() == producto) {
				items.remove(items.get(i));
				cambio = true;
				total = calcularTotal();
			}
			else {
				i++;
			}
		}
		
		return cambio;
	}
	
	public void actualizarStock()
	{
		for (ItemVenta itemVenta : items) 
		{
			itemVenta.actualizarStock();
		}
	}

	public boolean sosLaVenta(int vta) 
	{
		return (vta==numero);
	}
	
	public float calcularTotal()
	{
		total = 0;
		for (ItemVenta itemVenta : items) 
		{
			total = total + itemVenta.calcularSubtotal();
		}
		return total;
	
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getNumero() {
		return numero;
	}

	public float getTotal() {
		return total;
	}
	
	public Vector <Vector<String>> getDatosItems()
	{
		Vector <Vector<String>> datosItems = new Vector<Vector<String>>();
		for (ItemVenta item : items)
		{
			datosItems.add(item.getDatosItem());
		}
		return datosItems;
	}
	
	public Vector<String> getDatosVenta(int totalDia)
	{
		Vector<String> datos = new Vector<String>();
		datos.add(fecha.getDayOfMonth() + "");
		datos.add(fecha.getMonthValue() + "");
		datos.add(fecha.getYear() + "");
		datos.add(totalDia + "");
		
		return datos;
	}
	
	public int getDia()
	{
		return fecha.getDayOfMonth();
	}
	
	public int getMes()
	{
		return fecha.getMonthValue();
	}
	
	public int getAño()
	{
		return fecha.getYear();
	}
	
}

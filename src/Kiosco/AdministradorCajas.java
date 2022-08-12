package Kiosco;

import java.util.Vector;
import java.time.YearMonth;
import java.time.LocalDate;

public class AdministradorCajas {
	private Vector<Caja> cajasDiarias;
	private static AdministradorCajas instancia;
	private Caja CajaActual;
	private float saldo;
	private float total;

	private AdministradorCajas() {
		cajasDiarias = new Vector<Caja>();
		saldo = 0;
	}
	
	public static AdministradorCajas getAdministradorCajas()
	{
		if (instancia==null)
		{
			instancia= new AdministradorCajas();
		}
		
		return instancia;
	}
	
	public boolean iniciarCaja() {
		if (CajaActual == null) 
		{
			Caja newCaja = new Caja(saldo);
			CajaActual = newCaja;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Caja buscarCaja(LocalDate fecha)
	{
		for (Caja caja : cajasDiarias)
		{
			if (caja.sosLaCaja(fecha))
				return caja;
		}
		return null;
	}
	
	public boolean agregarVentaContadoaCaja(VentaContado v) {
		if (CajaActual != null) {
			CajaActual.agregarVentaContado(v);
			saldo += v.getTotal();
			return true;
		}
		return false;
	}
	
	public boolean agregarVentaCreditoaCaja(VentaCredito v) {
		if (CajaActual != null) {
			CajaActual.agregarVentaCredito(v);
			return true;
		}
		return false;
	}
	
	public boolean agregarVentaDebitoaCaja(VentaDebito v) {
		if (CajaActual != null) {
			CajaActual.agregarVentaDebito(v);
			return true;
		}
		return false;
	}
	
	public float cerrarCaja() {
		if (CajaActual != null) 
		{
			total = CajaActual.calcularTotalCaja();
			cajasDiarias.add(CajaActual);
			CajaActual = null;
			return total;
		}
		else
		{
			return -1;
		}
	}
	
	public boolean actualizarSaldo(float descontado)
	{
		if (CajaActual != null) {
			saldo -= descontado;
			return true;
		}
		return false;
	}
	
	public LocalDate getFechaCajaActual()
	{
		if (CajaActual != null) {
			return CajaActual.getFecha();
		}
		return null;
	}
	
	public Vector<Vector<String>> getImportesVentasMensuales (int mes, int año) {
		Vector<Vector<String>> ventasMensualesTotalizadas = new Vector<Vector<String>>();
		for (Caja caja : cajasDiarias) {
			if (caja.getFecha().getMonthValue() == mes && caja.getFecha().getYear() == año) {
				ventasMensualesTotalizadas.add(caja.getVentaTotalizadaGeneral());
			}
		}
		return ventasMensualesTotalizadas;
	}
	
	public Vector<Vector<String>> getImportesVentasMensualesAbiertas (int mes, int año) {
		Vector<Vector<String>> ventasMensualesAbiertas = new Vector<Vector<String>>();
		for (Caja caja : cajasDiarias) {
			if (caja.getFecha().getMonthValue() == mes && caja.getFecha().getYear() == año) {
				ventasMensualesAbiertas.add(caja.getVentaTotalizadaContado());
				ventasMensualesAbiertas.add(caja.getVentaTotalizadaCredito());
				ventasMensualesAbiertas.add(caja.getVentaTotalizadaDebito());				
			}
		}
		return ventasMensualesAbiertas;
	}
	

	public float getSaldo() {
		return saldo;
	}
	
}

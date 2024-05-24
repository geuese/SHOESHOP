package ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Before;

import ar.edu.unalm.enums.Categoria;
import ar.edu.unalm.enums.TipoContrato;
import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;
import ar.edu.unalm.enums.ModoDePago;
import ar.edu.unalm.enums.TipoCalzado;
import ar.edu.unalm.enums.TipoDeEmpleado;
import ar.edu.unalm.enums.TipoDePisada;
import ar.edu.unalm.enums.TipoDeUso;
import ar.edu.unalm.enums.TipoSuperficie;
import ar.edu.unlam.dominio.Botin;
import ar.edu.unlam.dominio.Calzado;
import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.Empleado;
import ar.edu.unlam.dominio.OutDoor;
import ar.edu.unlam.dominio.Running;
import ar.edu.unlam.dominio.TiendaDeCalzado;

public class Test {

	private static final String NOMBRE_TIENDA_CALZADO = "ShoresShop";
	private TiendaDeCalzado tiendaDeCalzado;

	@Before
	public void init() {
		this.tiendaDeCalzado = new TiendaDeCalzado(NOMBRE_TIENDA_CALZADO);
	}

	@org.junit.Test
	public void queSePuedaAnadirCalzadoBotinALaTienda() {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;

		Marca marca = Marca.TOPPER;

		TipoSuperficie tipoSuperficie = TipoSuperficie.INTERIOR;
		Calzado calzado = new Botin(idCalzado, talle, stock, color, genero, precio, marca, tipoSuperficie);

		// Agregar calzado a local

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado);

		assertTrue(calzadoAgregado);

	}

	@org.junit.Test
	public void queSePuedaAñadirUnCalzadoRunningALaTienda() {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;
		Calzado running = new Running(idCalzado, talle, stock, color, genero, precio, marca, tipoPisada);

		// Agregar calzado a local

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(running);

		assertTrue(calzadoAgregado);

	}

	@org.junit.Test
	public void queSePuedaAñadirUnCalzadoOutDoorALaTienda() {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;

		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzado, talle, stock, color, genero, precio, marca, tipoDeUso);

		// Agregar calzado a local

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(outDoor);

		assertTrue(calzadoAgregado);

	}

	@org.junit.Test
	public void queSePuedaCrearElCliente() {

		String nombre = "Papu";
		Integer dni = 45555999;
		Integer talle = 37;
		Genero genero = Genero.X;
		ModoDePago modoDePago = ModoDePago.DEBITO;

		Cliente cliente = new Cliente(nombre, dni, talle, genero, modoDePago);

		Cliente cliente1 = new Cliente(nombre, dni, talle, genero, modoDePago);

		assertTrue(cliente.equals(cliente1));

	}

	@org.junit.Test
	public void queSePuedaCrearElEmpleado() {
		
		
		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;
		
		
		Empleado empleado = new Empleado(nombre,modalidadDeContratacion,legajo,tipoDeEmpleado,antiguedad,categoria);

		Empleado empleado1 = new Empleado(nombre,modalidadDeContratacion,legajo,tipoDeEmpleado,antiguedad,categoria);

		assertTrue(empleado.equals(empleado1));
		
	}
	
	@org.junit.Test
	public void queTraigaTodosLosRunning() {
		
	}
	
	@org.junit.Test
	public void queTraigaTodosLosOutDoor() {
		
	}
	
	@org.junit.Test
	public void queTraigaTodosLosBotin() {
		
	}
	
	@org.junit.Test
	public void buscarCalzadoPorCodigo() {
		
	}
	
	@org.junit.Test
	public void buscarCalzadoPorCodigoDevuelvePrecio() {
		
	}
	
	@org.junit.Test
	public void buscarCalzadoTipoOrdenadoPorTalle() {
		
	}
	
	@org.junit.Test
	public void asignarCalzadosAUnCliente() {
		
	}
	
	@org.junit.Test
	public void asignarClienteAUnEmpleado() {
		
	}
	
	@org.junit.Test
	public void obtenerListaDeCalzadosDelCliente() {
		
	}
	
	@org.junit.Test
	public void obtenerListaDeClientesDelEmpleado() {
		
	}
	
	@org.junit.Test
	public void calcularElTotalGastadoPorCadaCliente() {
		
	}
	
	@org.junit.Test
	public void obtenerElTotalDeVentasPorEmpleado() {
		
	}
	
	@org.junit.Test
	public void obtenerLosCalzadosPorClienteOrdenadosPorPrecioDescendente() {
		
	}
	
	@org.junit.Test
	public void venderCalzadoAUnCliente() {
		
	}
	
	@org.junit.Test
	public void calcularComisionDelEmpleado() {
		
	}
	
	@org.junit.Test
	public void calcularSueldoTotalSegunTipoEmpleado() {
		
	}
	
}

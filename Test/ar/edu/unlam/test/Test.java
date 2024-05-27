package ar.edu.unlam.test;

import static org.junit.Assert.*;

import java.util.List;

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

	//
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

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		Empleado empleado1 = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		assertTrue(empleado.equals(empleado1));

	}

	// Alexis
	@org.junit.Test
	public void queTraigaTodosLosRunning() {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;
		Calzado running = new Running(idCalzado, talle, stock, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, 12, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		// Agregar calzadoBuscado a local

		this.tiendaDeCalzado.agregarCalzado(running);
		this.tiendaDeCalzado.agregarCalzado(running2);

		// ahora agrego otro tipo

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		Integer stockOut = 10;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, stockOut, colorOut, generoOut, precioOut, marcaOut,
				tipoDeUsoOut);
		Calzado botin = new Botin(3, 33, 3, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);
		this.tiendaDeCalzado.agregarCalzado(outDoor);
		this.tiendaDeCalzado.agregarCalzado(botin);
		
		//verifico

		List<Running>calzadosRunning = this.tiendaDeCalzado.obtenerTodosLosRunning();
		
		assertEquals(2,calzadosRunning.size());

	}

	@org.junit.Test
	public void queTraigaTodosLosOutDoor() {
		
		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;
		Calzado running = new Running(idCalzado, talle, stock, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, 12, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(running);
		this.tiendaDeCalzado.agregarCalzado(running2);
		
		Calzado botin = new Botin(3, 33, 3, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);
		
		this.tiendaDeCalzado.agregarCalzado(botin);
		

		// ahora agrego de Tipo que busco

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		Integer stockOut = 10;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, stockOut, colorOut, generoOut, precioOut, marcaOut,
				tipoDeUsoOut);
		Calzado outDoor2 = new OutDoor(2, 43, 11, "Gris", Genero.MASCULINO, 100.0, Marca.NIKE,
				TipoDeUso.HIKING);
		Calzado outDoor3 = new OutDoor(3, 47, 3, "Negro", Genero.FEMENINO, 200.0, Marca.NIKE,
				tipoDeUsoOut);
		
		this.tiendaDeCalzado.agregarCalzado(outDoor);
		this.tiendaDeCalzado.agregarCalzado(outDoor2);
		this.tiendaDeCalzado.agregarCalzado(outDoor3);
	
		
		//verifico

		List<OutDoor>calzadosOutDoor = this.tiendaDeCalzado.obtenerTodosLosOutDoor();
		
		assertEquals(3,calzadosOutDoor.size());
	}

	@org.junit.Test
	public void queTraigaTodosLosBotin() { //repito codigo desordenado
		
		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;
		Calzado running = new Running(idCalzado, talle, stock, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, 12, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(running);
		this.tiendaDeCalzado.agregarCalzado(running2);
		
		Calzado botin = new Botin(3, 33, 3, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);
		
		this.tiendaDeCalzado.agregarCalzado(botin);
		

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		Integer stockOut = 10;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, stockOut, colorOut, generoOut, precioOut, marcaOut,
				tipoDeUsoOut);
		Calzado outDoor2 = new OutDoor(2, 43, 11, "Gris", Genero.MASCULINO, 100.0, Marca.NIKE,
				TipoDeUso.HIKING);
		Calzado outDoor3 = new OutDoor(3, 47, 3, "Negro", Genero.FEMENINO, 200.0, Marca.NIKE,
				tipoDeUsoOut);
		
		this.tiendaDeCalzado.agregarCalzado(outDoor);
		this.tiendaDeCalzado.agregarCalzado(outDoor2);
		this.tiendaDeCalzado.agregarCalzado(outDoor3);
	
		
		//verifico

		List<Botin>calzadosBotin = this.tiendaDeCalzado.obtenerTodosLosBotin();
		
		assertEquals(1,calzadosBotin.size());
	}

	@org.junit.Test
	public void calcularComisionDelEmpleado() {
		

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);
		
		// deberia agregar un empleado al array  tienda de calzado y el test de que se pueda crear un empleado teberia tener el agregado ahi?

		Integer comision = this.tiendaDeCalzado.calcularComisionEmpleado(empleado);
		
		
		// seria 20 * 6 * 9
		assertEquals(1080, (int)comision);
		
	}

	// Kevin
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
	public void calcularSueldoTotalSegunTipoEmpleado() {
	}

	// Gustavo
	@org.junit.Test
	public void asignarCalzadosAUnCliente() {
	}

	@org.junit.Test
	public void asignarClienteAUnEmpleado() {
	}

	@org.junit.Test
	public void calcularElTotalGastadoPorCadaCliente() {
	}

	@org.junit.Test
	public void venderCalzadoAUnCliente() {
	}

	// Elias

	@org.junit.Test
	public void obtenerListaDeCalzadosDelCliente() {

	}

	@org.junit.Test
	public void obtenerListaDeClientesDelEmpleado() {

	}

	@org.junit.Test
	public void obtenerElTotalDeVentasPorEmpleado() {

	}

	@org.junit.Test
	public void obtenerLosCalzadosPorClienteOrdenadosPorPrecioDescendente() {

	}

	// obtenerListaDeCalzadosDelCliente 19.
	// obtenerListaDeClientesDelEmpleado 20. obtenerElTotalDeVentasPorEmpleado 21.
	// obtenerLosCalzadosPorClienteOrdenadosPorPrecioDescendente

}

package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import ar.edu.unalm.enums.Categoria;
import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;
import ar.edu.unalm.enums.ModoDePago;
import ar.edu.unalm.enums.TipoContrato;
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

	private static final String NOMBRE_TIENDA_CALZADO = "ShoesShop";
	private TiendaDeCalzado tiendaDeCalzado;

	@Before
	public void init() {
		this.tiendaDeCalzado = new TiendaDeCalzado(NOMBRE_TIENDA_CALZADO);
	}

	// Faa
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
		Calzado calzado = new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);

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
		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);

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

		Calzado outDoor = new OutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

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
	public void queTraigaTodosLosRunning() {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;
		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		// Agregar calzadoBuscado a local

		this.tiendaDeCalzado.agregarCalzado(running,12);
		this.tiendaDeCalzado.agregarCalzado(running2,21);

		// ahora agrego otro tipo

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		Integer stockOut = 10;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, colorOut, generoOut, precioOut, marcaOut,
				tipoDeUsoOut);
		Calzado botin = new Botin(3, 33, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);
		this.tiendaDeCalzado.agregarCalzado(outDoor,11);
		this.tiendaDeCalzado.agregarCalzado(botin,22);
		
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
		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(running,20);
		this.tiendaDeCalzado.agregarCalzado(running2,21);
		
		Calzado botin = new Botin(3, 33,  "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);
		
		this.tiendaDeCalzado.agregarCalzado(botin,32);
		

		// ahora agrego de Tipo que busco

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		Integer stockOut = 10;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, colorOut, generoOut, precioOut, marcaOut,
				tipoDeUsoOut);
		Calzado outDoor2 = new OutDoor(2, 43, "Gris", Genero.MASCULINO, 100.0, Marca.NIKE,
				TipoDeUso.HIKING);
		Calzado outDoor3 = new OutDoor(3, 47, "Negro", Genero.FEMENINO, 200.0, Marca.NIKE,
				tipoDeUsoOut);
		
		this.tiendaDeCalzado.agregarCalzado(outDoor,2);
		this.tiendaDeCalzado.agregarCalzado(outDoor2,4);
		this.tiendaDeCalzado.agregarCalzado(outDoor3,20);
	
		
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
		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(running,30);
		this.tiendaDeCalzado.agregarCalzado(running2,22);
		
		Calzado botin = new Botin(3, 33, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);
		
		this.tiendaDeCalzado.agregarCalzado(botin,10);
		

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		Integer stockOut = 10;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, colorOut, generoOut, precioOut, marcaOut,
				tipoDeUsoOut);
		Calzado outDoor2 = new OutDoor(2, 43, "Gris", Genero.MASCULINO, 100.0, Marca.NIKE,
				TipoDeUso.HIKING);
		Calzado outDoor3 = new OutDoor(3, 47, "Negro", Genero.FEMENINO, 200.0, Marca.NIKE,
				tipoDeUsoOut);
		
		this.tiendaDeCalzado.agregarCalzado(outDoor,4);
		this.tiendaDeCalzado.agregarCalzado(outDoor2,2);
		this.tiendaDeCalzado.agregarCalzado(outDoor3,5);
	
		
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

	// 1
	@org.junit.Test
	public void obtenerListaDeCalzadosDelCliente() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);

		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		Integer cantidadDeCalzados = 4;

		this.tiendaDeCalzado.agregarCalzado(calzadoUno, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoDos, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoTres, cantidadDeCalzados);

		Integer cantidadAVender = 2;

		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, cantidadAVender);

		List<Calzado> calzados = new ArrayList<Calzado>();
		calzadoUno.setStock(cantidadAVender);
		calzadoDos.setStock(cantidadAVender);
		calzadoTres.setStock(cantidadAVender);
		calzados.add(calzadoUno);
		calzados.add(calzadoDos);
		calzados.add(calzadoTres);

		assertEquals(calzados, this.tiendaDeCalzado.obtenerlistaDeZapatosDeCliente(cliente));
		assertEquals(calzados.size(), this.tiendaDeCalzado.obtenerlistaDeZapatosDeCliente(cliente).size());

		// chequeo stock
		int i = 0;

		for (Calzado c : this.tiendaDeCalzado.obtenerlistaDeZapatosDeCliente(cliente)) {
			switch (i) {
			case 0:
				assertEquals((int) cantidadAVender, (int) c.getStock());
				break;
			case 1:
				assertEquals((int) cantidadAVender, (int) c.getStock());
				break;
			case 2:
				assertEquals((int) cantidadAVender, (int) c.getStock());
				break;
			default:
				break;
			}
			i++;
		}
	}

	@org.junit.Test
	public void queSePuedaAgregarCalzadoATienda() {
		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		Boolean seAgregoCalzadoUno = this.tiendaDeCalzado.agregarCalzado(calzadoUno, 2);
		Boolean seAgregoCalzadoDos = this.tiendaDeCalzado.agregarCalzado(calzadoDos, 2);
		Boolean seAgregoCalzadoTres = this.tiendaDeCalzado.agregarCalzado(calzadoTres, 2);

		assertTrue(seAgregoCalzadoUno);
		assertTrue(seAgregoCalzadoDos);
		assertTrue(seAgregoCalzadoTres);

		// no me da el stock sino la cantidad de calzados distintos, x ej en este caso
		// agregue 3 calzados
		// que son un botin un outdoor y un running, el stock es aparte.
		assertEquals(3, this.tiendaDeCalzado.getCalzados().size());

		// Aca me da el total de calzados de la tienda, es decir el stock total de todos
		// los calzados de la tienda.
		assertEquals(6, (int) this.tiendaDeCalzado.obtenerCantidadDeParesTotalesDeLaTienda());

	}

	@org.junit.Test
	public void queSePuedaVenderCalzadosACliente() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);

		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(calzadoUno, 3);
		this.tiendaDeCalzado.agregarCalzado(calzadoDos, 3);
		this.tiendaDeCalzado.agregarCalzado(calzadoTres, 3);

		Boolean seVendioCalzadoUno = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 2);
		Boolean seVendioCalzadoDos = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 1);
		Boolean seVendioCalzadoTres = this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, 3);

		assertTrue(seVendioCalzadoUno);
		assertTrue(seVendioCalzadoDos);
		assertTrue(seVendioCalzadoTres);

	}

	// 2
	@org.junit.Test
	public void obtenerListaDeClientesDelEmpleado() {
	}

	// 3
	@org.junit.Test
	public void obtenerElTotalDeVentasPorEmpleado() {
	}

	// 4
	@org.junit.Test
	public void obtenerLosCalzadosPorClienteOrdenadosPorPrecioDescendente() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);

		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		Integer cantidadDeCalzados = 4;

		this.tiendaDeCalzado.agregarCalzado(calzadoUno, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoDos, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoTres, cantidadDeCalzados);

		Integer cantidadAVender = 2;

		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, cantidadAVender);

		List<Calzado> calzados = new ArrayList<Calzado>();
		calzadoUno.setStock(cantidadAVender);
		calzadoDos.setStock(cantidadAVender);
		calzadoTres.setStock(cantidadAVender);
		calzados.add(calzadoDos);
		calzados.add(calzadoTres);
		calzados.add(calzadoUno);

		assertEquals(calzados,
				this.tiendaDeCalzado.obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(cliente));

		// chequeo precio por precio
		int i = 0;

		for (Calzado c : this.tiendaDeCalzado.obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(cliente)) {
			switch (i) {
			case 0:
				assertEquals(90000.00, c.getPrecio(), 0.001);
				// el 0.001 es un parametro de tolerancia que se necesita para evitar errores
				// cuando comparo doubles
				break;
			case 1:
				assertEquals(70000.00, c.getPrecio(), 0.001);
				break;
			case 2:
				assertEquals(45000.00, c.getPrecio(), 0.001);
				break;
			default:
				break;
			}
			i++;
		}
	}

	// Metodos para la resolucion

	public Botin crearBotin(Integer idCalzado, Integer talle, String color, Genero genero, Double precio, Marca marca,
			TipoSuperficie tipoSuperficie) {
		return new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
	}

	public OutDoor crearOutDoor(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoDeUso tipoDeUso) {
		return new OutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);
	}

	public Running crearRunning(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoDePisada tipoPisada) {
		return new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
	}

}

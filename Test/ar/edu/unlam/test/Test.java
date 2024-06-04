package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;

import ar.edu.unlam.dominio.*;
import ar.edu.unalm.enums.*;

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

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado, stock);

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

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(running, stock);

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

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(outDoor, stock);

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

	@org.junit.Test
	public void queSePuedabuscarCalzadoPorCodigo() throws CalzadoInexistenteException {

		Integer idCalzado = 1;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = crearOutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

		this.tiendaDeCalzado.agregarCalzado(outDoor, 1);

		Calzado calzadoEncontrado = this.tiendaDeCalzado.buscarCalzadoPorCodigo(idCalzado);

		assertTrue(outDoor.equals(calzadoEncontrado));

	}

	@org.junit.Test(expected = CalzadoInexistenteException.class)
	public void queNoSePuedabuscarCalzadoPorCodigo() throws CalzadoInexistenteException {

		Integer idCalzado = 1;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = crearOutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

		Calzado calzadoEncontrado = this.tiendaDeCalzado.buscarCalzadoPorCodigo(idCalzado);

		assertTrue(outDoor.equals(calzadoEncontrado));

	}

	@org.junit.Test
	public void queAlbuscarCalzadoPorCodigoDevuelvaElPrecioDelMismo() throws CalzadoInexistenteException {

		Integer idCalzado = 1;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = crearOutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

		this.tiendaDeCalzado.agregarCalzado(outDoor, 1);

		Double precioDelCalzadoEncontrado = this.tiendaDeCalzado.devolverPrecioDelCalzado(idCalzado);

		assertEquals(outDoor.getPrecio(), precioDelCalzadoEncontrado);
	}
	/*
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorFullTime() {
	 * 
	 * Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO,
	 * 2000, TipoDeEmpleado.REPOSITOR, 5, Categoria.FULL_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(204167.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPartTime() {
	 * 
	 * Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO,
	 * 2000, TipoDeEmpleado.REPOSITOR, 5, Categoria.PART_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(41000.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroFullTime() {
	 * 
	 * Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO,
	 * 2000, TipoDeEmpleado.CAJERO, 5, Categoria.FULL_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(424500.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPartTime() {
	 * 
	 * Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO,
	 * 2000, TipoDeEmpleado.CAJERO, 5, Categoria.PART_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(53000.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaFullTime() {
	 * 
	 * Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO,
	 * 2000, TipoDeEmpleado.VENTA_SALON, 5, Categoria.FULL_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(500000.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPartTime() {
	 * 
	 * Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO,
	 * 2000, TipoDeEmpleado.VENTA_SALON, 5, Categoria.PART_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(81000.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPasanteFullTime() {
	 * Empleado empleado = new Empleado("Jose", Contrato.PASANTIA, 2000,
	 * TipoDeEmpleado.VENTA_SALON, 5, Categoria.FULL_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(250000.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * @org.junit.Test public void
	 * queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPruebaFullTime() {
	 * Empleado empleado = new Empleado("Jose", Contrato.PRUEBA, 2000,
	 * TipoDeEmpleado.VENTA_SALON, 5, Categoria.FULL_TIME);
	 * 
	 * empleado.calcularElSueldo();
	 * 
	 * assertEquals(250000.0, empleado.getSueldo(), 0.01);
	 * 
	 * }
	 * 
	 * // DUDA SURGIDA: ¿LA FUNCION CALCULAR SUELDO NO DEBERIA IR EN LA TIENDA DE //
	 * CALZADO? //
	 */

	@org.junit.Test
	public void queSePuedaOrdenarLosBotinesSegunElTalleDeFormaAscendente() {
		Integer idCalzado = 1001;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoSuperficie tipoSuperficie = TipoSuperficie.INTERIOR;

		Calzado botin1 = crearBotin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
		Calzado botin2 = crearBotin(1002, 40, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER, TipoSuperficie.SUELO_BLANDO);
		Calzado botin3 = crearBotin(1003, 35, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS,
				TipoSuperficie.TERRENO_ARTIFICIAL);

		// AGREGAMOS CALZADOS
		this.tiendaDeCalzado.agregarCalzado(botin1, 2);
		this.tiendaDeCalzado.agregarCalzado(botin2, 2);
		this.tiendaDeCalzado.agregarCalzado(botin3, 2);

		List<Calzado> botinesOrdenados = this.tiendaDeCalzado.ordenarBotinesPorTalleDeManeraAscendente();

		assertEquals(botin3, botinesOrdenados.get(0));
		assertEquals(botin1, botinesOrdenados.get(1));
		assertEquals(botin2, botinesOrdenados.get(2));

	}

	@org.junit.Test
	public void queSePuedaOrdenarLosOutDoorSegunElTalleDeFormaAscendente() {
		Integer idCalzado = 1001;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDeUso tipoUso = TipoDeUso.ESCALADA;

		Calzado outDoor1 = crearOutDoor(idCalzado, talle, color, genero, precio, marca, tipoUso);
		Calzado outDoor2 = crearOutDoor(1002, 35, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER, TipoDeUso.TRAIL_RUNNING);
		Calzado outDoor3 = crearOutDoor(1003, 40, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS, TipoDeUso.HIKING);

		// AGREGAMOS CALZADOS
		this.tiendaDeCalzado.agregarCalzado(outDoor1, 1);
		this.tiendaDeCalzado.agregarCalzado(outDoor2, 1);
		this.tiendaDeCalzado.agregarCalzado(outDoor3, 1);

		List<Calzado> outDoorsOrdenados = this.tiendaDeCalzado.ordenarOutDoorsPorTalleDeManeraAscendente();

		assertEquals(outDoor2, outDoorsOrdenados.get(0));
		assertEquals(outDoor1, outDoorsOrdenados.get(1));
		assertEquals(outDoor3, outDoorsOrdenados.get(2));

	}

	@org.junit.Test
	public void queSePuedaOrdenarLosRunningsSegunElTalleDeFormaAscendente() {

		Integer idCalzado = 1001;
		Integer talle = 40;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoSuperficie = TipoDePisada.PISADA_NEUTRA;

		Calzado running1 = crearRunning(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
		Calzado running2 = crearRunning(1002, 37, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER,
				TipoDePisada.PISADA_PRONADORA);
		Calzado running3 = crearRunning(1003, 38, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		// AGREGAMOS CALZADOS
		this.tiendaDeCalzado.agregarCalzado(running1, 1);
		this.tiendaDeCalzado.agregarCalzado(running2, 1);
		this.tiendaDeCalzado.agregarCalzado(running3, 1);

		List<Calzado> runningsOrdenados = this.tiendaDeCalzado.ordenarRunningsPorTalleDeManeraAscendente();

		assertEquals(running2, runningsOrdenados.get(0));
		assertEquals(running3, runningsOrdenados.get(1));
		assertEquals(running1, runningsOrdenados.get(2));

	}

	@org.junit.Test
	public void queTraigaTodosLosRunnings() {

		Integer idCalzado = 1;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;

		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		// Agregar calzadoBuscado a local

		this.tiendaDeCalzado.agregarCalzado(running, 12);
		this.tiendaDeCalzado.agregarCalzado(running2, 21);

		// ahora agrego otro tipo

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, colorOut, generoOut, precioOut, marcaOut, tipoDeUsoOut);
		Calzado botin = new Botin(3, 33, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);
		this.tiendaDeCalzado.agregarCalzado(outDoor, 11);
		this.tiendaDeCalzado.agregarCalzado(botin, 22);

		// verifico

		List<Calzado> calzadosRunning = this.tiendaDeCalzado.obtenerTodosLosRunning();

		assertEquals(2, calzadosRunning.size());

	}

	@org.junit.Test
	public void queTraigaTodosLosOutDoor() {

		Integer idCalzado = 44;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;

		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(66, 40, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(running, 20);
		this.tiendaDeCalzado.agregarCalzado(running2, 21);

		Calzado botin = new Botin(123, 33, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);

		this.tiendaDeCalzado.agregarCalzado(botin, 32);

		// ahora agrego de Tipo que busco

		Integer idCalzadoOut = 23;
		Integer talleOut = 36;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = this.crearOutDoor(idCalzadoOut, talleOut, colorOut, generoOut, precioOut, marcaOut,
				tipoDeUsoOut);
		Calzado outDoor2 = this.crearOutDoor(2, 43, "Gris", Genero.MASCULINO, 100.0, Marca.NIKE, TipoDeUso.HIKING);
		Calzado outDoor3 = this.crearOutDoor(3, 47, "Negro", Genero.FEMENINO, 200.0, Marca.NIKE, tipoDeUsoOut);

		this.tiendaDeCalzado.agregarCalzado(outDoor, 3);
		this.tiendaDeCalzado.agregarCalzado(outDoor2, 3);
		this.tiendaDeCalzado.agregarCalzado(outDoor3, 3);

		// verifico
		List<Calzado> calzadosOutDoor = this.tiendaDeCalzado.obtenerTodosLosOutDoor();

		assertEquals(3, calzadosOutDoor.size());
	}

	@org.junit.Test
	public void queTraigaTodosLosBotin() { // repito codigo desordenado

		Integer idCalzado = 1;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;
		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
		Calzado running2 = new Running(2, 40, "Azul", Genero.FEMENINO, 35.0, Marca.ADIDAS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(running, 30);
		this.tiendaDeCalzado.agregarCalzado(running2, 22);

		Calzado botin = new Botin(3, 33, "Blanco", Genero.MASCULINO, 333.0, Marca.JOHN_FOOS,
				TipoSuperficie.SUELO_BLANDO);

		this.tiendaDeCalzado.agregarCalzado(botin, 10);

		Integer idCalzadoOut = 1;
		Integer talleOut = 36;
		String colorOut = "Negro";
		Genero generoOut = Genero.MASCULINO;
		Double precioOut = 20.0;

		Marca marcaOut = Marca.TOPPER;

		TipoDeUso tipoDeUsoOut = TipoDeUso.HIKING;

		Calzado outDoor = new OutDoor(idCalzadoOut, talleOut, colorOut, generoOut, precioOut, marcaOut, tipoDeUsoOut);
		Calzado outDoor2 = new OutDoor(2, 43, "Gris", Genero.MASCULINO, 100.0, Marca.NIKE, TipoDeUso.HIKING);
		Calzado outDoor3 = new OutDoor(3, 47, "Negro", Genero.FEMENINO, 200.0, Marca.NIKE, tipoDeUsoOut);

		this.tiendaDeCalzado.agregarCalzado(outDoor, 4);
		this.tiendaDeCalzado.agregarCalzado(outDoor2, 2);
		this.tiendaDeCalzado.agregarCalzado(outDoor3, 5);

		// verifico

		List<Calzado> calzadosBotin = this.tiendaDeCalzado.obtenerTodosLosBotin();

		assertEquals(1, calzadosBotin.size());
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

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		// deberia agregar un empleado al array tienda de calzado y el test de que se
		// pueda crear un empleado teberia tener el agregado ahi?

		Integer comision = this.tiendaDeCalzado.calcularComisionEmpleado(empleado);

		// seria 20 * 6 * 9
		assertEquals(1080, (int) comision);

	}

	@org.junit.Test
	public void queSePuedaAgregarEmpleadoATienda() {
		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		Boolean sePudo = this.tiendaDeCalzado.agregarEmpleado(empleado);

		assertTrue(sePudo);
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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINDADO, 11113,
				TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Integer cantidadAVender = 3;

		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, cantidadAVender, empleado);

		List<Calzado> calzados = this.tiendaDeCalzado.obtenerlistaDeCalzadosDeCliente(cliente);

		assertEquals(calzados.size(), this.tiendaDeCalzado.obtenerlistaDeCalzadosDeCliente(cliente).size());

		// chequeo stock
		int i = 0;

		for (Calzado c : this.tiendaDeCalzado.obtenerlistaDeCalzadosDeCliente(cliente)) {
			switch (i) {
			case 0:
				assertEquals((int) cantidadAVender, (int) c.getStockCliente());
				break;
			case 1:
				assertEquals((int) cantidadAVender, (int) c.getStockCliente());
				break;
			case 2:
				assertEquals((int) cantidadAVender, (int) c.getStockCliente());
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
		Boolean seAgregoCalzadoUno2 = this.tiendaDeCalzado.agregarCalzado(calzadoUno, 2);
		Boolean seAgregoCalzadoDos = this.tiendaDeCalzado.agregarCalzado(calzadoDos, 2);
		Boolean seAgregoCalzadoTres = this.tiendaDeCalzado.agregarCalzado(calzadoTres, 2);

		assertTrue(seAgregoCalzadoUno);
		assertTrue(seAgregoCalzadoUno2);
		assertTrue(seAgregoCalzadoDos);
		assertTrue(seAgregoCalzadoTres);

		// no me da el stock sino la cantidad de calzados distintos, x ej en este caso
		// agregue 3 calzados
		// que son un botin un outdoor y un running, el stock es aparte.
		assertEquals(3, this.tiendaDeCalzado.getCalzados().size());
		assertEquals(4, (int) calzadoUno.getStock());

		// Aca me da el total de calzados de la tienda, es decir el stock total de todos
		// los calzados de la tienda.
		assertEquals(8, (int) this.tiendaDeCalzado.obtenerCantidadDeParesTotalesDeLaTienda());

	}

	@org.junit.Test
	public void queSePuedaVenderCalzadosACliente() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);

		Calzado calzadoUno = crearBotin(1113, 40, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12111, 44, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER,
				TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(41115, 37, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		this.tiendaDeCalzado.agregarCalzado(calzadoUno, 3);
		this.tiendaDeCalzado.agregarCalzado(calzadoDos, 3);
		this.tiendaDeCalzado.agregarCalzado(calzadoTres, 3);

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINDADO, 11113,
				TipoDeEmpleado.VENTA_SALON, 20, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Boolean seVendioCalzadoUno = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 2, empleado);
		Boolean seVendioCalzadoDos = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 1, empleado);
		Boolean seVendioCalzadoTres = this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, 3, empleado);

		assertTrue(seVendioCalzadoUno);
		assertTrue(seVendioCalzadoDos);
		assertTrue(seVendioCalzadoTres);

//		assertEquals(1, (int) calzadoUno.getStock());

	}

	// 2
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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINDADO, 11113,
				TipoDeEmpleado.VENTA_SALON, 20, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Integer cantidadAVender = 2;

		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, cantidadAVender, empleado);

		assertEquals(3,
				this.tiendaDeCalzado.obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(cliente).size());

		List<Calzado> calzadosCliente = this.tiendaDeCalzado
				.obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(cliente);
		assertEquals(90000.00, calzadosCliente.get(0).getPrecio(), 0.1);
		assertEquals(70000.00, calzadosCliente.get(1).getPrecio(), 0.1);
		assertEquals(45000.00, calzadosCliente.get(2).getPrecio(), 0.1);

	}

	// 2 con TreeSet
	@org.junit.Test
	public void obtenerLosCalzadosPorClienteOrdenadosPorPrecioDescendente2() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);

		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		Integer cantidadDeCalzados = 4;

		this.tiendaDeCalzado.agregarCalzado(calzadoUno, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoUno, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoDos, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoTres, cantidadDeCalzados);

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINDADO, 11113,
				TipoDeEmpleado.VENTA_SALON, 20, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Integer cantidadAVender = 2;

		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, cantidadAVender, empleado);

		TreeSet<Calzado> calzadosObtenidos = this.tiendaDeCalzado
				.obtenerlistaDeZapatosDeClienteOrdenadosPorOrdenEspecifico(new OrdenPrecioDescendiente(), cliente);

		assertEquals(3, calzadosObtenidos.size());

		assertEquals(90000.00, calzadosObtenidos.first().getPrecio(), 0.1);
		assertEquals(45000.00, calzadosObtenidos.last().getPrecio(), 0.1);

	}

	// 3
	@org.junit.Test
	public void obtenerListaDeClientesDelEmpleado() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);
		Cliente cliente2 = new Cliente("Lolo", 34, 13, Genero.MASCULINO, ModoDePago.CREDITO);

		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		Integer cantidadDeCalzados = 4;

		this.tiendaDeCalzado.agregarCalzado(calzadoUno, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoDos, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoTres, cantidadDeCalzados);

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINDADO, 11113,
				TipoDeEmpleado.VENTA_SALON, 20, Categoria.FULL_TIME);
		Empleado empleado2 = new Empleado("non", TipoContrato.TIEMPO_INDETERMINDADO, 234,
				TipoDeEmpleado.VENTA_SALON, 23, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Integer cantidadAVender = 2;

		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente2, calzadoTres, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente2, calzadoTres, cantidadAVender, empleado2);

		List<Cliente> clientesDeEmpleado = this.tiendaDeCalzado.obtenerListaDeClientesDeEmpleado(empleado);
		List<Cliente> clientesDeEmpleado2 = this.tiendaDeCalzado.obtenerListaDeClientesDeEmpleado(empleado2);

		assertTrue(clientesDeEmpleado.contains(cliente));
		assertTrue(clientesDeEmpleado.contains(cliente2));
		assertTrue(clientesDeEmpleado2.contains(cliente2));
		assertEquals(2, clientesDeEmpleado.size());
		assertEquals(1, clientesDeEmpleado2.size());
	}

	// 4
	@org.junit.Test
	public void obtenerElTotalDeVentasPorEmpleado() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);
		Cliente cliente2 = new Cliente("Lolo", 34, 13, Genero.MASCULINO, ModoDePago.CREDITO);

		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		Integer cantidadDeCalzados = 4;

		this.tiendaDeCalzado.agregarCalzado(calzadoUno, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoDos, cantidadDeCalzados);
		this.tiendaDeCalzado.agregarCalzado(calzadoTres, cantidadDeCalzados);

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINDADO, 11113,
				TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Integer cantidadAVender = 2;

		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente2, calzadoTres, cantidadAVender, empleado);

		Integer totalDeVentas = this.tiendaDeCalzado.obtenerTotalDeVentasTotalesDeEmpleado(empleado);

		assertEquals(8, (int) totalDeVentas);
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
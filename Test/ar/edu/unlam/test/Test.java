package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
		Botin calzado = new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);

		// Agregar calzado a local

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado, stock);

		assertTrue(calzadoAgregado);

	}

	@org.junit.Test
	public void queNoSePuedaAnadirElMismoCalzadoBotinALaTienda() {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;

		Marca marca = Marca.TOPPER;

		TipoSuperficie tipoSuperficie = TipoSuperficie.INTERIOR;

		Calzado calzado = new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);

		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado, stock);

		Calzado calzado2 = new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
		Boolean calzadoAgregado2 = tiendaDeCalzado.agregarCalzado(calzado2, stock);

		assertEquals(1, this.tiendaDeCalzado.obtenerTodosLosBotines().size());

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
	public void queNoSePuedaAñadirElMismoCalzadoRunningALaTienda() {

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

		Calzado running2 = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);

		Boolean calzadoAgregado2 = tiendaDeCalzado.agregarCalzado(running2, stock);

		assertEquals(1, (int) this.tiendaDeCalzado.obtenerTodosLosRunning().size());

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
	public void queNoSePuedaAñadirElMismoCalzadoOutDoorALaTienda() {

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

		Calzado outDoor2 = new OutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

		Boolean calzadoAgregado2 = tiendaDeCalzado.agregarCalzado(outDoor2, stock);

		assertEquals(1, (int) this.tiendaDeCalzado.obtenerTodosLosOutDoor().size());

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

		Calzado outDoor = generarOutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

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

		Calzado outDoor = generarOutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

		Calzado calzadoEncontrado = this.tiendaDeCalzado.buscarCalzadoPorCodigo(idCalzado);


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

		Calzado outDoor = generarOutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

		this.tiendaDeCalzado.agregarCalzado(outDoor, 1);

		Double precioDelCalzadoEncontrado = this.tiendaDeCalzado.devolverPrecioDelCalzado(idCalzado);

		assertEquals(outDoor.getPrecio(), precioDelCalzadoEncontrado);
	}

	@org.junit.Test(expected = CalzadoInexistenteException.class)
	public void queNoSePuedaDevolverElPrecioDelCalzadoBuscadoSiEsteNoEstaEnLaTienda()

			throws CalzadoInexistenteException {

		Integer idCalzado = 1;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = crearOutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);

		Double precioDelCalzadoEncontrado = this.tiendaDeCalzado.devolverPrecioDelCalzado(idCalzado);

		assertEquals(outDoor.getPrecio(), precioDelCalzadoEncontrado);
	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorFullTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(204167.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPartTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(41000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPasanteFullTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PASANTIA, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(102083.5, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPruebaFullTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PRUEBA, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(61250.1, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPasantePartTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PASANTIA, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(20500.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPruebaPartTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PRUEBA, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(12300.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroFullTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(424500.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPartTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(53000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPasanteFullTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PASANTIA, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(212250.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPruebaFullTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PRUEBA, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(127350.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPasantePartTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PASANTIA, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(26500.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPruebaPartTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PRUEBA, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(15900.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaFullTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.VENTA_SALON,
				5, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(500000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPartTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.VENTA_SALON,
				5, Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(81000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPasanteFullTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PASANTIA, 2000, TipoDeEmpleado.VENTA_SALON, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(250000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPruebaFullTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PRUEBA, 2000, TipoDeEmpleado.VENTA_SALON, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(150000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPasantePartTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PASANTIA, 2000, TipoDeEmpleado.VENTA_SALON, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(40500.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPruebaPartTime()
			throws EmpleadoNoEncontradoException {
		Empleado empleado = new Empleado("Jose", TipoContrato.PRUEBA, 2000, TipoDeEmpleado.VENTA_SALON, 5,
				Categoria.PART_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(24300.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaOrdenarLosBotinesSegunElTalleDeFormaAscendente() {
		Integer idCalzado = 1001;
		Integer talle = 36;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;
		TipoSuperficie tipoSuperficie = TipoSuperficie.INTERIOR;

		Calzado botin1 = generarBotin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
		Calzado botin2 = generarBotin(1002, 40, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER,
				TipoSuperficie.SUELO_BLANDO);
		Calzado botin3 = generarBotin(1003, 35, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS,
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

		Calzado outDoor1 = generarOutDoor(idCalzado, talle, color, genero, precio, marca, tipoUso);
		Calzado outDoor2 = generarOutDoor(1002, 35, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER,
				TipoDeUso.TRAIL_RUNNING);
		Calzado outDoor3 = generarOutDoor(1003, 40, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS, TipoDeUso.HIKING);

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

		Calzado running1 = generarRunning(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
		Calzado running2 = generarRunning(1002, 37, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER,
				TipoDePisada.PISADA_PRONADORA);
		Calzado running3 = generarRunning(1003, 38, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS,
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

	private Running generarRunning(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoDePisada tipoPisada) {
		return new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
	}

	private OutDoor generarOutDoor(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoDeUso tipoDeUso) {
		return new OutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);
	}

	private Botin generarBotin(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoSuperficie tipoSuperficie) {
		return new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
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

		OutDoor outDoor = new OutDoor(idCalzadoOut, talleOut, colorOut, generoOut, precioOut, marcaOut, tipoDeUsoOut);
		Calzado outDoor2 = new OutDoor(2, 43, "Gris", Genero.MASCULINO, 100.0, Marca.NIKE, TipoDeUso.HIKING);
		Calzado outDoor3 = new OutDoor(3, 47, "Negro", Genero.FEMENINO, 200.0, Marca.NIKE, tipoDeUsoOut);

		this.tiendaDeCalzado.agregarCalzado(outDoor, 4);
		this.tiendaDeCalzado.agregarCalzado(outDoor2, 2);
		this.tiendaDeCalzado.agregarCalzado(outDoor3, 5);

		// verifico

		List<Calzado> calzadosBotin = this.tiendaDeCalzado.obtenerTodosLosBotines();

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

		assertEquals(1080, (int) comision);

	}

	@org.junit.Test
	public void queNoSePuedaCalcularComisionDeEmpleadoSiEsteNoEstaEnLaTienda() {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		Integer comision = this.tiendaDeCalzado.calcularComisionEmpleado(empleado);

		assertEquals(0, (int) comision);

	}

	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoFullTimeTiempoIndeterminado()
			throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		// STEP 1
		this.tiendaDeCalzado.agregarEmpleado(empleado);

		// STEP 2
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		// STEP 3
		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		// STEP 4
		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		// STEP 5
		assertEquals(424667.36, sueldoDeEmpleado, 0.01);

	}

	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoFullTimePasantia() throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.PASANTIA;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.FULL_TIME;

		// SUELDO REPOSITOR = 204167 FULLTIME
		// SUELDO REPOSITOR = 41000 PARTTIME

		// PRUEBA = ANTIGUEDAD *2
		// PASANTE = ANTIGUEDAD*4
		// TIEMPO_INDETERMINADO = ANTIGUEDAD*6

		// FULLTIME = COMISION * 9
		// PARTTIME = COMISION * 7

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		// STEP 1
		this.tiendaDeCalzado.agregarEmpleado(empleado);

		// STEP 2
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		// STEP 3
		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		// STEP 4
		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		// STEP 5
		assertEquals(175583.62, sueldoDeEmpleado, 0.01);

	}

	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoFullTimePrueba() throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.PRUEBA;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.FULL_TIME;

		// SUELDO REPOSITOR = 204167 FULLTIME
		// SUELDO REPOSITOR = 41000 PARTTIME

		// PRUEBA = ANTIGUEDAD *2
		// PASANTE = ANTIGUEDAD*4
		// TIEMPO_INDETERMINADO = ANTIGUEDAD*6

		// FULLTIME = COMISION * 9
		// PARTTIME = COMISION * 7

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		// STEP 1
		this.tiendaDeCalzado.agregarEmpleado(empleado);

		// STEP 2
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		// STEP 3
		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		// STEP 4
		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		// STEP 5
		assertEquals(83300.136, sueldoDeEmpleado, 0.01);

	}

	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoPartTimeTiempoIndeterminado()
			throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.PART_TIME;

		// SUELDO REPOSITOR = 204167 FULLTIME
		// SUELDO REPOSITOR = 41000 PARTTIME

		// PRUEBA = ANTIGUEDAD *2
		// PASANTE = ANTIGUEDAD*4
		// TIEMPO_INDETERMINADO = ANTIGUEDAD*6

		// FULLTIME = COMISION * 9
		// PARTTIME = COMISION * 7

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		// STEP 1
		this.tiendaDeCalzado.agregarEmpleado(empleado);

		// STEP 2
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		// STEP 3
		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		// STEP 4
		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		// STEP 5
		assertEquals(75440.0, sueldoDeEmpleado, 0.01);

	}
	
	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoPartTimePrueba()
			throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.PRUEBA;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.PART_TIME;

		// SUELDO REPOSITOR = 204167 FULLTIME
		// SUELDO REPOSITOR = 41000 PARTTIME

		// PRUEBA = ANTIGUEDAD *2
		// PASANTE = ANTIGUEDAD*4
		// TIEMPO_INDETERMINADO = ANTIGUEDAD*6

		// FULLTIME = COMISION * 9
		// PARTTIME = COMISION * 7

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		// STEP 1
		this.tiendaDeCalzado.agregarEmpleado(empleado);

		// STEP 2
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		// STEP 3
		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		// STEP 4
		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		// STEP 5
		assertEquals(15744.0, sueldoDeEmpleado, 0.01);

	}
	
	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoPartTimePasantia()
			throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.PASANTIA;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.PART_TIME;

		// SUELDO REPOSITOR = 204167 FULLTIME
		// SUELDO REPOSITOR = 41000 PARTTIME

		// PRUEBA = ANTIGUEDAD *2
		// PASANTE = ANTIGUEDAD*4
		// TIEMPO_INDETERMINADO = ANTIGUEDAD*6

		// FULLTIME = COMISION * 9
		// PARTTIME = COMISION * 7

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		// STEP 1
		this.tiendaDeCalzado.agregarEmpleado(empleado);

		// STEP 2
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		// STEP 3
		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		// STEP 4
		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		// STEP 5
		assertEquals(31980.0, sueldoDeEmpleado, 0.01);

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

	@org.junit.Test
	public void queSePuedaEncontrarEmpleadoATienda() throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Empleado empleadoEncontrado = this.tiendaDeCalzado.buscarEmpleado(empleado);

		assertTrue(empleado.equals(empleadoEncontrado));

	}

	@org.junit.Test(expected = EmpleadoNoEncontradoException.class)
	public void queNoSePuedaEncontrarElEmpleado() throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		Empleado empleadoEncontrado = this.tiendaDeCalzado.buscarEmpleado(empleado);

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
	
	// COMMIT PRUEBA

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
package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.TreeSet;

import org.junit.Before;

import ar.edu.unlam.dominio.*;
import ar.edu.unlam.enums.*;

public class Test {

	private static final String NOMBRE_TIENDA_CALZADO = "ShoesShop";
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
		Botin calzado = new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);

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
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
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

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINADO, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(204167.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPartTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINADO, 2000, TipoDeEmpleado.REPOSITOR, 5,
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

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINADO, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(424500.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPartTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINADO, 2000, TipoDeEmpleado.CAJERO, 5,
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

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINADO, 2000, TipoDeEmpleado.VENTA_SALON,
				5, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);
		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		assertEquals(500000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPartTime()
			throws EmpleadoNoEncontradoException {

		Empleado empleado = new Empleado("Jose", TipoContrato.TIEMPO_INDETERMINADO, 2000, TipoDeEmpleado.VENTA_SALON,
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


		this.tiendaDeCalzado.agregarCalzado(running, 12);
		this.tiendaDeCalzado.agregarCalzado(running2, 21);


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

		List<Calzado> calzadosOutDoor = this.tiendaDeCalzado.obtenerTodosLosOutDoor();

		assertEquals(3, calzadosOutDoor.size());
	}

	@org.junit.Test
	public void queTraigaTodosLosBotin() { 

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


		List<Calzado> calzadosBotin = this.tiendaDeCalzado.obtenerTodosLosBotines();

		assertEquals(1, calzadosBotin.size());
	}

	@org.junit.Test
	public void calcularComisionDelEmpleado() {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		

		Integer comision = this.tiendaDeCalzado.calcularComisionEmpleado(empleado);

		assertEquals(1080, (int) comision);

	}

	@org.junit.Test
	public void queNoSePuedaCalcularComisionDeEmpleadoSiEsteNoEstaEnLaTienda() {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		Integer comision = this.tiendaDeCalzado.calcularComisionEmpleado(empleado);

		assertEquals(0, (int) comision);

	}
	
	@org.junit.Test(expected = EmpleadoNoEncontradoException.class)
	public void queNoSePuedaAplicarLaComisionAlSueldoDelEmpleadoSiEsteNoExiste()
			throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);


		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

	}

	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoFullTimeTiempoIndeterminado()
			throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

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


		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

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

	

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		assertEquals(83300.136, sueldoDeEmpleado, 0.01);

	}

	@org.junit.Test
	public void queSePuedaAplicarLaComisionAlSueldoDelEmpleadoPartTimeTiempoIndeterminado()
			throws EmpleadoNoEncontradoException {

		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 2;
		Categoria categoria = Categoria.PART_TIME;

	

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

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

		

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

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

	
		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		this.tiendaDeCalzado.calcularElSueldoDeEmpleado(empleado);

		this.tiendaDeCalzado.aplicarComisionCorrespondienteAlEmpleado(empleado);

		Double sueldoDeEmpleado = this.tiendaDeCalzado.devolverSueldoDeEmpleado(empleado);

		assertEquals(31980.0, sueldoDeEmpleado, 0.01);

	}

	@org.junit.Test
	public void queSePuedaAgregarEmpleadoATienda() {
		String nombre = "Empleado";
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
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
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
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
		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINADO;
		Integer legajo = 1111;
		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
		Integer antiguedad = 20;
		Categoria categoria = Categoria.FULL_TIME;

		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
				categoria);

		Empleado empleadoEncontrado = this.tiendaDeCalzado.buscarEmpleado(empleado);

	}

	
	@org.junit.Test
	public void queNoSePuedaVenderMasDelStock() {
		Cliente cliente = new Cliente("Ana", 342, 42, Genero.FEMENINO, ModoDePago.EFECTIVO);
		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
				TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
	    Calzado calzado = new Botin(1, 42, "Negro", Genero.MASCULINO, 50.0, Marca.NIKE, TipoSuperficie.SUELO_FIRME);
	 
	    tiendaDeCalzado.agregarCalzado(calzado, 5);
	    Boolean ventaExitosa = tiendaDeCalzado.venderCalzado(cliente, calzado, 6, empleado);
	    
	    assertFalse(ventaExitosa);
	    assertEquals(5, tiendaDeCalzado.obtenerCantidadDeParesTotalesDeLaTienda().intValue());
	}
	
	@org.junit.Test
	public void obtenerListaDeClientesDeEmpleadoOrdenadoPorParametro() {
		Calzado calzado = new Botin(1, 42, "Negro", Genero.MASCULINO, 50.0, Marca.NIKE, TipoSuperficie.SUELO_FIRME);
		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
				TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
	    Cliente cliente1 = new Cliente("Ana", 342, 42, Genero.FEMENINO, ModoDePago.EFECTIVO);
	    Cliente cliente2 = new Cliente("Maria", 342, 42, Genero.X, ModoDePago.DEBITO);
	    Cliente cliente3 = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.CREDITO);
	    
	    this.tiendaDeCalzado.agregarCalzado(calzado, 10);

	    tiendaDeCalzado.venderCalzado(cliente1, calzado, 1, empleado);
	    tiendaDeCalzado.venderCalzado(cliente2, calzado, 2, empleado);
	    tiendaDeCalzado.venderCalzado(cliente3, calzado, 1, empleado);
	    
	    List<Cliente> clientesOrdenados = tiendaDeCalzado.obtenerClientesOrdenadosPorNombre(empleado);

	    assertEquals(cliente1, clientesOrdenados.get(0));
	    assertEquals(cliente3, clientesOrdenados.get(1));
	    assertEquals(cliente2, clientesOrdenados.get(2));
	}
	
	@org.junit.Test
	public void asignarCalzadosAUnCliente() {
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
 
		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
				TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
 
		this.tiendaDeCalzado.agregarEmpleado(empleado);
 
		Integer cantidadAVender = 2;
 
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoDos, cantidadAVender, empleado);
		this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, cantidadAVender, empleado);
 
		List<Calzado> calzadosDeClientes = this.tiendaDeCalzado.obtenerlistaDeCalzadosDeCliente(cliente);
		int i = 0;
		for (Calzado c : calzadosDeClientes) {
 
			switch (i) {
			case 0:
				assertEquals(calzadoUno, c);
				break;
			case 1:
				assertEquals(calzadoDos, c);
				break;
			case 2:
				assertEquals(calzadoTres, c);
				break;
			default:
				break;
			}
			i++;
		}
 
	}
	
	@org.junit.Test
	public void calcularElTotalGastadoPorCadaCliente() {
		//sumar total sobre precios de List calzadosComprados
		Calzado calzadoBotin = crearBotin(4444, 39, "negro", Genero.MASCULINO, 120000.0, Marca.ADIDAS, TipoSuperficie.TERRENO_ARTIFICIAL);
        Calzado calzadoRunning = crearRunning(3333, 42, "azul", Genero.MASCULINO, 90000.0, Marca.JOHN_FOOS, TipoDePisada.PISADA_PRONADORA);
        
        Cliente clienteCompras = new Cliente("matias", 40343987, 39, Genero.MASCULINO, ModoDePago.DEBITO);
        
        clienteCompras.añadirCalzado(calzadoBotin);
        clienteCompras.añadirCalzado(calzadoRunning);
        clienteCompras.añadirCalzado(calzadoBotin); // compra 2 pares

        double totalEsperado = calzadoBotin.getPrecio() + calzadoRunning.getPrecio() + calzadoBotin.getPrecio();
        double totalCalculado = clienteCompras.calcularTotalGastado();

        assertEquals(totalEsperado, totalCalculado, 0.01);
	}

	
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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
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

		
		assertEquals(3, this.tiendaDeCalzado.getCalzados().size());
		assertEquals(4, (int) calzadoUno.getStock());

		
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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
				TipoDeEmpleado.VENTA_SALON, 20, Categoria.FULL_TIME);

		this.tiendaDeCalzado.agregarEmpleado(empleado);

		Boolean seVendioCalzadoUno = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 2, empleado);
		Boolean seVendioCalzadoDos = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 1, empleado);
		Boolean seVendioCalzadoTres = this.tiendaDeCalzado.venderCalzado(cliente, calzadoTres, 3, empleado);

		assertTrue(seVendioCalzadoUno);
		assertTrue(seVendioCalzadoDos);
		assertTrue(seVendioCalzadoTres);


	}

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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
				TipoDeEmpleado.VENTA_SALON, 20, Categoria.FULL_TIME);
		Empleado empleado2 = new Empleado("non", TipoContrato.TIEMPO_INDETERMINADO, 234, TipoDeEmpleado.VENTA_SALON,
				23, Categoria.FULL_TIME);

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

		Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 11113,
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
	
	
	
	//SHOESHOP
	//INTEGRANTES
		// Elias Tucci
		// Kevin Rotela
		// Alexis Heredia
		// Gustavo Cristaldo
		// Fatima Florio

}
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
//
//		Integer idCalzado = 1;
//		Integer talle = 36;
//		Integer stock = 10;
//		String color = "Negro";
//		Genero genero = Genero.MASCULINO;
//		Double precio = 20.0;
//
//		Marca marca = Marca.TOPPER;
//
//		TipoSuperficie tipoSuperficie = TipoSuperficie.INTERIOR;
//		Calzado calzado = new Botin(idCalzado, talle, color, genero, precio, marca, tipoSuperficie);
//
//		// Agregar calzado a local
//
//		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado);
//
//		assertTrue(calzadoAgregado);

	}

	@org.junit.Test
	public void queSePuedaAñadirUnCalzadoRunningALaTienda() {
//
//		Integer idCalzado = 1;
//		Integer talle = 36;
//		Integer stock = 10;
//		String color = "Negro";
//		Genero genero = Genero.MASCULINO;
//		Double precio = 20.0;
//		Marca marca = Marca.TOPPER;
//
//		TipoDePisada tipoPisada = TipoDePisada.PISADA_NEUTRA;
//		Calzado running = new Running(idCalzado, talle, color, genero, precio, marca, tipoPisada);
//
//		// Agregar calzado a local
//
//		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(running);
//
//		assertTrue(calzadoAgregado);

	}

	@org.junit.Test
	public void queSePuedaAñadirUnCalzadoOutDoorALaTienda() {

//		Integer idCalzado = 1;
//		Integer talle = 36;
//		Integer stock = 10;
//		String color = "Negro";
//		Genero genero = Genero.MASCULINO;
//		Double precio = 20.0;
//
//		Marca marca = Marca.TOPPER;
//
//		TipoDeUso tipoDeUso = TipoDeUso.HIKING;
//
//		Calzado outDoor = new OutDoor(idCalzado, talle, color, genero, precio, marca, tipoDeUso);
//
//		// Agregar calzado a local
//
//		Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(outDoor);
//
//		assertTrue(calzadoAgregado);

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
//
//		String nombre = "Empleado";
//		TipoContrato modalidadDeContratacion = TipoContrato.TIEMPO_INDETERMINDADO;
//		Integer legajo = 1111;
//		TipoDeEmpleado tipoDeEmpleado = TipoDeEmpleado.REPOSITOR;
//		Integer antiguedad = 20;
//		Categoria categoria = Categoria.FULL_TIME;
//
//		Empleado empleado = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
//				categoria);
//
//		Empleado empleado1 = new Empleado(nombre, modalidadDeContratacion, legajo, tipoDeEmpleado, antiguedad,
//				categoria);
//
//		assertTrue(empleado.equals(empleado1));
//
	}

	// Alexis
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
	public void calcularComisionDelEmpleado() {
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
		
		//chequeo stock
		int i = 0;

		for (Calzado c : calzados) {
			switch (i) {
			case 0:
				assertEquals((int)cantidadAVender, (int) c.getStock());
				break;
			case 1:
				assertEquals((int)cantidadAVender, (int) c.getStock());
				break;
			case 2:
				assertEquals((int)cantidadAVender, (int) c.getStock());
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
		assertEquals(6, (int) this.tiendaDeCalzado.obtenerCantidadDeParesTotalesDeMiTienda());

	}

	@org.junit.Test
	public void queSePuedaVenderCalzadosACliente() {
		Cliente cliente = new Cliente("Jose", 342, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);

		Calzado calzadoUno = crearBotin(123, 42, "Negro", Genero.MASCULINO, 45000.00, Marca.ADIDAS,
				TipoSuperficie.SUELO_FIRME);
		Calzado calzadoDos = crearOutDoor(12, 42, "Rojo", Genero.MASCULINO, 90000.00, Marca.TOPPER, TipoDeUso.HIKING);
		Calzado calzadoTres = crearRunning(45, 42, "Amarillo", Genero.MASCULINO, 70000.00, Marca.JOHN_FOOS,
				TipoDePisada.PISADA_SUPINADORA);

		Boolean seAgregoCalzadoUno = this.tiendaDeCalzado.agregarCalzado(calzadoUno, 3);
		Boolean seAgregoCalzadoDos = this.tiendaDeCalzado.agregarCalzado(calzadoDos, 3);
		Boolean seAgregoCalzadoTres = this.tiendaDeCalzado.agregarCalzado(calzadoTres, 3);

		Boolean seVendioCalzadoUno = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 2);
		Boolean seVendioCalzadoDos = this.tiendaDeCalzado.venderCalzado(cliente, calzadoUno, 1);

		assertTrue(seVendioCalzadoUno);
		assertTrue(seVendioCalzadoDos);

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

package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;

import ar.edu.unlam.dominio.Botin;
import ar.edu.unlam.dominio.Calzado;
import ar.edu.unlam.dominio.CalzadoInexistenteException;
import ar.edu.unlam.dominio.Categoria;
import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.Contrato;
import ar.edu.unlam.dominio.Empleado;
import ar.edu.unlam.dominio.Genero;
import ar.edu.unlam.dominio.Marca;
import ar.edu.unlam.dominio.ModoDePago;
import ar.edu.unlam.dominio.OrdenarPorMarca;
import ar.edu.unlam.dominio.OutDoor;
import ar.edu.unlam.dominio.Running;
import ar.edu.unlam.dominio.TiendaDeCalzado;
import ar.edu.unlam.dominio.TipoDeEmpleado;
import ar.edu.unlam.dominio.TipoDePisada;
import ar.edu.unlam.dominio.TipoDeUso;
import ar.edu.unlam.dominio.TipoSuperficie;

public class Test {

	private static final String NOMBRE_TIENDA_CALZADO = "El Pichu";
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
		Calzado calzado = generarBotin(idCalzado, talle, stock, color, genero, precio, marca, tipoSuperficie);

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
		Calzado running = generarRunning(idCalzado, talle, stock, color, genero, precio, marca, tipoPisada);

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

		Calzado outDoor = generarOutDoor(idCalzado, talle, stock, color, genero, precio, marca, tipoDeUso);

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

		String nombre = "Pichu";
		Contrato modalidadDeContratacion = Contrato.TIEMPO_INDETERMINDADO;
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
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = generarOutDoor(idCalzado, talle, stock, color, genero, precio, marca, tipoDeUso);

		this.tiendaDeCalzado.agregarCalzado(outDoor);

		Calzado calzadoEncontrado = this.tiendaDeCalzado.buscarCalzadoPorCodigo(idCalzado);

		assertTrue(outDoor.equals(calzadoEncontrado));

	}

	@org.junit.Test(expected = CalzadoInexistenteException.class)
	public void queNoSePuedabuscarCalzadoPorCodigo() throws CalzadoInexistenteException {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = generarOutDoor(idCalzado, talle, stock, color, genero, precio, marca, tipoDeUso);

		Calzado calzadoEncontrado = this.tiendaDeCalzado.buscarCalzadoPorCodigo(idCalzado);

		assertTrue(outDoor.equals(calzadoEncontrado));

	}

	@org.junit.Test
	public void queAlbuscarCalzadoPorCodigoDevuelvaElPrecioDelMismo() throws CalzadoInexistenteException {

		Integer idCalzado = 1;
		Integer talle = 36;
		Integer stock = 10;
		String color = "Negro";
		Genero genero = Genero.MASCULINO;
		Double precio = 20.0;
		Marca marca = Marca.TOPPER;

		TipoDeUso tipoDeUso = TipoDeUso.HIKING;

		Calzado outDoor = generarOutDoor(idCalzado, talle, stock, color, genero, precio, marca, tipoDeUso);

		this.tiendaDeCalzado.agregarCalzado(outDoor);

		Double precioDelCalzadoEncontrado = this.tiendaDeCalzado.devolverPrecioDelCalzado(idCalzado);

		assertEquals(outDoor.getPrecio(), precioDelCalzadoEncontrado);
	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorFullTime() {

		Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.FULL_TIME);

		empleado.calcularElSueldo();

		assertEquals(204167.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoRepositorPartTime() {

		Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.REPOSITOR, 5,
				Categoria.PART_TIME);

		empleado.calcularElSueldo();

		assertEquals(41000.0, empleado.getSueldo(), 0.01);

	}
	

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroFullTime() {

		Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.FULL_TIME);

		empleado.calcularElSueldo();

		assertEquals(424500.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoCajeroPartTime() {

		Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.CAJERO, 5,
				Categoria.PART_TIME);

		empleado.calcularElSueldo();

		assertEquals(53000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaFullTime() {

		Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.VENTA_SALON, 5,
				Categoria.FULL_TIME);

		empleado.calcularElSueldo();

		assertEquals(500000.0, empleado.getSueldo(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaCalcularElSueldoTotalSegunElTipoDeEmpleadoVentaPartTime() {

		Empleado empleado = new Empleado("Jose", Contrato.TIEMPO_INDETERMINDADO, 2000, TipoDeEmpleado.VENTA_SALON, 5,
				Categoria.PART_TIME);

		empleado.calcularElSueldo();

		assertEquals(81000.0, empleado.getSueldo(), 0.01);

	}
	
	
	

	private Running generarRunning(Integer idCalzado, Integer talle, Integer stock, String color, Genero genero,
			Double precio, Marca marca, TipoDePisada tipoPisada) {
		return new Running(idCalzado, talle, stock, color, genero, precio, marca, tipoPisada);
	}

	private OutDoor generarOutDoor(Integer idCalzado, Integer talle, Integer stock, String color, Genero genero,
			Double precio, Marca marca, TipoDeUso tipoDeUso) {
		return new OutDoor(idCalzado, talle, stock, color, genero, precio, marca, tipoDeUso);
	}

	private Botin generarBotin(Integer idCalzado, Integer talle, Integer stock, String color, Genero genero,
			Double precio, Marca marca, TipoSuperficie tipoSuperficie) {
		return new Botin(idCalzado, talle, stock, color, genero, precio, marca, tipoSuperficie);
	}

}

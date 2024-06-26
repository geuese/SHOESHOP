package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.enums.Categoria;
import ar.edu.unlam.enums.TipoDeEmpleado;

public class TiendaDeCalzado implements ITiendaDeCalzado {
	private String nombreLocal;

	private Set<Calzado> calzados;
	private Set<Empleado> empleados;
	private List<ClienteCalzado> clientesCalzados;

	private Set<EmpleadoCliente> empleadosClientes;

	public TiendaDeCalzado(String nombreLocal) {
		// TODO Auto-generated constructor stub

		this.nombreLocal = nombreLocal;
		this.calzados = new TreeSet<>();
		this.empleados = new HashSet<>();
		this.clientesCalzados = new ArrayList<>();
		this.empleadosClientes = new HashSet<>();

	}

	public Set<Calzado> getCalzados() {
		return this.calzados;
	}

	@Override
	public List<Calzado> obtenerTodosLosRunning() {

		List<Calzado> calzadosRunning = new ArrayList<>();

		for (Calzado calzado : calzados) {
			if (calzado instanceof Running) {
				calzadosRunning.add((Running) calzado);
			}
		}
		return calzadosRunning;

	}

	@Override
	public List<Calzado> obtenerTodosLosOutDoor() {
		List<Calzado> calzadosOutDoor = new ArrayList<>();

		for (Calzado calzado : calzados) {
			if (calzado instanceof OutDoor) {
				calzadosOutDoor.add((OutDoor) calzado);
			}
		}
		return calzadosOutDoor;
	}

	@Override
	public List<Calzado> obtenerTodosLosBotines() {

		List<Calzado> calzadosBotin = new ArrayList<>();

		for (Calzado calzado : calzados) {
			if (calzado instanceof Botin) {
				calzadosBotin.add((Botin) calzado);
			}
		}
		return calzadosBotin;

	}

	@Override
	public Integer calcularComisionEmpleado(Empleado empleadoBuscado) {
		Integer comision = 0;

		for (Empleado empleado : this.empleados) {
			if (empleado.getLegajo().equals(empleadoBuscado.getLegajo())) {
				switch (empleado.getTipoContrato()) {
				case PRUEBA:
					comision = empleado.getAntiguedad() * 2;
					break;
				case PASANTIA:
					comision = empleado.getAntiguedad() * 4;
					break;
				case TIEMPO_INDETERMINADO:
					comision = empleado.getAntiguedad() * 6;
					break;
				}

			}
			switch (empleado.getCategoria()) {
			case FULL_TIME:
				comision *= 9;
				break;
			case PART_TIME:
				comision *= 7;
				break;
			}
		}

		return comision;

	}

	@Override
	public Calzado buscarCalzadoPorCodigo(Integer idCalzado) throws CalzadoInexistenteException {

		for (Calzado calzado : this.calzados) {

			if (calzado.getIdCalzado().equals(idCalzado)) {
				return calzado;
			}
		}

		throw new CalzadoInexistenteException("Calzado Inexistente");

	}

	@Override
	public Double devolverPrecioDelCalzado(Integer idCalzado) throws CalzadoInexistenteException {
		// TODO Auto-generated method stub

		Calzado calzadoHallado = buscarCalzadoPorCodigo(idCalzado);

		if (calzadoHallado != null) {
			return calzadoHallado.getPrecio();
		}
		throw new CalzadoInexistenteException("Calzado Inexistente");

	}

	@Override
	public List<Calzado> ordenarBotinesPorTalleDeManeraAscendente() {

		List<Calzado> botines = obtenerTodosLosBotines();

		ordenarDeManeraAscendente(botines);

		return botines;

	}

	@Override
	public List<Calzado> ordenarOutDoorsPorTalleDeManeraAscendente() {
		// TODO Auto-generated method stub
		List<Calzado> outDoors = obtenerTodosLosOutDoor();

		ordenarDeManeraAscendente(outDoors);

		return outDoors;

	}

	@Override
	public List<Calzado> ordenarRunningsPorTalleDeManeraAscendente() {
		// TODO Auto-generated method stub
		List<Calzado> runnings = obtenerTodosLosRunning();

		ordenarDeManeraAscendente(runnings);

		return runnings;

	}

	private void ordenarDeManeraAscendente(List<Calzado> calzados) {
		Collections.sort(calzados, (o1, o2) -> o1.getTalle().compareTo(o2.getTalle()));
	}

// elias
	@Override
	public Boolean agregarEmpleado(Empleado empleado) {

		return this.empleados.add(empleado);

	}

	public void calcularElSueldoDeEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException {

		Empleado empleadoEncontrado = buscarEmpleado(empleado);

		TipoDeEmpleado tipoDeEmpleadoACalcular = empleadoEncontrado.getTipoDeEmpleado();

		switch (tipoDeEmpleadoACalcular) {

		case CAJERO:
			sueldoCajero(empleadoEncontrado);
			break;

		case REPOSITOR:
			sueldoRepositor(empleadoEncontrado);
			break;

		case VENTA_SALON:
			sueldoVenta(empleadoEncontrado);
			break;

		}

	}

	@Override
	public Empleado buscarEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException {
		// TODO Auto-generated method stu

		for (Empleado empleadoAux : this.empleados) {
			if (empleadoAux.equals(empleado)) {
				return empleadoAux;
			}

		}

		throw new EmpleadoNoEncontradoException();
	}

	private Double sueldoCajero(Empleado empleado) {

		Double sueldoAux = 0.0;

		if (empleado.getCategoria().equals(Categoria.PART_TIME)) {
			sueldoAux = 53000.0;
		} else {
			sueldoAux = 424500.0;

		}

		calcularSegunContrato(sueldoAux, empleado);

		return sueldoAux;

	}

	private Double sueldoRepositor(Empleado empleado) {

		Double sueldoAux = 0.0;

		if (empleado.getCategoria().equals(Categoria.PART_TIME)) {
			sueldoAux = 41000.0;
		} else {
			sueldoAux = 204167.0;

		}
		calcularSegunContrato(sueldoAux, empleado);

		return sueldoAux;

	}

	private Double sueldoVenta(Empleado empleado) {

		Double sueldoAux = 0.0;

		if (empleado.getCategoria().equals(Categoria.PART_TIME)) {
			sueldoAux = 81000.0;
		} else {
			sueldoAux = 500000.0;

		}

		calcularSegunContrato(sueldoAux, empleado);
		return sueldoAux;

	}

	private void calcularSegunContrato(Double sueldoAux, Empleado empleado) {

		Double sueldoEmpleado = 0.0;
		switch (empleado.getModalidadDeContratacion()) {
		case PASANTIA:
			sueldoEmpleado = sueldoAux * 0.50;
			empleado.setSueldo(sueldoEmpleado);
			break;

		case PRUEBA:
			sueldoEmpleado = sueldoAux * 0.30;
			empleado.setSueldo(sueldoEmpleado);
			break;
		default:
			sueldoEmpleado = sueldoAux;
			empleado.setSueldo(sueldoEmpleado);
			break;
		}
	}

	@Override
	public Integer devolverCantidadDeCalzadosEnLaTienda() {
		// TODO Auto-generated method stub
		return this.calzados.size();
	}

	@Override
	public Double devolverSueldoDeEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException {
		Empleado empleadoBuscado = buscarEmpleado(empleado);

		if (empleadoBuscado != null) {
			return empleadoBuscado.getSueldo();

		}

		throw new EmpleadoNoEncontradoException();
	}

	@Override
	public void aplicarComisionCorrespondienteAlEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException {

		Empleado empleadoBuscado = buscarEmpleado(empleado);

		if (empleadoBuscado != null) {
			Double sueldoEmpleado = devolverSueldoDeEmpleado(empleadoBuscado);
			Double comisionEmpleado = (double) calcularComisionEmpleado(empleadoBuscado);
			Double sueldoMasComision = sueldoEmpleado + sueldoEmpleado * (comisionEmpleado / 100);

			empleadoBuscado.setSueldo(sueldoMasComision);

		}

	}

	@Override
	public List<Cliente> obtenerListaDeClientesDeEmpleado(Empleado empleado) {

		List<Cliente> clientesDeEmpleado = new ArrayList<Cliente>();
		for (EmpleadoCliente ec : empleadosClientes) {
			if (ec.getEmpleado().equals(empleado)) {
				clientesDeEmpleado.add(ec.getCliente());
			}
		}
		return clientesDeEmpleado;
	}

	@Override
	public List<Cliente> obtenerClientesOrdenadosPorNombre(Empleado empleado) {
		List<Cliente> clientesDeEmpleado = obtenerListaDeClientesDeEmpleado(empleado);
		Collections.sort(clientesDeEmpleado, Comparator.comparing(Cliente::getNombre));
		return clientesDeEmpleado;
	}

	@Override
	public Integer obtenerTotalDeVentasTotalesDeEmpleado(Empleado empleado) {
		int cantidadDeVentas = 0;
		for (EmpleadoCliente ec : empleadosClientes) {
			if (ec.getEmpleado().equals(empleado)) {
				cantidadDeVentas += ec.getCantidadVendida();
			}
		}
		return cantidadDeVentas;
	}

	@Override
	public Boolean agregarCalzado(Calzado calzado, Integer cantidadDeCalzados) {
		for (Calzado c : calzados) {
			if (c.getID().equals(calzado.getID())) {
				c.incrementarStock(cantidadDeCalzados);
				return true;
			}
		}

		Calzado calzadoNuevo = calzado;
		calzadoNuevo.setStock(cantidadDeCalzados);
		calzados.add(calzadoNuevo);
		return true;
	}

	@Override
	public Boolean venderCalzado(Cliente cliente, Calzado calzado, Integer cantidadAVender, Empleado empleado) {

		for (Calzado c : calzados) {
			if (c.getID().equals(calzado.getID())) {
				if (c.getStock() < cantidadAVender) {
					return false;
				}
				c.reducirStock(cantidadAVender);

				Boolean clienteCalzadoEncontrado = false;

				for (ClienteCalzado cc : clientesCalzados) {
					if (cc.getCliente().getDni().equals(cliente.getDni())
							&& cc.getCalzado().getID().equals(calzado.getID())) {
						cc.incrementarCantidadDeCalzadosDeClienteCalzado(cantidadAVender);
						clienteCalzadoEncontrado = true;
						break;
					}
				}

				if (!clienteCalzadoEncontrado) {
					ClienteCalzado nuevoClienteCalzado = crearClienteCalzado(cliente, calzado, cantidadAVender);
					this.clientesCalzados.add(nuevoClienteCalzado);
				}

				for (EmpleadoCliente ec : empleadosClientes) {
					if (ec.getEmpleado().equals(empleado) && ec.getCliente().equals(cliente)) {
						ec.incrementarCantidadAVender(cantidadAVender);
					}
				}
				EmpleadoCliente nuevoEmpleadoCliente = crearEmpleadoCliente(empleado, cliente, cantidadAVender);
				this.empleadosClientes.add(nuevoEmpleadoCliente);

				return true;

			}

		}
		return false;
	}

	private EmpleadoCliente crearEmpleadoCliente(Empleado empleado, Cliente cliente, Integer cantidadAComprar) {
		return new EmpleadoCliente(empleado, cliente, cantidadAComprar);
	}

	@Override
	public ClienteCalzado crearClienteCalzado(Cliente cliente, Calzado calzado, Integer cantidadAComprar) {
		return new ClienteCalzado(cliente, calzado, cantidadAComprar);
	}

	@Override
	public Integer obtenerCantidadDeParesTotalesDeLaTienda() {
		int cantidadTotalDeZapatos = 0;
		for (Calzado c : calzados) {
			if (c != null) {
				cantidadTotalDeZapatos += c.getStock();
			}
		}
		return cantidadTotalDeZapatos;
	}

	@Override
	public List<Calzado> obtenerlistaDeCalzadosDeCliente(Cliente cliente) {
		List<Calzado> calzadosDeCliente = new ArrayList<Calzado>();
		for (ClienteCalzado cc : clientesCalzados) {
			if (cc.getCliente().getDni().equals(cliente.getDni())) {
				calzadosDeCliente.add(cc.getCalzado());
			}
		}
		return calzadosDeCliente;
	}

	@Override
	public List<Calzado> obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(Cliente cliente) {
		List<Calzado> calzadosDeCliente = new ArrayList<Calzado>();
		for (ClienteCalzado cc : clientesCalzados) {
			if (cc != null && cc.getCliente().getDni().equals(cliente.getDni())) {
				calzadosDeCliente.add(cc.getCalzado());
			}
		}
		Collections.sort(calzadosDeCliente, (o1, o2) -> o2.getPrecio().compareTo(o1.getPrecio()));
		return calzadosDeCliente;
	}

	@Override
	public TreeSet<Calzado> obtenerlistaDeZapatosDeClienteOrdenadosPorOrdenEspecifico(
			Comparator<Calzado> OrdenEspecifico, Cliente cliente) {

		TreeSet<Calzado> calzadosDeCliente = new TreeSet<Calzado>(OrdenEspecifico);
		List<Calzado> calzados = obtenerlistaDeCalzadosDeCliente(cliente);

		calzadosDeCliente.addAll(calzados);

		return calzadosDeCliente;
	}

	public List<ClienteCalzado> getClientesCalzados() {
		return this.clientesCalzados;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

}

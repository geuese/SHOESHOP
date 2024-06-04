package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TiendaDeCalzado implements ITiendaDeCalzado {
	private String nombreLocal;

	private Set<Calzado> calzados;
	private List<Empleado> empleados;
	private List<ClienteCalzado> clientesCalzados;

	private Set<EmpleadoCliente> empleadosClientes;

	public TiendaDeCalzado(String nombreLocal) {
		// TODO Auto-generated constructor stub

		this.nombreLocal = nombreLocal;
		this.calzados = new TreeSet<>();
		this.empleados = new ArrayList<>();
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

	public List<Calzado> obtenerTodosLosOutDoor() {
		List<Calzado> calzadosOutDoor = new ArrayList<>();

		for (Calzado calzado : calzados) {
			if (calzado instanceof OutDoor) {
				calzadosOutDoor.add((OutDoor) calzado);
			}
		}
		return calzadosOutDoor;
	}

	public List<Calzado> obtenerTodosLosBotin() {

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
				case TIEMPO_INDETERMINDADO:
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


	public Calzado buscarCalzadoPorCodigo(Integer idCalzado) throws CalzadoInexistenteException {

		for (Calzado calzado : this.calzados) {

			if (calzado.getIdCalzado().equals(idCalzado)) {
				return calzado;
			}
		}

		throw new CalzadoInexistenteException("Calzado Inexistente");

	}

	public Double devolverPrecioDelCalzado(Integer idCalzado) throws CalzadoInexistenteException {
		// TODO Auto-generated method stub

		Calzado calzadoHallado = buscarCalzadoPorCodigo(idCalzado);

		if (calzadoHallado != null) {
			return calzadoHallado.getPrecio();
		}
		throw new CalzadoInexistenteException("Calzado Inexistente");

	}

	public List<Calzado> ordenarTipoDeCalzadoPorTalle() {
		return null;

	}

	@Override
	public List<Calzado> ordenarBotinesPorTalleDeManeraAscendente() {

		List<Calzado> botines = obtenerTodosLosBotin();

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
				return true; // Se encontro el calzado, se actualizo el stock y se retorna true.
			}
		}
		// Si se recorrio toda la lista y no se encontro el calzado, se agrega uno
		// nuevo.
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
					return false; // no hay suficiente stock
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

	public List<ClienteCalzado> getClientesCalzados() {
		return this.clientesCalzados;
	}
}

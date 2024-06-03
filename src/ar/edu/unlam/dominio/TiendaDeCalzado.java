package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unalm.enums.Categoria;
import ar.edu.unalm.enums.TipoDeEmpleado;

public class TiendaDeCalzado implements ITiendaDeCalzado {
	private String nombreLocal;

	private Set<Calzado> calzados;
	private List<Empleado> empleados;
	private List<ClienteCalzado> clientesCalzados;

	public TiendaDeCalzado(String nombreLocal) {
		// TODO Auto-generated constructor stub

		this.nombreLocal = nombreLocal;
		this.calzados = new TreeSet<>();
		this.empleados = new ArrayList<>();
		this.clientesCalzados = new ArrayList<>();

	}

//	public Boolean agregarCalzado(Calzado calzado) {
//		return calzados.add(calzado);
//	}
//	// Si se recorrio toda la lista y no se encontro el calzado, se agrega uno
//	// nuevo.

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
		calzado.setStock(cantidadDeCalzados);
		calzados.add(calzado);
		return true;
	}

	@Override
	public Boolean venderCalzado(Cliente cliente, Calzado calzado, Integer cantidadAVender) {

		for (Calzado c : calzados) {
			if (c.getID().equals(calzado.getID()) && c.getStock() >= cantidadAVender) {
				c.reducirStock(cantidadAVender);

				Boolean clienteCalzadoEncontrado = false;

				for (ClienteCalzado cc : clientesCalzados) {
					if (cc != (null) && cc.getCliente().getDni().equals(cliente.getDni())
							&& cc.getCalzado().getID().equals(calzado.getID())) {
						cc.getCalzado().incrementarStock(cantidadAVender);
						clienteCalzadoEncontrado = true;
						break;
					}
				}

				if (!clienteCalzadoEncontrado) {
					ClienteCalzado nuevoClienteCalzado = crearClienteCalzado(cliente, calzado, cantidadAVender);
					this.clientesCalzados.add(nuevoClienteCalzado);
				}

				return true;

			}
		}
		return false;
	}

	@Override
	public ClienteCalzado crearClienteCalzado(Cliente cliente, Calzado calzado, Integer cantidadAComprar) {
		return new ClienteCalzado(cliente, calzado, cantidadAComprar);
	}

	@Override
	public List<Calzado> obtenerlistaDeZapatosDeCliente(Cliente cliente) {
		List<Calzado> calzadosDeCliente = new ArrayList<Calzado>();
		for (ClienteCalzado cc : clientesCalzados) {
			if (cc.getCliente().getDni().equals(cliente.getDni())) {
				calzadosDeCliente.add(cc.getCalzado());
			}
		}
		return calzadosDeCliente;
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

	@Override
	public Boolean agregarEmpleado(Empleado empleado) {

		return this.empleados.add(empleado);

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

	@Override
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

}

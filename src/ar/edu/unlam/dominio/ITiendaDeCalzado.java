package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface ITiendaDeCalzado {
	Boolean agregarCalzado(Calzado calzado, Integer cantidadDeCalzados);

	Calzado buscarCalzadoPorCodigo(Integer idCalzado) throws CalzadoInexistenteException;

	Double devolverPrecioDelCalzado(Integer idCalzado) throws CalzadoInexistenteException;

	List<Calzado> ordenarBotinesPorTalleDeManeraAscendente();

	List<Calzado> ordenarOutDoorsPorTalleDeManeraAscendente();

	List<Calzado> ordenarRunningsPorTalleDeManeraAscendente();

	Boolean agregarEmpleado(Empleado empleado);

	ClienteCalzado crearClienteCalzado(Cliente cliente, Calzado calzado, Integer cantidadAComprar);

	List<Calzado> obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(Cliente cliente);

	Integer obtenerCantidadDeParesTotalesDeLaTienda();

	List<Calzado> obtenerTodosLosRunning();

	List<Calzado> obtenerTodosLosOutDoor();

	List<Calzado> obtenerTodosLosBotines();

	void calcularElSueldoDeEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException;

	Empleado buscarEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException;

	Integer calcularComisionEmpleado(Empleado empleadoBuscado) throws EmpleadoNoEncontradoException;

	Integer devolverCantidadDeCalzadosEnLaTienda();

	void aplicarComisionCorrespondienteAlEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException;

	Double devolverSueldoDeEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException;

	TreeSet<Calzado> obtenerlistaDeZapatosDeClienteOrdenadosPorOrdenEspecifico(Comparator<Calzado> OrdenEspecifico,
			Cliente cliente);

	Integer obtenerTotalDeVentasTotalesDeEmpleado(Empleado empleado);

	Boolean venderCalzado(Cliente cliente, Calzado calzado, Integer cantidadAVender, Empleado empleado);

	List<Calzado> obtenerlistaDeCalzadosDeCliente(Cliente cliente);

	List<Cliente> obtenerListaDeClientesDeEmpleado(Empleado empleado);

	List<Cliente> obtenerClientesOrdenadosPorNombre(Empleado empleado);

}

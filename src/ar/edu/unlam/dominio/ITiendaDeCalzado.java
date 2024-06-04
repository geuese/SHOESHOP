package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
	List<Calzado> obtenerlistaDeCalzadosDeCliente(Cliente cliente);
	List<Calzado> obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(Cliente cliente);
	Integer obtenerCantidadDeParesTotalesDeLaTienda();
	List<Calzado> obtenerTodosLosRunning();
	List<Calzado> obtenerTodosLosOutDoor(); 
	Boolean venderCalzado(Cliente cliente, Calzado calzado, Integer cantidadAVender, Empleado empleado);
	Integer obtenerTotalDeVentasTotalesDeEmpleado(Empleado empleado);
	Integer calcularComisionEmpleado(Empleado empleadoBuscado); 

}
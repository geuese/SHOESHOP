package ar.edu.unlam.dominio;

import java.util.List;

public interface ITiendaDeCalzado {

	Boolean agregarCalzado(Calzado calzado, Integer cantidadDeCalzados);

	Boolean venderCalzado(Cliente cliente, Calzado calzado, Integer cantidad);

	ClienteCalzado crearClienteCalzado(Cliente cliente, Calzado calzado, Integer cantidadAComprar);

	List<Calzado> obtenerlistaDeZapatosDeCliente(Cliente cliente);

	List<Calzado> obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(Cliente cliente);

	Integer obtenerCantidadDeParesTotalesDeLaTienda();

}

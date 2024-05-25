package ar.edu.unlam.dominio;

import java.util.List;

public interface ITiendaDeCalzado {
	Boolean agregarCalzado(Calzado calzado);
	Calzado buscarCalzadoPorCodigo(Integer idCalzado) throws CalzadoInexistenteException;
	Double devolverPrecioDelCalzado(Integer idCalzado) throws CalzadoInexistenteException;
	List<Calzado> obtenerListaDeBotines();
	List<Calzado> obtenerListaDeRunnings();
	List<Calzado> obtenerListaDeOutDoors();
	

}

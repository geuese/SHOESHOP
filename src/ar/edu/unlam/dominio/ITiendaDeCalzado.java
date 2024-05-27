package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public interface ITiendaDeCalzado {
	Boolean agregarCalzado(Calzado calzado);
	Calzado buscarCalzadoPorCodigo(Integer idCalzado) throws CalzadoInexistenteException;
	Double devolverPrecioDelCalzado(Integer idCalzado) throws CalzadoInexistenteException;
	List<Calzado> obtenerListaDeBotines();
	List<Calzado> obtenerListaDeRunnings();
	List<Calzado> obtenerListaDeOutDoors();

}

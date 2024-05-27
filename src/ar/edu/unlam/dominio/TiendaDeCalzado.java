package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TiendaDeCalzado implements ITiendaDeCalzado {
	private String nombreLocal;

	private List<Calzado> calzados;

	public TiendaDeCalzado(String nombreLocal) {
		// TODO Auto-generated constructor stub

		this.nombreLocal = nombreLocal;
		this.calzados = new ArrayList<>();

	}

	public Boolean agregarCalzado(Calzado calzado) {
		// TODO Auto-generated method stub
		return this.calzados.add(calzado);
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

	public List<Calzado> obtenerListaDeBotines() {
		// TODO Auto-generated method stub

		return null;

	}

	@Override
	public List<Calzado> obtenerListaDeRunnings() {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Calzado> obtenerListaDeOutDoors() {
		// TODO Auto-generated method stub
		return null;

	}

	

}

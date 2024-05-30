package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TiendaDeCalzado implements ITiendaDeCalzado {
	private String nombreLocal;

	private Set<Calzado> calzados;
	private Set<Empleado> empleados;

	public TiendaDeCalzado(String nombreLocal) {
		// TODO Auto-generated constructor stub

		this.nombreLocal = nombreLocal;
		this.calzados = new TreeSet<>();
		this.empleados = new TreeSet<>();

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

	@Override
	public List<Calzado> ordenarBotinesPorTalleDeManeraAscendente() {

		List<Calzado> botines = new ArrayList<>();

		for (Calzado calzado : this.calzados) {
			if (calzado instanceof Botin) {
				botines.add(calzado);
			}

		}

		ordenarDeManeraAscendente(botines);

		return botines;

	}

	@Override
	public List<Calzado> ordenarOutDoorsPorTalleDeManeraAscendente() {
		// TODO Auto-generated method stub
		List<Calzado> outDoors = new ArrayList<>();

		for (Calzado calzado : this.calzados) {
			if (calzado instanceof OutDoor) {
				outDoors.add(calzado);
			}

		}

		ordenarDeManeraAscendente(outDoors);

		return outDoors;

	}

	@Override
	public List<Calzado> ordenarRunningsPorTalleDeManeraAscendente() {
		// TODO Auto-generated method stub
		List<Calzado> runnings = new ArrayList<>();

		for (Calzado calzado : this.calzados) {
			if (calzado instanceof Running) {
				runnings.add(calzado);
			}

		}

		ordenarDeManeraAscendente(runnings);

		return runnings;

	}

	private void ordenarDeManeraAscendente(List<Calzado> calzados) {
		Collections.sort(calzados, (o1, o2) -> o1.getTalle().compareTo(o2.getTalle()));
	}

}

package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class TiendaDeCalzado {
	private String nombreTienda;

	private List<Calzado> calzados;

	public TiendaDeCalzado(String nombreTienda) {
		this.nombreTienda = nombreTienda;
		this.calzados = new ArrayList<>();
	}

	public Boolean agregarCalzado(Calzado calzado) {
		return this.calzados.add(calzado);
	}

}

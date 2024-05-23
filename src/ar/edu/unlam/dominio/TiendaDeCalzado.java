package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class TiendaDeCalzado {
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

}

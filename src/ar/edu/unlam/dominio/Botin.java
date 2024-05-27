package ar.edu.unlam.dominio;

import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;
import ar.edu.unalm.enums.TipoSuperficie;

public class Botin extends Calzado {

	private TipoSuperficie tipoSuperficie;

	public Botin(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoSuperficie tipoSuperficie) {
		super(idCalzado, talle, color, genero, precio, marca);
		this.tipoSuperficie = tipoSuperficie;
	}
}

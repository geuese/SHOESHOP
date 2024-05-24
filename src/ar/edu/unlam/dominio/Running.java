package ar.edu.unlam.dominio;

import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;
import ar.edu.unalm.enums.TipoDePisada;

public class Running extends Calzado {

	private TipoDePisada tipoDePisada;

	public Running(Integer idCalzado, Integer talle, Integer stock, String color, Genero genero, Double precio,
			Marca marca, TipoDePisada tipoPisada) {
		super(idCalzado, talle, stock, color, genero, precio, marca);

		this.tipoDePisada = tipoPisada;
	}

}

package ar.edu.unlam.dominio;

import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;

public class Calzado {

	private Integer idCalzado;
	private Integer talle;
	private Integer stock;
	private String color;
	private Genero genero;
	private Double precio;
	private Marca marca;

	public Calzado(Integer idCalzado, Integer talle, Integer stock, String color, Genero genero, Double precio,
			Marca marca) {
		this.idCalzado = idCalzado;
		this.talle = talle;
		this.stock = stock;
		this.color = color;
		this.genero = genero;
		this.precio = precio;
		this.marca = marca;
	}

}

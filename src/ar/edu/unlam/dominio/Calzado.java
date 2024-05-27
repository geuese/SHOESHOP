package ar.edu.unlam.dominio;

import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;

public class Calzado {

	private final Integer ID;
	private Integer talle;
	private String color;
	private Genero genero;
	private Double precio;
	private Marca marca;
	private Integer stock;

	public Calzado(Integer id, Integer talle, String color, Genero genero, Double precio, Marca marca) {

		this.ID = id;
		this.talle = talle;
		this.color = color;
		this.genero = genero;
		this.precio = precio;
		this.marca = marca;
		this.stock=0;
	}

	public Integer getID() {
		return this.ID;
	}

	public void setStock(Integer cantidadDeCalzados) {
		this.stock = cantidadDeCalzados;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void reducirStock(Integer cantidadAVender) {
		this.stock -= cantidadAVender;
	}

	public void incrementarStock(Integer cantidadDeCalzados) {
		this.stock += cantidadDeCalzados;
	}

}

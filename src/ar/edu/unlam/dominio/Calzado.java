package ar.edu.unlam.dominio;

import java.util.Objects;

import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;

public abstract class Calzado implements Comparable<Calzado> {

	protected Integer idCalzado;
	protected Integer talle;
	protected String color;
	protected Genero genero;
	protected Double precio;
	protected Marca marca;
	protected Integer stock;

	public Calzado(Integer id, Integer talle, String color, Genero genero, Double precio, Marca marca) {

		this.idCalzado = id;
		this.talle = talle;
		this.color = color;
		this.genero = genero;
		this.precio = precio;
		this.marca = marca;
		this.stock = 0;
	}

	public Integer getID() {
		return this.idCalzado;
	}

	


	public Integer getIdCalzado() {
		return idCalzado;
	}

	public void setIdCalzado(Integer idCalzado) {
		this.idCalzado = idCalzado;
	}

	public Integer getTalle() {
		return talle;
	}

	public void setTalle(Integer talle) {
		this.talle = talle;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, genero, idCalzado, marca, precio, stock, talle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calzado other = (Calzado) obj;
		return Objects.equals(color, other.color) && genero == other.genero
				&& Objects.equals(idCalzado, other.idCalzado) && marca == other.marca
				&& Objects.equals(precio, other.precio) && Objects.equals(stock, other.stock)
				&& Objects.equals(talle, other.talle);
	}

	@Override
	public int compareTo(Calzado o) {
		return this.idCalzado.compareTo(o.getIdCalzado());
	}

	
	public abstract void reducirStock(Integer cantidadAVender);
	
	public abstract void incrementarStock(Integer cantidadDeCalzados);

}

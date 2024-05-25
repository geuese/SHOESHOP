package ar.edu.unlam.dominio;

import java.util.Objects;

public abstract class Calzado {
	
	private Integer idCalzado;
	private Integer talle;
	private Integer stock;
	private String color;
	private Genero genero;
	private Double precio;
	private Marca marca;



	public Calzado(Integer idCalzado,  Integer talle, Integer stock, String color,
			Genero genero, Double precio, Marca marca) {
		this.idCalzado = idCalzado;
		this.talle = talle;
		this.stock = stock;
		this.color = color;
		this.genero = genero;
		this.precio = precio;
		this.marca = marca;
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
	
	
	
	
	

}

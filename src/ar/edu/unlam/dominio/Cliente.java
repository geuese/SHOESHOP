package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ar.edu.unlam.enums.Genero;
import ar.edu.unlam.enums.ModoDePago;

public class Cliente {

	private String nombre;
	private Integer dni;
	private Integer talle;
	private Genero genero;
	private ModoDePago modoDePago;
	
	private List<Calzado> calzadosComprados; //gustavo

	public Cliente(String nombre, Integer dni, Integer talle, Genero genero, ModoDePago modoDePago) {
		this.nombre = nombre;
		this.dni = dni;
		this.talle = talle;
		this.genero = genero;
		this.modoDePago = modoDePago;
		
		this.calzadosComprados = new ArrayList<>(); //gustavo
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getTalle() {
		return talle;
	}

	public void setTalle(Integer talle) {
		this.talle = talle;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public ModoDePago getModoDePago() {
		return modoDePago;
	}

	public void setModoDePago(ModoDePago modoDePago) {
		this.modoDePago = modoDePago;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, talle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(talle, other.talle);
	}
	
	public void añadirCalzado(Calzado calzado) { //gustavo
		this.calzadosComprados.add(calzado);	
	}
	
	public List<Calzado> getCalzadosComprados() {
        return this.calzadosComprados;
    }

	public double calcularTotalGastado() {
		double total = 0.0;
        for (Calzado calzado : calzadosComprados) {
            total += calzado.getPrecio();
        }
        return total;
	}

}

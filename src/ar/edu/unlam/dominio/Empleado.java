package ar.edu.unlam.dominio;

import java.util.Objects;

import ar.edu.unalm.enums.Categoria;
import ar.edu.unalm.enums.TipoContrato;
import ar.edu.unalm.enums.TipoDeEmpleado;

public class Empleado {
	
	private Integer legajo;
	private String nombre;
	private Integer antiguedad;
	private TipoContrato modalidadDeContratacion;
	private TipoDeEmpleado tipoDeEmpleado;
	private Categoria categoria;

	public Empleado(String nombre, TipoContrato modalidadDeContratacion, Integer legajo, TipoDeEmpleado tipoDeEmpleado,
			Integer antiguedad, Categoria categoria) {
		this.nombre = nombre;
		this.modalidadDeContratacion = modalidadDeContratacion;
		this.legajo = legajo;
		this.tipoDeEmpleado = tipoDeEmpleado;
		this.antiguedad = antiguedad;
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(legajo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(legajo, other.legajo) && Objects.equals(nombre, other.nombre);
	}

	public Integer getLegajo() {
		return this.legajo;
	}

	public Integer getAntiguedad() {
		return this.antiguedad;
	}

	public TipoContrato getTipoContrato() {
		// TODO Auto-generated method stub
		return this.modalidadDeContratacion;
	}

	public Categoria getCategoria() {

		return this.categoria;
	}

}

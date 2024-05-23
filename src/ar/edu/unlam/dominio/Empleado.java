package ar.edu.unlam.dominio;

import java.util.Objects;

public class Empleado {
	
	
	private String nombre;
	private Contrato modalidadDeContratacion;
	private Integer legajo;
	private TipoDeEmpleado tipoDeEmpleado;
	private Integer antiguedad;
	private Categoria categoria;
	

	

	public Empleado(String nombre, Contrato modalidadDeContratacion, Integer legajo, TipoDeEmpleado tipoDeEmpleado,
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
	
	
	
	
	
	

}

package ar.edu.unlam.dominio;

import java.util.Objects;

public class Empleado {

	private String nombre;
	private Contrato modalidadDeContratacion;
	private Integer legajo;
	private TipoDeEmpleado tipoDeEmpleado;
	private Integer antiguedad;
	private Categoria categoria;
	private Double sueldo;

	public Empleado(String nombre, Contrato modalidadDeContratacion, Integer legajo, TipoDeEmpleado tipoDeEmpleado,
			Integer antiguedad, Categoria categoria) {
		this.nombre = nombre;
		this.modalidadDeContratacion = modalidadDeContratacion;
		this.legajo = legajo;
		this.tipoDeEmpleado = tipoDeEmpleado;
		this.antiguedad = antiguedad;
		this.categoria = categoria;
		this.calcularElSueldo();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Contrato getModalidadDeContratacion() {
		return modalidadDeContratacion;
	}

	public void setModalidadDeContratacion(Contrato modalidadDeContratacion) {
		this.modalidadDeContratacion = modalidadDeContratacion;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public TipoDeEmpleado getTipoDeEmpleado() {
		return tipoDeEmpleado;
	}

	public void setTipoDeEmpleado(TipoDeEmpleado tipoDeEmpleado) {
		this.tipoDeEmpleado = tipoDeEmpleado;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		
		this.antiguedad = antiguedad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
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

	public void calcularElSueldo() {

		TipoDeEmpleado tipoDeEmpleadoACalcular = this.getTipoDeEmpleado();

		switch (tipoDeEmpleadoACalcular) {

		case CAJERO:
			sueldoCajero();
			break;

		case REPOSITOR:
			sueldoRepositor();
			break;

		case VENTA_SALON:
			sueldoVenta();
			break;

		}

	}

	private Double sueldoCajero() {

		Double sueldoAux = 0.0;

		if (this.getCategoria().equals(Categoria.PART_TIME)) {
			sueldoAux = 53000.0;
		} else {
			sueldoAux = 424500.0;

		}

		calcularSegunContrato(sueldoAux);

		return sueldoAux;

	}

	private Double sueldoRepositor() {

		Double sueldoAux = 0.0;

		if (this.getCategoria().equals(Categoria.PART_TIME)) {
			sueldoAux = 41000.0;
		} else {
			sueldoAux = 204167.0;

		}
		calcularSegunContrato(sueldoAux);

		return sueldoAux;

	}

	private Double sueldoVenta() {

		Double sueldoAux = 0.0;

		if (this.getCategoria().equals(Categoria.PART_TIME)) {
			sueldoAux = 81000.0;
		} else {
			sueldoAux = 500000.0;

		}

		calcularSegunContrato(sueldoAux);
		return sueldoAux;

	}

	private void calcularSegunContrato(Double sueldoAux) {
		switch (this.getModalidadDeContratacion()) {
		case PASANTIA, PRUEBA:
			this.sueldo = sueldoAux * 0.50;
			break;
		default:
			this.sueldo = sueldoAux;
			break;
		}
	}

}

package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import ar.edu.unlam.enums.Categoria;
import ar.edu.unlam.enums.TipoContrato;
import ar.edu.unlam.enums.TipoDeEmpleado;

public class Empleado   {

	private Integer legajo;
	private String nombre;
	private Integer antiguedad;
	private TipoContrato modalidadDeContratacion;
	private TipoDeEmpleado tipoDeEmpleado;
	private Categoria categoria;
	private Double sueldo;

	public Empleado(String nombre, TipoContrato modalidadDeContratacion, Integer legajo, TipoDeEmpleado tipoDeEmpleado,
			Integer antiguedad, Categoria categoria) {
		this.nombre = nombre;
		this.modalidadDeContratacion = modalidadDeContratacion;
		this.legajo = legajo;
		this.tipoDeEmpleado = tipoDeEmpleado;
		this.antiguedad = antiguedad;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoContrato getModalidadDeContratacion() {
		return modalidadDeContratacion;
	}

	public void setModalidadDeContratacion(TipoContrato modalidadDeContratacion) {
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

	public TipoContrato getTipoContrato() {

		return this.modalidadDeContratacion;
	}

	

	public void añadirCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
	
	public List<Cliente> getClientes() {
        return this.clientes;
    }

	@Override
	public int hashCode() {
		return Objects.hash(antiguedad, categoria, legajo, modalidadDeContratacion, nombre, sueldo, tipoDeEmpleado);
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
		return Objects.equals(antiguedad, other.antiguedad) && categoria == other.categoria
				&& Objects.equals(legajo, other.legajo) && modalidadDeContratacion == other.modalidadDeContratacion
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sueldo, other.sueldo)
				&& tipoDeEmpleado == other.tipoDeEmpleado;
	}

	public List<Cliente> obtenerClientesOrdenadosPorNombre() {
		List<Cliente> clientesOrdenados = new ArrayList<>(this.clientes);
        Collections.sort(clientesOrdenados, Comparator.comparing(Cliente::getNombre));
        return clientesOrdenados;
	}
}

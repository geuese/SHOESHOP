package ar.edu.unlam.dominio;

import java.util.Objects;

public class EmpleadoCliente {

	private Empleado e;
	private Cliente c;
	private Integer cantidadAVender;

	public EmpleadoCliente(Empleado e, Cliente c, Integer cantidadAVender) {
		this.e = e;
		this.c = c;
		this.cantidadAVender = cantidadAVender;
	}

	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return c;
	}

	public Empleado getEmpleado() {
		// TODO Auto-generated method stub
		return e;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c, e);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadoCliente other = (EmpleadoCliente) obj;
		return Objects.equals(c, other.c) && Objects.equals(e, other.e);
	}

	public int getCantidadVendida() {
		return this.cantidadAVender;
	}

	public void incrementarCantidadAVender(Integer cantidadAVender2) {
		this.cantidadAVender += cantidadAVender2;
	}

}

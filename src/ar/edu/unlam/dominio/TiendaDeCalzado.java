package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unalm.enums.TipoContrato;

public class TiendaDeCalzado {
	private String nombreTienda;

	private List<Calzado> calzados;
	private List<Empleado> empleados;

	public TiendaDeCalzado(String nombreTienda) {
		this.nombreTienda = nombreTienda;
		this.calzados = new ArrayList<>();
		this.empleados = new ArrayList<>();
	}

	public Boolean agregarCalzado(Calzado calzado) {
		return this.calzados.add(calzado);
	}

	public List<Running> obtenerTodosLosRunning() {

		List<Running> calzadosRunning = new ArrayList<>();

		for (Calzado calzado : calzados) {
			if (calzado instanceof Running) {
				calzadosRunning.add((Running) calzado);
			}
		}
		return calzadosRunning;

	}

	public List<OutDoor> obtenerTodosLosOutDoor() {
		List<OutDoor> calzadosOutDoor = new ArrayList<>();

		for (Calzado calzado : calzados) {
			if (calzado instanceof OutDoor) {
				calzadosOutDoor.add((OutDoor) calzado);
			}
		}
		return calzadosOutDoor;
	}

	public List<Botin> obtenerTodosLosBotin() {

		List<Botin> calzadosBotin = new ArrayList<>();

		for (Calzado calzado : calzados) {
			if (calzado instanceof Botin) {
				calzadosBotin.add((Botin) calzado);
			}
		}
		return calzadosBotin;

	}

	public Integer calcularComisionEmpleado(Empleado empleadoBuscado) {
		Integer comision = 0;

		for (Empleado empleado : this.empleados) {
		    if (empleado.getLegajo().equals(empleadoBuscado.getLegajo())) {
		        switch (empleado.getTipoContrato()) {
		            case PRUEBA:
		                comision = empleado.getAntiguedad() * 2;
		                break;
		            case PASANTIA:
		                comision = empleado.getAntiguedad() * 4;
		                break;
		            case TIEMPO_INDETERMINDADO:
		                comision = empleado.getAntiguedad() * 6;
		                break;
		        }
		        
		        switch (empleado.getCategoria()) {
		            case FULL_TIME:
		                comision *= 9;
		                break;
		            case PART_TIME:
		                comision *= 6;
		                break;
		        }
		    }
		}

		return comision;
	}

	public void agregarEmpleado(Empleado empleado) {
	
		this.empleados.add(empleado);
		
	}
}

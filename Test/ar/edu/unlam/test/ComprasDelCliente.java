package ar.edu.unlam.test;

import java.util.List;

import ar.edu.unlam.dominio.Calzado;
import ar.edu.unlam.dominio.Cliente;

public class ComprasDelCliente{
	
	private Cliente cliente;
	private List<Calzado> comprasDelCliente;
	
	public ComprasDelCliente(Cliente cliente, List<Calzado> comprasDelCliente) {
		
		this.cliente = cliente;
		this.comprasDelCliente = comprasDelCliente;
	}

	public List<Calzado> getComprasDelCliente() {
		return comprasDelCliente;
	} 
}

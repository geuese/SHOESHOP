package ar.edu.unlam.dominio;

import java.util.List;

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

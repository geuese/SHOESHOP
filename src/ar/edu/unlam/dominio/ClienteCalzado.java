package ar.edu.unlam.dominio;

public class ClienteCalzado {

	private Cliente cliente;
	private Calzado calzado;
	private Integer cantidadAComprar;

	public ClienteCalzado(Cliente cliente, Calzado calzado, Integer cantidadAComprar) {
		this.cliente = cliente;
		this.calzado = calzado;
		this.calzado.setStock(cantidadAComprar);
	}

	public Integer getIDDeCalzado() {
		return this.calzado.getID();
	}

	public Calzado getCalzado() {
		return this.calzado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	

	
	
}

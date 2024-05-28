package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TiendaDeCalzado implements ITiendaDeCalzado {

	private String nombreTienda;

	private List<Calzado> calzados;

	private List<ClienteCalzado> clientesCalzados;

	public TiendaDeCalzado(String nombreTienda) {
		this.nombreTienda = nombreTienda;
		this.calzados = new ArrayList<>();
		this.clientesCalzados = new ArrayList<>();
	}

	@Override
	public Boolean agregarCalzado(Calzado calzado, Integer cantidadDeCalzados) {
		for (Calzado c : calzados) {
			if (c != null && c.getID().equals(calzado.getID())) {
				c.incrementarStock(cantidadDeCalzados);
				return true; // Se encontro el calzado, se actualizo el stock y se retorna true.
			}
		}
		// Si se recorrio toda la lista y no se encontro el calzado, se agrega uno
		// nuevo.
		calzado.setStock(cantidadDeCalzados);
		calzados.add(calzado);
		return true;
	}

	@Override
	public Boolean venderCalzado(Cliente cliente, Calzado calzado, Integer cantidadAVender) {

		for (Calzado c : calzados) {
			if (c != (null) && c.getID().equals(calzado.getID()) && c.getStock() >= cantidadAVender) {
				c.reducirStock(cantidadAVender);

				Boolean clienteCalzadoEncontrado = false;

				for (ClienteCalzado cc : clientesCalzados) {
					if (cc != (null) && cc.getCliente().getDni().equals(cliente.getDni())
							&& cc.getCalzado().getID().equals(calzado.getID())) {
						cc.getCalzado().incrementarStock(cantidadAVender);
						clienteCalzadoEncontrado = true;
						break;
					}
				}

				if (!clienteCalzadoEncontrado) {
					ClienteCalzado nuevoClienteCalzado = crearClienteCalzado(cliente, calzado, cantidadAVender);
					this.clientesCalzados.add(nuevoClienteCalzado);
				}

				return true;

			}
		}
		return false;
	}

	@Override
	public ClienteCalzado crearClienteCalzado(Cliente cliente, Calzado calzado, Integer cantidadAComprar) {
		return new ClienteCalzado(cliente, calzado, cantidadAComprar);
	}

	@Override
	public List<Calzado> obtenerlistaDeZapatosDeCliente(Cliente cliente) {
		List<Calzado> calzadosDeCliente = new ArrayList<Calzado>();
		for (ClienteCalzado cc : clientesCalzados) {
			if (cc != null && cc.getCliente().getDni().equals(cliente.getDni())) {
				calzadosDeCliente.add(cc.getCalzado());
			}
		}
		return calzadosDeCliente;
	}

	@Override
	public Integer obtenerCantidadDeParesTotalesDeLaTienda() {
		int cantidadTotalDeZapatos = 0;
		for (Calzado c : calzados) {
			if (c != null) {
				cantidadTotalDeZapatos += c.getStock();
			}
		}
		return cantidadTotalDeZapatos;
	}

	@Override
	public List<Calzado> obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(Cliente cliente) {
		List<Calzado> calzadosDeCliente = new ArrayList<Calzado>();
		for (ClienteCalzado cc : clientesCalzados) {
			if (cc != null && cc.getCliente().getDni().equals(cliente.getDni())) {
				calzadosDeCliente.add(cc.getCalzado());
			}
		}
		Collections.sort(calzadosDeCliente, (o1, o2) -> o2.getPrecio().compareTo(o1.getPrecio()));
		return calzadosDeCliente;
	}

	public List<ClienteCalzado> getClientesCalzados() {
		return this.clientesCalzados;
	}

	public List<Calzado> getCalzados() {
		return this.calzados;
	}

}

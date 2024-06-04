package ar.edu.unlam.dominio;

import ar.edu.unlam.enums.Genero;
import ar.edu.unlam.enums.Marca;
import ar.edu.unlam.enums.TipoDeUso;

public class OutDoor extends Calzado {

	private TipoDeUso tipoDeUso;

	public OutDoor(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoDeUso tipoDeUso) {
		super(idCalzado, talle, color, genero, precio, marca);

		this.tipoDeUso = tipoDeUso;
	}
	
	@Override
	public void incrementarStockCliente(Integer cantidadAComprar) {
		// TODO Auto-generated method stub
		this.stockCliente += cantidadAComprar;
	}
}

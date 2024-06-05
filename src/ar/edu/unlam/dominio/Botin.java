package ar.edu.unlam.dominio;

import ar.edu.unlam.enums.Genero;
import ar.edu.unlam.enums.Marca;
import ar.edu.unlam.enums.TipoSuperficie;

public class Botin extends Calzado {

	private TipoSuperficie tipoSuperficie;

	public Botin(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoSuperficie tipoSuperficie) {
		super(idCalzado, talle, color, genero, precio, marca);
		this.tipoSuperficie = tipoSuperficie;
	}


	public TipoSuperficie getTipoSuperficie() {
		return tipoSuperficie;
	}


	public void setTipoSuperficie(TipoSuperficie tipoSuperficie) {
		this.tipoSuperficie = tipoSuperficie;
	}


	@Override
	public void incrementarStockCliente(Integer cantidadAComprar) {
		// TODO Auto-generated method stub
		this.stockCliente += cantidadAComprar;
	}
	
	
	

}

package ar.edu.unlam.dominio;

public class Botin extends Calzado {
	
	
	private TipoSuperficie tipoSuperficie;

	
	public Botin(Integer idCalzado, Integer talle, Integer stock, String color, Genero genero, Double precio,
			Marca marca, TipoSuperficie tipoSuperficie) {
		super(idCalzado, talle, stock, color, genero, precio, marca);
		this.tipoSuperficie = tipoSuperficie;
	}
	
	
	

}

package ar.edu.unlam.dominio;

public class OutDoor extends Calzado {

	private TipoDeUso tipoDeUso;

	public OutDoor(Integer idCalzado, Integer talle, Integer stock, String color, Genero genero, Double precio,
			Marca marca, TipoDeUso tipoDeUso) {
		super(idCalzado, talle, stock, color, genero, precio, marca);

		this.tipoDeUso = tipoDeUso;

		// TODO Auto-generated constructor stub
	}

}

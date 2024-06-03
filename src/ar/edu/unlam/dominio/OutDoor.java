package ar.edu.unlam.dominio;

import ar.edu.unalm.enums.Genero;
import ar.edu.unalm.enums.Marca;
import ar.edu.unalm.enums.TipoDeUso;

public class OutDoor extends Calzado {

	private TipoDeUso tipoDeUso;

	public OutDoor(Integer idCalzado, Integer talle, String color, Genero genero, Double precio,
			Marca marca, TipoDeUso tipoDeUso) {
		super(idCalzado, talle, color, genero, precio, marca);

		this.tipoDeUso = tipoDeUso;
	}

	@Override
	public void reducirStock(Integer cantidadAVender) {
		this.stock -= cantidadAVender;
		
	}

	@Override
	public void incrementarStock(Integer cantidadDeCalzados) {
		this.stock += cantidadDeCalzados;
// TODO Auto-generated method stub
		
	}

}

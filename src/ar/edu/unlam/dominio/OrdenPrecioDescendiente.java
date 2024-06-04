package ar.edu.unlam.dominio;

import java.util.Comparator;

public class OrdenPrecioDescendiente implements Comparator<Calzado> {

	@Override
	public int compare(Calzado o1, Calzado o2) {
		// TODO Auto-generated method stub
		return o2.getPrecio().compareTo(o1.getPrecio());
	}

}

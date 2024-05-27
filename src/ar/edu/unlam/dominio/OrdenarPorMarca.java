package ar.edu.unlam.dominio;

import java.util.Comparator;

public class OrdenarPorMarca implements Comparator<Calzado> {

	@Override
	public int compare(Calzado o1, Calzado o2) {
		// TODO Auto-generated method stub
		return o1.getMarca().compareTo(o2.getMarca());
	}

}

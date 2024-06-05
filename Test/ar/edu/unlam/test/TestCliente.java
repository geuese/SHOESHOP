package ar.edu.unlam.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import ar.edu.unlam.dominio.*;
import ar.edu.unlam.enums.*;

public class TestCliente {

    private TiendaDeCalzado tiendaDeCalzado;
    private Cliente cliente;

    @Before
    public void inicializar() {
        tiendaDeCalzado = new TiendaDeCalzado("ShoesShop");
        cliente = new Cliente("Papu", 45555999, 37, Genero.X, ModoDePago.DEBITO);
    }

    @Test
    public void asignarCalzadosAUnCliente() {
    	Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
        Calzado calzado = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);

        tiendaDeCalzado.venderCalzado(cliente, calzado, 1, empleado);
        assertEquals(1, cliente.getCalzadosComprados().size());
    }

    @Test
    public void calcularElTotalGastadoPorCadaCliente() {
    	Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
        Calzado calzado1 = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        Calzado calzado2 = new Botin(2, 42, "Negro", Genero.MASCULINO, 50.0, Marca.NIKE, TipoSuperficie.SUELO_BLANDO);
        tiendaDeCalzado.agregarCalzado(calzado1, 5);
        tiendaDeCalzado.agregarCalzado(calzado2, 5);

        tiendaDeCalzado.venderCalzado(cliente, calzado1, 1, empleado);
        tiendaDeCalzado.venderCalzado(cliente, calzado2, 1, empleado);

        assertEquals(80.0, cliente.calcularTotalGastado(), 0.01);
    }

    @Test
    public void obtenerListaDeCalzadosDelCliente() {
    	Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
        Calzado calzado = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);
        
        tiendaDeCalzado.venderCalzado(cliente, calzado, 1, empleado);
        assertEquals(1, cliente.getCalzadosComprados().size());
    }

    @Test
    public void queSePuedaVenderCalzadosACliente() {
    	Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
        Calzado calzado = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);

        Boolean ventaExitosa = tiendaDeCalzado.venderCalzado(cliente, calzado, 1, empleado);
        assertTrue(ventaExitosa);
    }

    @Test
    public void obtenerLosCalzadosPorClienteOrdenadosPorPrecioDescendente() {
    	Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMINADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
        Calzado calzado1 = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        Calzado calzado2 = new Botin(2, 42, "Negro", Genero.MASCULINO, 50.0, Marca.NIKE, TipoSuperficie.SUELO_BLANDO);
        tiendaDeCalzado.agregarCalzado(calzado1, 5);
        tiendaDeCalzado.agregarCalzado(calzado2, 5);

        tiendaDeCalzado.venderCalzado(cliente, calzado1, 1, empleado);
        tiendaDeCalzado.venderCalzado(cliente, calzado2, 2, empleado);

        List<Calzado> calzadosOrdenados = tiendaDeCalzado.obtenerlistaDeZapatosDeClienteOrdenadosPorPrecioDescendiente(cliente);
        assertEquals(calzado2, calzadosOrdenados.get(0));
        assertEquals(calzado1, calzadosOrdenados.get(1));
    }
}

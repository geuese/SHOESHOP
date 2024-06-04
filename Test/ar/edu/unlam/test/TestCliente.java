package ar.edu.unlam.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
        Calzado calzado = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);

        tiendaDeCalzado.venderCalzado(cliente, 1, 1);
        assertEquals(1, cliente.getCalzados().size());
    }

    @Test
    public void calcularElTotalGastadoPorCadaCliente() {
        Calzado calzado1 = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        Calzado calzado2 = new Botin(2, 42, "Negro", Genero.MASCULINO, 50.0, Marca.NIKE, TipoSuperficie.CESPED);
        tiendaDeCalzado.agregarCalzado(calzado1, 5);
        tiendaDeCalzado.agregarCalzado(calzado2, 5);

        tiendaDeCalzado.venderCalzado(cliente, 1, 1);
        tiendaDeCalzado.venderCalzado(cliente, 2, 1);

        assertEquals(80.0, cliente.calcularTotalGastado(), 0.01);
    }

    @Test
    public void obtenerListaDeCalzadosDelCliente() {
        Calzado calzado = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);
        
        tiendaDeCalzado.venderCalzado(cliente, 1, 1);
        assertEquals(1, cliente.getCalzados().size());
    }

    @Test
    public void queSePuedaVenderCalzadosACliente() {
        Calzado calzado = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);

        Boolean ventaExitosa = tiendaDeCalzado.venderCalzado(cliente, 1, 1);
        assertTrue(ventaExitosa);
    }

    @Test
    public void obtenerLosCalzadosPorClienteOrdenadosPorPrecioDescendente() {
        Calzado calzado1 = new Running(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        Calzado calzado2 = new Botin(2, 42, "Negro", Genero.MASCULINO, 50.0, Marca.NIKE, TipoSuperficie.CESPED);
        tiendaDeCalzado.agregarCalzado(calzado1, 5);
        tiendaDeCalzado.agregarCalzado(calzado2, 5);

        tiendaDeCalzado.venderCalzado(cliente, 1, 1);
        tiendaDeCalzado.venderCalzado(cliente, 2, 1);

        List<Calzado> calzadosOrdenados = cliente.obtenerCalzadosOrdenadosPorPrecioDescendente();
        assertEquals(calzado2, calzadosOrdenados.get(0));
        assertEquals(calzado1, calzadosOrdenados.get(1));
    }
}

package ar.edu.unlam.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ar.edu.unlam.dominio.*;
import ar.edu.unlam.enums.*;

public class TestTiendaDeCalzado {

    private TiendaDeCalzado tiendaDeCalzado;

    @Before
    public void inicializarTienda() {
        tiendaDeCalzado = new TiendaDeCalzado("ShoesShop");
    }

    private Calzado crearBotin(Integer id, Integer talle, String color, Genero genero, Double precio, Marca marca, TipoSuperficie tipoSuperficie) {
        return new Botin(id, talle, color, genero, precio, marca, tipoSuperficie);
    }

    private Calzado crearRunning(Integer id, Integer talle, String color, Genero genero, Double precio, Marca marca, TipoDePisada tipoPisada) {
        return new Running(id, talle, color, genero, precio, marca, tipoPisada);
    }

    private Calzado crearOutDoor(Integer id, Integer talle, String color, Genero genero, Double precio, Marca marca, TipoDeUso tipoDeUso) {
        return new OutDoor(id, talle, color, genero, precio, marca, tipoDeUso);
    }

    @Test
    public void queSePuedaAnadirCalzadoBotinALaTienda() {
        Calzado calzado = crearBotin(1, 36, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoSuperficie.INTERIOR);
        Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado, 10);
        assertTrue(calzadoAgregado);
    }

    @Test
    public void queSePuedaAñadirCalzadoRunningALaTienda() {
        Calzado calzado = crearRunning(1, 36, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoDePisada.PISADA_NEUTRA);
        Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado, 10);
        assertTrue(calzadoAgregado);
    }

    @Test
    public void queSePuedaAñadirCalzadoOutDoorALaTienda() {
        Calzado calzado = crearOutDoor(1, 36, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoDeUso.HIKING);
        Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado, 10);
        assertTrue(calzadoAgregado);
    }

    @Test
    public void queSePuedaAgregarCalzadoATienda() {
        Calzado calzado = crearBotin(2, 42, "Marrón", Genero.FEMENINO, 25.0, Marca.NIKE, TipoSuperficie.TERRENO_ARTIFICIAL);
        Boolean calzadoAgregado = tiendaDeCalzado.agregarCalzado(calzado, 5);
        assertTrue(calzadoAgregado);
    }

    @Test
    public void queSePuedaCrearElCliente() {
        Cliente cliente = new Cliente("Papu", 45555999, 37, Genero.X, ModoDePago.DEBITO);
        assertNotNull(cliente);
    }

    @Test
    public void queSePuedaCrearElEmpleado() {
        Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMIDADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
        assertNotNull(empleado);
    }

    @Test
    public void queNoSePuedaVenderMasDelStock() {
        Calzado calzado = crearRunning(1, 42, "Azul", Genero.MASCULINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_SUPINADORA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);
        Cliente cliente = new Cliente("Juan", 12345678, 42, Genero.MASCULINO, ModoDePago.EFECTIVO);
        Empleado empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMIDADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);

        Boolean ventaExitosa = tiendaDeCalzado.venderCalzado(cliente, calzado, 1, empleado);
        assertTrue(ventaExitosa);
    }
}
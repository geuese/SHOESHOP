package ar.edu.unlam.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ar.edu.unlam.dominio.*;
import ar.edu.unlam.enums.*;

import java.util.List;

public class TestCalzado {

    private TiendaDeCalzado tiendaDeCalzado;

    @Before
    public void inicializar() {
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
    public void queSePuedaBuscarCalzadoPorCodigo() {
        Calzado calzado = crearBotin(1, 36, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoSuperficie.INTERIOR);
        tiendaDeCalzado.agregarCalzado(calzado, 10);

        Calzado encontrado = tiendaDeCalzado.buscarCalzadoPorCodigo(1);
        assertNotNull(encontrado);
        assertEquals(calzado, encontrado);
    }

    @Test
    public void queNoSePuedaBuscarCalzadoPorCodigo() {
        Calzado calzado = crearBotin(1, 36, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoSuperficie.INTERIOR);
        tiendaDeCalzado.agregarCalzado(calzado, 10);

        Calzado encontrado = tiendaDeCalzado.buscarCalzadoPorCodigo(2);
        assertNull(encontrado);
    }

    @Test
    public void queAlbuscarCalzadoPorCodigoDevuelvaElPrecioDelMismo() {
        Calzado calzado = crearBotin(1, 36, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoSuperficie.INTERIOR);
        tiendaDeCalzado.agregarCalzado(calzado, 10);

        Calzado encontrado = tiendaDeCalzado.buscarCalzadoPorCodigo(1);
        assertEquals(20.0, encontrado.getPrecio(), 0.01);
    }

    @Test
    public void queSePuedaOrdenarLosBotinesSegunElTalleDeFormaAscendente() {
        Calzado botin1 = crearBotin(1001, 39, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoSuperficie.INTERIOR);
        Calzado botin2 = crearBotin(1002, 40, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER, TipoSuperficie.SUELO_FIRME);
        Calzado botin3 = crearBotin(1003, 35, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS, TipoSuperficie.SALON);

        tiendaDeCalzado.agregarCalzado(botin1, 2);
        tiendaDeCalzado.agregarCalzado(botin2, 2);
        tiendaDeCalzado.agregarCalzado(botin3, 2);

        List<Calzado> botinesOrdenados = tiendaDeCalzado.ordenarBotinesPorTalleDeManeraAscendente();
        assertEquals(botin3, botinesOrdenados.get(0));
        assertEquals(botin1, botinesOrdenados.get(1));
        assertEquals(botin2, botinesOrdenados.get(2));
    }

    @Test
    public void queSePuedaOrdenarLosOutDoorSegunElTalleDeFormaAscendente() {
        Calzado outDoor1 = crearOutDoor(1001, 39, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoDeUso.HIKING);
        Calzado outDoor2 = crearOutDoor(1002, 40, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER, TipoDeUso.TRAIL_RUNNING);
        Calzado outDoor3 = crearOutDoor(1003, 35, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS, TipoDeUso.ESCALADA);

        tiendaDeCalzado.agregarCalzado(outDoor1, 2);
        tiendaDeCalzado.agregarCalzado(outDoor2, 2);
        tiendaDeCalzado.agregarCalzado(outDoor3, 2);

        List<Calzado> outDoorsOrdenados = tiendaDeCalzado.ordenarOutDoorsPorTalleDeManeraAscendente();
        assertEquals(outDoor3, outDoorsOrdenados.get(0));
        assertEquals(outDoor1, outDoorsOrdenados.get(1));
        assertEquals(outDoor2, outDoorsOrdenados.get(2));
    }

    @Test
    public void queSePuedaOrdenarLosRunningsSegunElTalleDeFormaAscendente() {
        Calzado running1 = crearRunning(1001, 40, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoDePisada.PISADA_NEUTRA);
        Calzado running2 = crearRunning(1002, 38, "Rojo", Genero.FEMENINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_PRONADORA);
        Calzado running3 = crearRunning(1003, 36, "Blanco", Genero.X, 50.0, Marca.JOHN_FOOS, TipoDePisada.PISADA_SUPINADORA);

        tiendaDeCalzado.agregarCalzado(running1, 1);
        tiendaDeCalzado.agregarCalzado(running2, 1);
        tiendaDeCalzado.agregarCalzado(running3, 1);

        List<Calzado> runningsOrdenados = tiendaDeCalzado.ordenarRunningsPorTalleDeManeraAscendente();
        assertEquals(running3, runningsOrdenados.get(0));
        assertEquals(running2, runningsOrdenados.get(1));
        assertEquals(running1, runningsOrdenados.get(2));
    }

    @Test
    public void queTraigaTodosLosRunnings() {
        Calzado running1 = crearRunning(1001, 40, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoDePisada.PISADA_NEUTRA);
        Calzado running2 = crearRunning(1002, 38, "Rojo", Genero.FEMENINO, 30.0, Marca.ADIDAS, TipoDePisada.PISADA_PRONADORA);

        tiendaDeCalzado.agregarCalzado(running1, 1);
        tiendaDeCalzado.agregarCalzado(running2, 1);

        List<Calzado> runnings = tiendaDeCalzado.obtenerTodosLosRunnings();
        assertEquals(2, runnings.size());
        assertTrue(runnings.contains(running1));
        assertTrue(runnings.contains(running2));
    }

    @Test
    public void queTraigaTodosLosOutDoor() {
        Calzado outDoor1 = crearOutDoor(1001, 39, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoDeUso.HIKING);
        Calzado outDoor2 = crearOutDoor(1002, 40, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER, TipoDeUso.TRAIL_RUNNING);

        tiendaDeCalzado.agregarCalzado(outDoor1, 1);
        tiendaDeCalzado.agregarCalzado(outDoor2, 1);

        List<Calzado> outDoors = tiendaDeCalzado.obtenerTodosLosOutDoor();
        assertEquals(2, outDoors.size());
        assertTrue(outDoors.contains(outDoor1));
        assertTrue(outDoors.contains(outDoor2));
    }

    @Test
    public void queTraigaTodosLosBotin() {
        Calzado botin1 = crearBotin(1001, 39, "Negro", Genero.MASCULINO, 20.0, Marca.TOPPER, TipoSuperficie.INTERIOR);
        Calzado botin2 = crearBotin(1002, 40, "Rojo", Genero.FEMENINO, 30.0, Marca.TOPPER, TipoSuperficie.SUELO_FIRME);

        tiendaDeCalzado.agregarCalzado(botin1, 1);
        tiendaDeCalzado.agregarCalzado(botin2, 1);

        List<Calzado> botines = tiendaDeCalzado.obtenerTodosLosBotines();
        assertEquals(2, botines.size());
        assertTrue(botines.contains(botin1));
        assertTrue(botines.contains(botin2));
    }
}

package ar.edu.unlam.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ar.edu.unlam.dominio.*;
import ar.edu.unlam.enums.*;

public class TestEmpleado {

    private TiendaDeCalzado tiendaDeCalzado;
    private Empleado empleado;

    @Before
    public void inicializar() {
        tiendaDeCalzado = new TiendaDeCalzado("ShoesShop");
        empleado = new Empleado("Empleado", TipoContrato.TIEMPO_INDETERMIDADO, 1111, TipoDeEmpleado.REPOSITOR, 20, Categoria.FULL_TIME);
    }

    @Test
    public void calcularComisionDelEmpleado() {
        Empleado vendedor = new Empleado("Vendedor", TipoContrato.TIEMPO_INDETERMIDADO, 2222, TipoDeEmpleado.VENTA_SALON, 10, Categoria.PART_TIME);
        tiendaDeCalzado.agregarEmpleado(vendedor);
        
        Calzado calzado = new Running(1, 42, "Rojo", Genero.FEMENINO, 50.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);
        
        Cliente cliente = new Cliente("Maria", 98765432, 42, Genero.FEMENINO, ModoDePago.DEBITO);
        tiendaDeCalzado.venderCalzado(cliente, calzado, 2, vendedor);

        Double comisionEsperada = 0.1 * (2 * 50.0); // Suponiendo una comisión del 10%
        assertEquals(comisionEsperada, vendedor.calcularComision(), 0.01);
    }

    @Test
    public void queSePuedaAgregarEmpleadoATienda() {
        tiendaDeCalzado.agregarEmpleado(empleado);
        assertTrue(tiendaDeCalzado.getEmpleados().contains(empleado));
    }

    /*@Test
    public void obtenerListaDeClientesDeEmpleadoOrdenadoPorParametro() {
        // Agregar implementación específica según el parámetro de ordenación
    }*/

    /*@Test
    public void obtenerListaDeClientesDelEmpleado() {
        Cliente cliente1 = new Cliente("Ana", 33333333, 38, Genero.FEMENINO, ModoDePago.CREDITO);
        Cliente cliente2 = new Cliente("Luis", 44444444, 40, Genero.MASCULINO, ModoDePago.EFECTIVO);
        
        tiendaDeCalzado.agregarCliente(cliente1);
        tiendaDeCalzado.agregarCliente(cliente2);
        
        empleado.agregarCliente(cliente1);
        empleado.agregarCliente(cliente2);

        assertEquals(2, empleado.obtenerClientes().size());
    }*/

    @Test
    public void obtenerElTotalDeVentasPorEmpleado() {
        Empleado vendedor = new Empleado("Vendedor", TipoContrato.TIEMPO_INDETERMIDADO, 2222, TipoDeEmpleado.VENTA_SALON, 10, Categoria.PART_TIME);
        tiendaDeCalzado.agregarEmpleado(vendedor);
        
        Calzado calzado = new Running(1, 42, "Rojo", Genero.FEMENINO, 50.0, Marca.ADIDAS, TipoDePisada.PISADA_NEUTRA);
        tiendaDeCalzado.agregarCalzado(calzado, 5);
        
        Cliente cliente = new Cliente("Maria", 98765432, 42, Genero.FEMENINO, ModoDePago.DEBITO);
        tiendaDeCalzado.venderCalzado(cliente, calzado, 2, vendedor);
        
        assertEquals(100.0, vendedor.calcularTotalVentas(), 0.01);
    }
}

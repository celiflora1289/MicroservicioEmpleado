package com.empresa.ejercicio.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class EmpleadoTest {
	
	@Test
    public void testGetterAndSetter() {
        Empleado empleado = new Empleado();

        empleado.setIdEmpleado(1);
        empleado.setPrimerNombre("Floe");
        empleado.setSegundoNombre("Celi");
        empleado.setApePaterno("Jimenez");
        empleado.setApeMaterno("Cruz");
        empleado.setEdad(30);
        empleado.setGenero("Mujer");
        empleado.setFechaNacimiento("02/01/1994");
        empleado.setPuesto("Desarrollador");

        assertEquals(1, empleado.getIdEmpleado());
		assertEquals("Floe", empleado.getPrimerNombre());
		assertEquals("Celi", empleado.getSegundoNombre());
		assertEquals("Jimenez", empleado.getApePaterno());
		assertEquals("Cruz", empleado.getApeMaterno());
		assertEquals(30, empleado.getEdad());
		assertEquals("Mujer", empleado.getGenero());
		assertEquals("02/01/1994", empleado.getFechaNacimiento());
		 assertEquals("Desarrollador", empleado.getPuesto());
		 
		  }

}

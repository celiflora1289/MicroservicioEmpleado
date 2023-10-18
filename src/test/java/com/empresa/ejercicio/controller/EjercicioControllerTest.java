package com.empresa.ejercicio.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.empresa.ejercicio.model.Empleado;
import com.empresa.ejercicio.service.IEmpleadosService;


@ExtendWith(MockitoExtension.class)
class EjercicioControllerTest {
	
	@MockBean
	private IEmpleadosService empleadosService;
	
	@InjectMocks
    private EjercicioController ejercicioController;

	//Por falta de tiempo ya no se realziaron las pruebas unitarias...
	
//	@Test
//	void test() {
//		Empleado e= new Empleado(1, "Cely", "segundo", "paterno", "materno", 30, "02/01/1994", "Femenino", "Desarrollador");
//		
//		when(empleadosService.consultarEmpleados()).thenReturn(null);
//		
//		assertNull(ejercicioController.consultarEmpleados());
//	}
	
//	@Test
//	void test2() {
//		Empleado e= new Empleado(1, "Cely", "segundo", "paterno", "materno", 30, "02/01/1994", "Femenino", "Desarrollador");
//		Mockito.doNothing().when(empleadosService).actualizaEmplado(1, e);
//		Assertions.assertDoesNotThrow(() -> ejercicioController.actualizaEmpleado(1, e));
//	}
//	
//	@Test
//	void test3() {
//		Empleado e= new Empleado(1, "Cely", "segundo", "paterno", "materno", 30, "02/01/1994", "Femenino", "Desarrollador");
//		Assertions.assertDoesNotThrow(() -> ejercicioController.EliminarEmpleado(1));
//	}
	
//	@Test
//	void test4() {
//		Empleado e= new Empleado(1, "Cely", "segundo", "paterno", "materno", 30, "02/01/1994", "Femenino", "Desarrollador");
//		List<Empleado> list= new ArrayList<Empleado>();
//		list.add(e);
//		Assertions.assertDoesNotThrow(() -> ejercicioController.guardarEmpleados(list, null));
//	}

}

package com.empresa.ejercicio.service;

import java.util.List;
import com.empresa.ejercicio.model.Empleado;

/**
 * 
 * @author 
 * 
 * Interfaz publica para las operaciones de negocio de la entidad Empleado
 */
public interface IEmpleadosService {
	
	/**
	 * Metodo para consulta de empleados
	 * @return Lista de empleados
	 */
	Iterable<Empleado> consultarEmpleados();
	
	/**
	 * Metodo para guarda empleados
	 * @param empleados Lista de empleados
	 */
	void guardaEmpleados(List<Empleado> empleados);
	
	/**
	 * Metodo para eliminar un empleado
	 * @param idEmpleado ID de empleado
	 */
	void eliminarEmpleado(Integer idEmpleado);
	
	/**
	 * Metodo para actualizar empleado
	 * @param idEmpleado ID de empleado
	 * @param empleado Objeto Empleado a actualizar
	 */
	void actualizaEmpleado(Integer idEmpleado, Empleado empleado);

}

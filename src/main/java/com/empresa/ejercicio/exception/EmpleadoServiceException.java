package com.empresa.ejercicio.exception;

import com.empresa.ejercicio.util.ErrorEnum;

/**
 * 
 * @author 
 * Clase de excepcion de negocio de los metodos de Empleado
 */
public class EmpleadoServiceException extends Exception {

	/**
	 * serialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param message Mensaje de error
	 */
	public EmpleadoServiceException(String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * @param message Mensaje de error
	 * @param causa Causa completa del error
	 */
	public EmpleadoServiceException(String message, Throwable causa) {
		super(message, causa);
	}
	
	/**
	 * Constructor que la interfaz del enumerador de error
	 * @param errorEnum Interfaz de enumerador de error
	 */
	public EmpleadoServiceException(ErrorEnum errorEnum) {
		super(errorEnum.getMessage());
	}
	
	/**
	 * Constructor que la interfaz del enumerador de error
	 * @param errorEnum Interfaz de enumerador de error
	 * @param causa Causa completa del error
	 */
	public EmpleadoServiceException(ErrorEnum errorEnum, Throwable causa) {
		super(errorEnum.getMessage(), causa);
	}

}

package com.empresa.ejercicio.exception;

import com.empresa.ejercicio.util.ErrorEnum;

/**
 * 
 * @author 
 * Clase de excepcion de negocio cuando no existe Empleado
 */
public class EmpleadoInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param message Mensaje de error
	 */
	public EmpleadoInexistenteException (String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * @param message Mensaje de error
	 * @param causa Causa completa del error
	 */
	public EmpleadoInexistenteException (String message, Throwable causa) {
		super(message, causa);
	}
	
	/**
	 * Constructor que la interfaz del enumerador de error
	 * @param errorEnum Interfaz de enumerador de error
	 */
	public EmpleadoInexistenteException (ErrorEnum errorEnum) {
		super(errorEnum.getMessage());
	}
	
	/**
	 * Constructor de la interfaz del enumerador de error
	 * @param errorEnum Interfaz de enumerador de error
	 * @param causa Causa completa del error
	 */
	public EmpleadoInexistenteException (ErrorEnum errorEnum, Throwable causa) {
		super(errorEnum.getMessage(), causa);
	}
	
}

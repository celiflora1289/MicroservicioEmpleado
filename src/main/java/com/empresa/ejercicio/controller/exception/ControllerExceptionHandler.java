package com.empresa.ejercicio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.empresa.ejercicio.controller.exception.model.DefaultError;
import com.empresa.ejercicio.controller.exception.model.DefaultErrorList;
import com.empresa.ejercicio.exception.EmpleadoInexistenteException;
import com.empresa.ejercicio.exception.EmpleadoServiceException;
import com.empresa.ejercicio.util.ErrorEnum;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author 
 * 
 * Esta clase se encarga de servir como apoyo al controller, manejando de manera desacoplada 
 * las excepciones esperadas en la aplicacion, y manejando el catalogo de errores con ayuda de un enumerador personalizado.
 * Tambien tiene un manejo de errores genericos.
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	/**
     * Manejo de excepciones de validacion de formatos de numeros de entrada
     * @param pe Excepcion de tipo NumberFormatException
     * @return La entidad de respuesta que maneja el error como objeto
     */
	@ExceptionHandler(value = {InvalidFormatException.class})
	public ResponseEntity<DefaultErrorList> handleValidationExceptionB(InvalidFormatException pe) {
    	LOGGER.warn("Excepcion de formatos de numeros de entrada", pe);
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
	}

	/**
     * Manejo de excepciones de validacion de tipo de datos de entrada
     * @param pe Excepcion de tipo MethodArgumentTypeMismatchException
     * @return La entidad de respuesta que maneja el error como objeto
     */
	@ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
	public ResponseEntity<DefaultErrorList> handleValidationExceptionC(MethodArgumentTypeMismatchException pe) {
    	LOGGER.warn("Excepcion de tipo de datos de entrada", pe);
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
	}

	/**
     * Manejo de excepciones de validacion de cantidad de parametros de entrada enviados
     * @param pe Excepcion de tipo MissingServletRequestParameterException
     * @return La entidad de respuesta que maneja el error como objeto
     */
	@ExceptionHandler(value = {MissingServletRequestParameterException.class})
	public ResponseEntity<DefaultErrorList> handleValidationExceptionD(MissingServletRequestParameterException pe) {
    	LOGGER.warn("Excepcion de cantidad de parametros de entrada enviados", pe);
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Manejo de excepcion de llave duplicada
	 * @param ex Excepcion de tipo DuplicateKeyException
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<DefaultErrorList> handleGenericExceptionDuplicte(DuplicateKeyException ex) {
		LOGGER.warn("Entidad duplicada", ex);
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_DUPLICADO)), HttpStatus.BAD_REQUEST);
    }

	/**
     * Manejo de excepcion de registro inexistente
     * @param ex Excepcion de registro inexsistente EmpleadoInexistenteException
     * @return La entidad de respuesta que maneja el error como objeto
     */
    @ExceptionHandler(EmpleadoInexistenteException.class)
    public ResponseEntity<DefaultErrorList> handleEmpleadoInexistenteException(EmpleadoInexistenteException ex) {
    	LOGGER.warn("Entidad inexistente {}", ex.getMessage());
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_INEXISTENTE)), HttpStatus.NOT_FOUND);
    }

    /**
     * Manejo de excepcion de servicio no exitosa
     * @param ex Excepcion de servicio no exitosa
     * @return La entidad de respuesta que maneja el error como objeto
     */
    @ExceptionHandler(EmpleadoServiceException.class)
    public ResponseEntity<DefaultErrorList> handleEmpleadoServiceException(EmpleadoServiceException ex) {
    	LOGGER.error("Error en la ejecucion del servicio de Empleado", ex);
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_OPER_NO_EXITOSA)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

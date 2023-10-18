package com.empresa.ejercicio.util;

/**
 * 
 * @author 
 * 
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * 
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 */
public enum ErrorEnum {
	
	EXC_GENERICO("EXC.000", "Error generico", "Error generico de servidor", Constantes.ERROR, ""),

	EXC_ERROR_PARAMS("EXC.001", "Parametros invalidos", "Parametros invalidos de consumo", Constantes.WARNING, ""),
	
	EXC_DUPLICADO("EXC.100", "Empleado duplicado", "Empleado ya existe, no puede ser sobrescrito", Constantes.WARNING, ""),
	
	EXC_INEXISTENTE("EXC.101", "Empleado inexistente", "Empleado no existe, intente con otro valor", Constantes.WARNING, ""),
	
	EXC_OPER_NO_EXITOSA("EXC.102", "Operacion no exitosa", "Operacion no exitosa", Constantes.ERROR, ""),

	EXC_OPER_CON_ERRORES("EXC.103", "Operacion con errores", "Operacion con errores", Constantes.ERROR, "");

	/** codigo **/
    private final String code;
    
    /** mensaje **/
    private final String message;

    /** descripcion **/
	private final String description;

	/** level **/
    private final String level;

    /** mas informacion adicional **/
    private final String moreInfo;

    /**
     * ErrorEnum
     * @param code Un codigo de error unico, el cual pueda ser identificado y localizado para mas detalles
     * @param message Un mensaje de error claro
     * @param level  Un nivel de error: info, warning, error.
     * @param description Una descripcion detallada.
     * @param moreInfo Un link a la documentacion del codigo de error.
     */
    ErrorEnum(final String code, final String message, 
    		final String description, final String level, final String moreInfo ) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.level = level;
        this.moreInfo = moreInfo;
    }

    /**
     * Obtencion del codigo
     * @return code
     */
	public String getCode() {
		return code;
	}

	/**
	 * Obtencion del mensaje
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Obtencion de la descripcion
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Obtencion del level
	 * @return level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Obtencion de mas informacion
	 * @return moreInfo
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

}

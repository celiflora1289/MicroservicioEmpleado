package com.empresa.ejercicio.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import com.empresa.ejercicio.model.Empleado;
import com.empresa.ejercicio.service.IEmpleadosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

/**
 * 
 * @author 
 *
 * Esta clase se encarga de exponer los endpoints de acceso basado principios REST, para gestion de Empleados, Alta, modificacion, eliminacion
 * y listado de empleados
 * 
 */
@RestController
@RequestMapping("/empleados")
public class EjercicioController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EjercicioController.class);
	
	@Autowired
    private IEmpleadosService empleadosService;
	
	/**
	 * Metodo que recupera el listado de todos los empleados registrados
	 * @return Lista de empleados registrados
	 */
	@ApiOperation(
			value = "Listado de todos los empleados registrados en base de datos", 
			notes = "Lista de Empleados", 
			response = ResponseEntity.class, 
			httpMethod = "GET", 
			authorizations = {@Authorization(value="apiKey")})
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Empleado>> consultarEmpleados(){
		LOGGER.info("<consultarEmpleados controller>");
		Iterable<Empleado> response= empleadosService.consultarEmpleados();
		LOGGER.info("</consultarEmpleados controller>");
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Metodo para insertar uno o varios empleados en una sola peticion
	 * @param empleados lista de los empleados a insertar
	 * @return ResponseEntity con codigo HTTP correspondiente
	 */
	@ApiOperation(
			value = "Inserta uno o varios empleados en una sola peticion", 
			notes = "Inserción de empleados", 
			response = ResponseEntity.class, 
			httpMethod = "POST", 
			authorizations = {@Authorization(value="apiKey")})
	@PostMapping( consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> guardarEmpleados(@Valid @RequestBody List<Empleado> empleados, BindingResult result){
		LOGGER.info("<guardarEmpleados controller>");
		
		if(empleados!= null && !empleados.isEmpty()) {
			empleadosService.guardaEmpleados(empleados);
			LOGGER.info("</guardarEmpleados controller>");
			return ResponseEntity.ok().build();
		}else {
			LOGGER.error("No se inserta ningun empleado ya que la lista enviada es nula o vacia");
			return ResponseEntity.badRequest().build();
		}
	}
	
	/**
	 * Metodo para eliminacion de un empleado por ID de registro
	 * @param idEmpleado identificador del empleado
	 * @return ResponseEntity con codigo HTTP correspondiente
	 */
	@ApiOperation(
			value = "Eliminacion de un empleado por ID de registro", 
			notes = "Eliminacion de empleado", 
			response = ResponseEntity.class, 
			httpMethod = "DELETE", 
			authorizations = {@Authorization(value="apiKey")})
	@DeleteMapping( value = "/{idEmpleado}", produces = APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> eliminarEmpleado(final @PathVariable("idEmpleado") Integer idEmpleado){
		LOGGER.info("<eliminarEmpleado controller>");
		empleadosService.eliminarEmpleado(idEmpleado);
		LOGGER.info("</eliminarEmpleado controller>");
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Metodo para actualizacion de cualquier dato de un empleado
	 * @param idEmpleado identificador del empleado
	 * @param empleado objeto Empleado a actualizar
	 * @return ResponseEntity con codigo HTTP correspondiente
	 */
	@ApiOperation(
			value = "Actualizacion de cualquier dato de un empleado", 
			notes = "Actualizacion de empleado",
			response = ResponseEntity.class, 
			httpMethod = "PUT", 
			authorizations = {@Authorization(value="apiKey")})
	@PutMapping( value = "/{idEmpleado}", produces = APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> actualizaEmpleado(final @PathVariable("idEmpleado") Integer idEmpleado,  @RequestBody Empleado empleado){
		LOGGER.info("<actualizaEmpleado controller>");
		if(empleado!= null) {
			empleadosService.actualizaEmpleado(idEmpleado, empleado);
			LOGGER.info("</actualizaEmpleado controller>");
			return ResponseEntity.ok().build();
		}else {
			LOGGER.error("No se actualiza empleado porque no se envio el objeto a actualizar");
			return ResponseEntity.badRequest().build();
		}
	}
	
}

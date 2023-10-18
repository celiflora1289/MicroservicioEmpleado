package com.empresa.ejercicio.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.ejercicio.exception.EmpleadoInexistenteException;
import com.empresa.ejercicio.model.Empleado;
import com.empresa.ejercicio.repository.IEmpleadoRepository;

/**
 * 
 * @author 
 * Implementacion de la interfaz publica para las operaciones de negocio de la entidad Empleado, encargada de orquestador la logica de negocio relacionada 
 */
@Service
public class EmpleadosServiceImpl implements IEmpleadosService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadosServiceImpl.class);
	
	@Autowired
    private IEmpleadoRepository empleadoRepository;

	/**
	 * Obtencion de todos los empleados registrados
	 * @return Lista de empleados
	 */
	@Override
	public Iterable<Empleado> consultarEmpleados() {
		//Logica de negocio, en este caso solo obtener todos los empleados sin ningun complemento de info
		LOGGER.info("<consultarEmpleados service>");
		return empleadoRepository.findAll();
	}

	/**
	 * Insercion de 1 o N empleados
	 */
	@Override
	public void guardaEmpleados(List<Empleado> empleados) {
		//Logica de negocio, en este caso solo guardar empleados sin ningun complemento de info ni validacion especifica, de las validaciones de campos se encarga java validation
		LOGGER.info("<guardaEmpleados service>");
		empleadoRepository.saveAll(empleados);
	}

	/**
	 * Eliminacion de un empleado por ID
	 */
	@Override
	public void eliminarEmpleado(Integer idEmpleado) {
		//Logica de negocio, en este caso solo eliminar un empleado
		LOGGER.info("<eliminarEmpleado service>");
		Optional<Empleado> empleado= empleadoRepository.findById(idEmpleado);
		if(empleado.isPresent()) {
			empleadoRepository.deleteById(idEmpleado);
			LOGGER.info("</eliminarEmpleado service>");
		}else {
			new EmpleadoInexistenteException("El empleado no existe");
		}
	}

	/**
	 * Actualizacion de empleado, solo si existe, sino existe no se crea nuevo
	 */
	@Override
	public void actualizaEmpleado(Integer idEmpleado, Empleado empleado) {
		LOGGER.info("<actualizaEmpleado service>");
		//Logica de negocio, en este caso solo actualizar un empleado sin validaciones especificas, de las validaciones de campos se encarga java validation
		Optional<Empleado> objEmpleado= empleadoRepository.findById(idEmpleado);
		if(objEmpleado.isPresent()) {
			//Se actualiza todo el objeto, los campos no informados se guardan como null (si no son obligatorios, determinado por java validation)
//			empleado.setIdEmpleado(idEmpleado);
//			empleadoRepository.save(empleado);  
			
			LOGGER.info("Seteando datos para actualizacion de campos");
			//Se actualizan solo los campos que vienen informados (se utiliza ternario solo para ejemplificar condicion de que puede haber logica de negocio aqui)
			objEmpleado.get().setPrimerNombre((empleado.getPrimerNombre()!= null &!empleado.getPrimerNombre().isEmpty())? empleado.getPrimerNombre() : objEmpleado.get().getPrimerNombre());
//			objEmpleado.get().setSegundoNombre((empleado.getSegundoNombre()!= null &!empleado.getSegundoNombre().isEmpty())? empleado.getSegundoNombre() : objEmpleado.get().getSegundoNombre());
			//Ejemplo de registro sin validar campo null (para generar excepcion de ejemplo)
			objEmpleado.get().setSegundoNombre(!empleado.getSegundoNombre().isEmpty()? empleado.getSegundoNombre() : objEmpleado.get().getSegundoNombre());
			objEmpleado.get().setApePaterno((empleado.getApePaterno()!=null && !empleado.getApePaterno().isEmpty())? empleado.getApePaterno() : objEmpleado.get().getApePaterno());
			objEmpleado.get().setApeMaterno((empleado.getApeMaterno()!=null && !empleado.getApeMaterno().isEmpty())? empleado.getApeMaterno() : objEmpleado.get().getApeMaterno());
			//Validacion de >0 para generar excepcion controlada en caso de que no sea numerico
			objEmpleado.get().setEdad((empleado.getEdad()!=null && empleado.getEdad() > 0) ? empleado.getEdad() : objEmpleado.get().getEdad());
			objEmpleado.get().setGenero((empleado.getGenero()!=null && !empleado.getGenero().isEmpty())? empleado.getGenero() : objEmpleado.get().getGenero());
			objEmpleado.get().setPuesto((empleado.getPuesto() != null && !empleado.getPuesto().isEmpty())? empleado.getPuesto() : objEmpleado.get().getPuesto());
			objEmpleado.get().setFechaNacimiento((empleado.getFechaNacimiento() != null && !empleado.getFechaNacimiento().isEmpty())? empleado.getFechaNacimiento(): objEmpleado.get().getFechaNacimiento());
			
			empleadoRepository.save(objEmpleado.get()); 
			LOGGER.info("</actualizaEmpleado service>");
		}
	}

}

package com.empresa.ejercicio.repository;

import org.springframework.data.repository.CrudRepository;
import com.empresa.ejercicio.model.Empleado;

public interface IEmpleadoRepository extends CrudRepository<Empleado, Integer>{

}

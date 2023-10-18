package com.empresa.ejercicio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 
 * 
 * Modelo de datos Empleado
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="empleados")
public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** ID */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_empleado")
//	@JsonIgnore   //Si no se desea mostrar el campo en la salida, ignorar
	private Integer idEmpleado;
	
	/** Primer nombre */
	@Column(name= "primer_nombre")
//	@JsonProperty("primerNombre")  //Si se quiere nombrar con otra descripcion el campo en el JSON de entrada/salida
	private String primerNombre;
	
	/** Segundo nombre */
	@Column(name= "segundo_nombre")
	private String segundoNombre;
	
	/** Apellido materno */
	@Column(name= "ape_paterno")
	private String apePaterno;
	
	/** Apellido paterno */
	@Column(name= "ape_materno")
	private String apeMaterno;
	
	/** Edad */
	@Min(0)
	private Integer edad;
	
	/** Genero */
	private String genero;
	
	/** Fecha de nacimiento */
	@NotNull
	@Column(name= "fecha_nacimiento")
	private String fechaNacimiento;
	
	/** Puesto del empleado */
	@NotEmpty
	private String puesto;

}

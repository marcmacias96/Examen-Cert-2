package com.escolastico.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "estudiantes")
public class Estudiante extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Estudiante() {
		super();
	}

	public Estudiante(Long id) {
		super();
		this.setIdpersona(id);
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@NotNull
	@Column(name = "fecha_ingreso")
	private Calendar fechaIngreso;

	@Column(name = "procedencia")
	@Size(max = 55)
	private String procedencia;
	
	@Column(name = "observacion")
	@Size(max = 255)
	private String observacion;
	
	
	@Column(name = "lateralidad")
	@Size(max = 1)
	private String lateralidad;
	
	
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getLateralidad() {
		return lateralidad;
	}

	public void setLateralidad(String lateralidad) {
		this.lateralidad = lateralidad;
	}
	
	
}

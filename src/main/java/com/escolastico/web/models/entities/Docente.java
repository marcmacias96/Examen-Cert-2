package com.escolastico.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "docentes")
public class Docente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Docente() {
		super();
	}

	public Docente(Long id) {
		super();
		this.setIdpersona(id);
	}
	
	@Column(name = "grado")
	@Size(max = 35)
	private String grado;
	
	@Column(name = "institucion")
	@Size(max = 55)
	private String institucion;
	
	@Column(name = "email")
	@Size(max = 35)
	@Email
	private String email;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@NotNull
	@Column(name = "fecha_ingreso")
	private Calendar fechaIngreso;
	
	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
		
}

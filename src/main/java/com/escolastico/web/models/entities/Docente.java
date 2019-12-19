package com.escolastico.web.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
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

	@OneToMany(mappedBy = "docente", fetch = FetchType.LAZY)
	private List<Capacitacion> capacitacionList;

	public Long getAge(){
		LocalDate birthDate =LocalDateTime.ofInstant(getFechaNacimiento().toInstant(), getFechaNacimiento().getTimeZone().toZoneId()).toLocalDate();
		System.out.println(birthDate);
		LocalDate now = LocalDate.now();
		long years = ChronoUnit.YEARS.between(birthDate, now);
		return  years;
	}
	
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

	public List<Capacitacion> getCapacitacionList() {
		return capacitacionList;
	}

	public void setCapacitacionList(List<Capacitacion> capacitacionList) {
		this.capacitacionList = capacitacionList;
	}
}

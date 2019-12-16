package com.escolastico.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "destrezas")
public class Destreza implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_destreza")
	private Long iddestreza;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@NotNull
	@Column(name="fecha")	
	private Calendar fecha;
		
	@Column(name="descripcion")
	@Size(max=255)
	@NotEmpty
	private String descripcion;
	
	@Column(name="calificacion")
	@Size(max=15)
	@NotEmpty	
	private String calificacion;
		
	public Destreza() {
		super();	
	}
	
	public Destreza(Long id_destreza) {
		super();
		this.iddestreza = id_destreza;
	}

	public Long getIddestreza() {
		return iddestreza;
	}

	public void setIddestreza(Long iddestreza) {
		this.iddestreza = iddestreza;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	 
}

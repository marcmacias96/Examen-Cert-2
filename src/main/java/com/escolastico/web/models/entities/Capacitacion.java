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
@Table(name = "capacitaciones")
public class Capacitacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_capacitacion")
	private Long idcapacitacion;
	
	@Column(name="titulo")
	@Size(max=35)
	@NotEmpty
	private String titulo;
	
	@Column(name="descripcion")
	@Size(max=255)
	@NotEmpty
	private String descripcion;
	
	@Column(name="numero_horas")
	private int numeroHoras;
		
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@NotNull
	@Column(name="fecha")	
	private Calendar fecha;

	public Capacitacion() {
		super();	
	}
	
	public Capacitacion(Long id_capacitacion) {
		super();
		this.idcapacitacion = id_capacitacion;
	}
	

	public Long getIdcapacitacion() {
		return idcapacitacion;
	}

	public void setIdcapacitacion(Long idcapacitacion) {
		this.idcapacitacion = idcapacitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
 
}

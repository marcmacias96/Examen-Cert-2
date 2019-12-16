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
@Table(name = "vacunas")
public class Vacuna implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_vacuna")
	private Long idvacuna;
	
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
	
	@Column(name = "creado_por")
	@Size(max = 35)
	private String creadoPor;

	@Column(name = "creado_en")
	private Calendar creadoEn;

	@Column(name = "actualizado_por")
	@Size(max = 35)
	private String actualizadoPor;

	@Column(name = "actualizado_en")
	private Calendar actualizadoEn;
	
	public Vacuna() {
		super();	
	}
	
	public Vacuna(Long id_destreza) {
		super();
		this.idvacuna = id_destreza;
	}
	
	public Long getIdvacuna() {
		return idvacuna;
	}

	public void setIdvacuna(Long idvacuna) {
		this.idvacuna = idvacuna;
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

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Calendar getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(Calendar creadoEn) {
		this.creadoEn = creadoEn;
	}

	public String getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(String actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public Calendar getActualizadoEn() {
		return actualizadoEn;
	}

	public void setActualizadoEn(Calendar actualizadoEn) {
		this.actualizadoEn = actualizadoEn;
	}
 
}

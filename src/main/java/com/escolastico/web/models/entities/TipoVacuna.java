package com.escolastico.web.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_vacunas")
public class TipoVacuna implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_tipo_vacuna")
	private Integer idtipovacuna;
	
	@Column(name="enfermedad")
	@Size(max=55)
	@NotEmpty
	private String enfermedad;
	
	@Column(name="nombre")
	@Size(max=55)
	@NotEmpty
	private String nombre;
	
	@Column(name="numero_dosis")
	private int numeroDosis;
	
	@Column(name="dosis")
	@Size(max=35)
	@NotEmpty
	private String dosis;
	
	@Column(name="via")
	@Size(max=35)
	@NotEmpty
	private String via;
	
	@Column(name="edades")
	@Size(max=55)
	@NotEmpty
	private String edades;
		
	public TipoVacuna() {
		super();
	}
	
	public TipoVacuna(Integer id) {
		super();
		this.idtipovacuna = id;
	}
	
	public Integer getIdtipovacuna() {
		return idtipovacuna;
	}

	public void setIdtipovacuna(Integer idtipovacuna) {
		this.idtipovacuna = idtipovacuna;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getEdades() {
		return edades;
	}

	public void setEdades(String edades) {
		this.edades = edades;
	}
		
}

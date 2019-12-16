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
@Table(name = "avales")
public class Aval implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_aval")
	private Integer idaval;
	
	@Column(name="nombre")
	@Size(max=35)
	@NotEmpty
	private String nombre;
	
	public Aval() {
		super();
	}
	
	public Aval(Integer id) {
		super();
		this.idaval = id;
	}

	public Integer getIdaval() {
		return idaval;
	}

	public void setIdaval(Integer idaval) {
		this.idaval = idaval;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

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
@Table(name = "tipo_destrezas")
public class TipoDestreza implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_tipo_destreza")
	private Integer idtipodestreza;
	
	@Column(name="definicion")
	@Size(max=55)
	@NotEmpty
	private String definicion;
	
	@Column(name="descripcion")
	@Size(max=255)
	@NotEmpty
	private String descripcion;
	
	public TipoDestreza() {
		super();
	}
	
	public TipoDestreza(Integer id) {
		super();
		this.idtipodestreza = id;
	}
	
	public Integer getIdtipodestreza() {
		return idtipodestreza;
	}

	public void setIdtipodestreza(Integer idtipodestreza) {
		this.idtipodestreza = idtipodestreza;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}

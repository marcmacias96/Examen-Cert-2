package com.escolastico.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
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

	@OneToMany(mappedBy = "aval", fetch = FetchType.LAZY)
	private List<Capacitacion> capacitacionList;

	public List<Capacitacion> getCapacitacionList() {
		return capacitacionList;
	}

	public void setCapacitacionList(List<Capacitacion> capacitacionList) {
		this.capacitacionList = capacitacionList;
	}

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

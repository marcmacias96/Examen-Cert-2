package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.Docente;



public interface IDocenteService {

	public void save(Docente docente);
	public Docente findById(Long id);
	public void delete(Long id);
	public List<Docente> findAll();
}
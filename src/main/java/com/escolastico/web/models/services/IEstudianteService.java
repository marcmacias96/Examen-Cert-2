package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.Estudiante;



public interface IEstudianteService {

	public void save(Estudiante estudiante);
	public Estudiante findById(Long id);
	public void delete(Long id);
	public List<Estudiante> findAll();
}
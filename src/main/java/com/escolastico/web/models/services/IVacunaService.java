package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.Vacuna;



public interface IVacunaService {

	public void save(Vacuna vacuna);
	public Vacuna findById(Long id);
	public void delete(Long id);
	public List<Vacuna> findByEstudiante(Long id);
}
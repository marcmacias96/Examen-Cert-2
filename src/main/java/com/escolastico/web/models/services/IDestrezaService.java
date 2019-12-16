package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.Destreza;



public interface IDestrezaService {

	public void save(Destreza destreza);
	public Destreza findById(Long id);
	public void delete(Long id);
	public List<Destreza> findByEstudiante(Long id);
}
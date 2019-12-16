package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.Capacitacion;



public interface ICapacitacionService {

	public void save(Capacitacion capacitacion);
	public Capacitacion findById(Long id);
	public void delete(Long id);
	public List<Capacitacion> findByDocente(Long id);
}
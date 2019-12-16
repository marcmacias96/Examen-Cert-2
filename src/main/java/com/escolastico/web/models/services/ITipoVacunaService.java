package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.TipoVacuna;



public interface ITipoVacunaService {

	public void save(TipoVacuna tipoVacuna);
	public TipoVacuna findById(Integer id);
	public void delete(Integer id);
	public List<TipoVacuna> findAll();
}
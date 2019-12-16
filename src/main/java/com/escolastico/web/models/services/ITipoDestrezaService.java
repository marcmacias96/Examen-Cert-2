package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.TipoDestreza;



public interface ITipoDestrezaService {

	public void save(TipoDestreza tipoDestreza);
	public TipoDestreza findById(Integer id);
	public void delete(Integer id);
	public List<TipoDestreza> findAll();
}
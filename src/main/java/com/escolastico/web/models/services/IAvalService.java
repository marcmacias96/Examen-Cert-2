package com.escolastico.web.models.services;

import java.util.List;

import com.escolastico.web.models.entities.Aval;



public interface IAvalService {

	public void save(Aval aval);
	public Aval findById(Integer id);
	public void delete(Integer id);
	public List<Aval> findAll();
}
package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.IAval;
import com.escolastico.web.models.entities.Aval;

@Service
public class AvalService implements IAvalService{

	@Autowired 
	private IAval dao;
	@Override
	@Transactional
	public void save(Aval aval) {
		try {
			dao.save(aval);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Aval findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<Aval> findAll() {
		return (List<Aval>) dao.findAll();
	}

}

package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.ITipoDestreza;
import com.escolastico.web.models.entities.TipoDestreza;

@Service
public class TipoDestrezaService implements ITipoDestrezaService{

	@Autowired 
	private ITipoDestreza dao;
	@Override
	@Transactional
	public void save(TipoDestreza tipo) {
		try {
			dao.save(tipo);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public TipoDestreza findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoDestreza> findAll() {
		return (List<TipoDestreza>) dao.findAll();
	}

}

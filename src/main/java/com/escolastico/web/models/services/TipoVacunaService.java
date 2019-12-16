package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.ITipoVacuna;
import com.escolastico.web.models.entities.TipoVacuna;

@Service
public class TipoVacunaService implements ITipoVacunaService{

	@Autowired 
	private ITipoVacuna dao;
	@Override
	@Transactional
	public void save(TipoVacuna tipo) {
		try {
			dao.save(tipo);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public TipoVacuna findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoVacuna> findAll() {
		return (List<TipoVacuna>) dao.findAll();
	}

}

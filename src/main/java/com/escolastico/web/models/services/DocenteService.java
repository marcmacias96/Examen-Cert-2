package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.IDocente;
import com.escolastico.web.models.entities.Docente;

@Service
public class DocenteService implements IDocenteService{

	@Autowired 
	private IDocente dao;
	@Override
	@Transactional
	public void save(Docente docente) {
		try {
			dao.save(docente);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Docente findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<Docente> findAll() {
		return (List<Docente>) dao.findAll();
	}

}

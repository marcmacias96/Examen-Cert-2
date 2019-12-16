package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.IDestreza;
import com.escolastico.web.models.entities.Destreza;

@Service
public class DestrezaService implements IDestrezaService{

	@Autowired 
	private IDestreza dao;
	@Override
	@Transactional
	public void save(Destreza destreza) {
		try {
			dao.save(destreza);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Destreza findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<Destreza> findByEstudiante(Long id) {
		return null; //(List<Destreza>) dao.findByEstudiante(id);
	}

}

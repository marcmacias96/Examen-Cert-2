package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.ICapacitacion;
import com.escolastico.web.models.entities.Capacitacion;

@Service
public class CapacitacionService implements ICapacitacionService{

	@Autowired 
	private ICapacitacion dao;
	@Override
	@Transactional
	public void save(Capacitacion capacitacion) {
		try {
			dao.save(capacitacion);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Capacitacion findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<Capacitacion> findByDocente(Long id) {
		return (List<Capacitacion>) dao.findByDocente(id);
	}

}

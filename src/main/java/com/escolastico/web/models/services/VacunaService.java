package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.IVacuna;
import com.escolastico.web.models.entities.Vacuna;

@Service
public class VacunaService implements IVacunaService{

	@Autowired 
	private IVacuna dao;
	@Override
	@Transactional
	public void save(Vacuna tipo) {
		try {
			dao.save(tipo);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Vacuna findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<Vacuna> findByEstudiante(Long id) {
		return null; //(List<Vacuna>) dao.findByEstudiante(id);
	}

}

package com.escolastico.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.web.models.dao.IEstudiante;
import com.escolastico.web.models.entities.Estudiante;

@Service
public class EstudianteService implements IEstudianteService{

	@Autowired 
	private IEstudiante dao;
	@Override
	@Transactional
	public void save(Estudiante estudiante) {
		try {
			dao.save(estudiante);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Estudiante findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional(readOnly=true)
	public List<Estudiante> findAll() {
		return (List<Estudiante>) dao.findAll();
	}

}

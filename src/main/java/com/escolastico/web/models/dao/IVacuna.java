package com.escolastico.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escolastico.web.models.entities.Vacuna;


public interface IVacuna extends CrudRepository<Vacuna, Long> {
	
}

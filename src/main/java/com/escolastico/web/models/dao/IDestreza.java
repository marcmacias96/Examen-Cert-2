package com.escolastico.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escolastico.web.models.entities.Destreza;


public interface IDestreza extends CrudRepository<Destreza, Long> {
	
	
}

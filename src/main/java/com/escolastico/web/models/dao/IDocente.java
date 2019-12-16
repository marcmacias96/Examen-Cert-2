package com.escolastico.web.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.escolastico.web.models.entities.Docente;


public interface IDocente extends CrudRepository<Docente, Long> {

}

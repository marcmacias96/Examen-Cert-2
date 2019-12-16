package com.escolastico.web.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.escolastico.web.models.entities.Estudiante;


public interface IEstudiante extends CrudRepository<Estudiante, Long> {

}

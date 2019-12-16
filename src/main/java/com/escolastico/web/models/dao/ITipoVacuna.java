package com.escolastico.web.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.escolastico.web.models.entities.TipoVacuna;


public interface ITipoVacuna extends CrudRepository<TipoVacuna, Integer> {

}

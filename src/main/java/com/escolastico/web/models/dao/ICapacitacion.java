package com.escolastico.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.escolastico.web.models.entities.Capacitacion;

public interface ICapacitacion extends CrudRepository<Capacitacion, Long> {

    @Query("SELECT CAP FROM Capacitacion CAP WHERE CAP.docente.idpersona = :id")
    public List<Capacitacion> findByDocente(Long id);

}

package com.formacionbdi.microservicios.app.usuarios.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionbdi.microservicios.app.usuarios.model.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
	

}

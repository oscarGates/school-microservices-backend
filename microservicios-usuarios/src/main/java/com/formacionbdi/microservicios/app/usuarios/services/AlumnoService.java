package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.formacionbdi.microservicios.app.usuarios.model.entity.Alumno;

public interface AlumnoService {
	
	public Iterable<Alumno> findAll();
	
	public Optional<Alumno> findById(long id);
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(long id);
}

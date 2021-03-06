package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.usuarios.model.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.model.repositories.AlumnoRepository;

public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return repository.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}

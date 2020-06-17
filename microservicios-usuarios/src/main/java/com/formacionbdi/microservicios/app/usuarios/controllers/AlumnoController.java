package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.usuarios.model.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;

@RestController
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnoService;
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return  ResponseEntity.ok().body(alumnoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable long id){
		Optional<Alumno> alumno = alumnoService.findById(id);
		
		if(!alumno.isPresent()) 
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(alumno.get());
		
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno){
		Alumno alumnoDb = alumnoService.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Alumno alumno, @PathVariable long id){
		Optional<Alumno> o = alumnoService.findById(id);
		
		if(!o.isPresent()) 
			return ResponseEntity.notFound().build();
		
		Alumno alumnoDb =o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDb));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrar(@PathVariable long id){
		alumnoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}

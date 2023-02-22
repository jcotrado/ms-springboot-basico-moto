package com.convergenciax.moto.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.convergenciax.moto.service.entidades.Moto;
import com.convergenciax.moto.service.servicios.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {

	
	@Autowired
	private MotoService motoService;
	
	@GetMapping
	public ResponseEntity<List<Moto>> listarMotos(){
		List<Moto> motos  = motoService.getAll();
		if (motos.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(motos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id){
		Moto moto  = motoService.getMotoById(id);
		if ( moto  == null)  
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(moto);
	}
	
	@PostMapping
	public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto ){
		Moto nuevaMoto = motoService.save(moto);
		return ResponseEntity.ok(nuevaMoto);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id){
		List <Moto> moto  = motoService.byUsuarioId(id);
		if (moto .isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(moto );	
	} 
	
}

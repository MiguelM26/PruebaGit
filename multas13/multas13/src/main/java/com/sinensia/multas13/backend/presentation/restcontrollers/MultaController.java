package com.sinensia.multas13.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.multas13.backend.business.model.Multa;
import com.sinensia.multas13.backend.business.services.MultaServices;


@RestController
@RequestMapping("/matriculas")
@CrossOrigin
public class MultaController {
	@Autowired
	private MultaServices multaServices;
	

	
	@GetMapping
	public List<Multa> getMultas(@RequestParam(required=false) String matricula,
								@RequestParam(required=false) String codigo ){
		List<Multa> multas = null;
		
		if(matricula != null) {
			multas = multaServices.getByMatricula(matricula);
		}else if(codigo != null) {
			multas = multaServices.getByAgenteCodigo(codigo);
		}
		else {
			multas = multaServices.getAll();
		}
	
		return multas;
	}
	
	@GetMapping("/{codigo}")
	public Multa getByCodigo(@PathVariable Long codigo){
		Multa multa = null;
		
		if(codigo !=null) {
		 multa = multaServices.read(codigo);
		}
		
		return multa;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Multa multa, UriComponentsBuilder ucb){
		
		multaServices.create(multa);
		return ResponseEntity
				.created(ucb.path("/matriculas/{matricula}").build(multa.getMatricula()))
				.build();
	}
	
	
	
}

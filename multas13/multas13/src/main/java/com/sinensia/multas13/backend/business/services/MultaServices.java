package com.sinensia.multas13.backend.business.services;

import java.util.List;

import com.sinensia.multas13.backend.business.model.Multa;

public interface MultaServices {

	void create(Multa multa);
	
	Multa read(Long codigo);
	
	List<Multa> getAll();
	
	List<Multa> getByMatricula(String matricula);
	
	List<Multa>getByAgenteCodigo(String codigo);
}

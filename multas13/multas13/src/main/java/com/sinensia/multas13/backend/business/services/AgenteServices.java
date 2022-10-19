package com.sinensia.multas13.backend.business.services;

import java.util.List;

import com.sinensia.multas13.backend.business.model.Agente;


public interface AgenteServices {
	
	void create(Agente agente);
	
	Agente read(String codigo);
	
	List<Agente> getAll();

}

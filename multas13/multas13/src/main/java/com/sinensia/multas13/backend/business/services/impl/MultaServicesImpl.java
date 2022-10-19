package com.sinensia.multas13.backend.business.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.multas13.backend.business.model.Multa;
import com.sinensia.multas13.backend.business.services.MultaServices;
import com.sinensia.multas13.backend.services.repositories.MultaRepository;

@Service
public class MultaServicesImpl implements MultaServices{

	@Autowired 
	private MultaRepository multaRepository;
	
	@Override
	@Transactional
	public void create(Multa multa) {
		if(multa.getCodigo() != null) {
			throw new IllegalArgumentException("Para poder crear una multa su código ha de ser null");
		}
		
		 multaRepository.save(multa);
	}

	@Override
	@Transactional
	public Multa read(Long codigo) {
		
		return multaRepository.getByCodigo(codigo);
	}

	@Override
	@Transactional
	public List<Multa> getAll() {
		List<Multa> multas = multaRepository.findAll();
		return multas;
	}

	@Override
	@Transactional
	public List<Multa> getByMatricula(String matricula) {
		List<Multa> multas = multaRepository.getByMatricula(matricula);
		return multas;
	}

	@Override
	@Transactional
	public List<Multa> getByAgenteCodigo(String codigo) {
		List<Multa> multas = multaRepository.getByAgenteCodigo(codigo);
		return multas;
	}
}

package com.sinensia.multas13.backend.presentacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.multas13.backend.business.model.Multa;
import com.sinensia.multas13.backend.services.repositories.MultaRepository;

@Controller
@RequestMapping("/multas")
public class AppMultaController {

	@Autowired
	private MultaRepository multaRepository;
	
	@GetMapping("/listado-multas")
	public ModelAndView getPaginaListadoMultas(ModelAndView modelAndView) {
	List<Multa> multas = multaRepository.findAll();
		
		modelAndView.setViewName("listadomultas");
		
		modelAndView.addObject("multas", multas);
		
		return modelAndView;
	}
}

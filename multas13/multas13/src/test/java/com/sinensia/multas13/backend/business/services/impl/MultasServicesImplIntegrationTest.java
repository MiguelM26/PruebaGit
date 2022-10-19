package com.sinensia.multas13.backend.business.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.sinensia.multas13.backend.business.model.Agente;
import com.sinensia.multas13.backend.business.model.Multa;
import com.sinensia.multas13.backend.business.services.MultaServices;

@SpringBootTest
@Sql(scripts = {"/data/h2/schema.sql","/data/h2/data.sql"})
public class MultasServicesImplIntegrationTest {

	@Autowired
	private MultaServices multaServices;
	
	@BeforeEach
	void setUp() throws Exception {
		initMocks();
	}
	
	private Agente agente;
	private Multa multa1;
	private Multa multa2;
	
	
	@Test
	void testCreate(){
		
		Multa multa = new Multa();
		multa.setCodigo(null);
		multa.setInfraccion("Nuevo");
		
		multaServices.create(multa);
		
		Multa createdMulta = multaServices.read(1L);
		
		assertNotNull(createdMulta);
		assertEquals(createdMulta.getInfraccion(), "Nuevo");
		
	}
	
	@Test
	void testGetAll() {
		
		List<Multa> getAll = multaServices.getAll();
		
		assertEquals(3, getAll.size());
	}
	
	@Test
	void testgetByMatricula() {
		List<Multa> multasMatricula = multaServices.getByMatricula("1");
		assertEquals(1, multasMatricula.size());
		assertTrue( multasMatricula.contains(multa1));
	}
	
	@Test
	void getByAgenteCodigo() {
		List<Multa> multas = multaServices.getByAgenteCodigo("46778234R");
		assertEquals(1, multas.size());
		assertTrue(multas.contains(multa1));
	}
	
	// ***************************************************************
		//
		// PRIVATE METHODS
		//
		// ***************************************************************	
		
		private void initMocks() throws Exception {
			multa1 = new Multa();
			multa2 = new Multa();
			agente = new Agente();
			
			multa1.setCodigo(10L);
			multa1.setMatricula("1");
			multa2.setMatricula("2");
			multa2.setCodigo(20L);
			
			multa1.setInfraccion("aparcar");
			multa2.setInfraccion("pegar");
			
			agente.setCodigo("1");
			
			multa1.setAgente(agente);
		}
	
}

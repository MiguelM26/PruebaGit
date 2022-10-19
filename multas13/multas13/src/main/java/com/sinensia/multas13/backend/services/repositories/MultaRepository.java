package com.sinensia.multas13.backend.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sinensia.multas13.backend.business.model.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long>{

	@Query("SELECT m FROM Multa m WHERE m.codigo = :codigo")
	Multa getByCodigo(Long codigo);
	
	@Query("SELECT m FROM Multa m WHERE m.matricula = :matricula")
	List<Multa> getByMatricula(String matricula);
	
	@Query("SELECT m FROM Multa m WHERE m.agente.codigo = :codigo")
	List<Multa> getByAgenteCodigo(String codigo);
}

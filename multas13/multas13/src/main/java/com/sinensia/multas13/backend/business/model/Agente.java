package com.sinensia.multas13.backend.business.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AGENTES")
public class Agente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	private String codigo;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	
	public Agente() {
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agente other = (Agente) obj;
		return Objects.equals(codigo, other.codigo);
	}


	@Override
	public String toString() {
		return "Agente [nombre=" + nombre + ", codigo=" + codigo + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + "]";
	}
	
}

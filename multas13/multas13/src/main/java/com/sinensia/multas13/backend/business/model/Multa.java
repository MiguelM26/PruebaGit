package com.sinensia.multas13.backend.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="MULTAS")
public class Multa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@TableGenerator(name = "GENERADOR",
			table = "SECUENCIAS",
			pkColumnName = "NOMBRE",
			pkColumnValue = "PRODUCTO_SEQ",
			valueColumnName = "VALOR",
			allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="GENERADOR")
	@Id
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_AGENTE")
	private Agente agente;
	
	private String matricula;
	private Date fechaHora;
	private Double importe;
	private String infraccion;
	private String lugar;
	private String observaciones;
	
	
	public Multa() {


	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Agente getAgente() {
		return agente;
	}


	public void setAgente(Agente agente) {
		this.agente = agente;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Date getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}


	public String getInfraccion() {
		return infraccion;
	}


	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	@Override
	public String toString() {
		return "Multas [codigo=" + codigo + ", agente=" + agente + ", matricula=" + matricula + ", fechaHora="
				+ fechaHora + ", importe=" + importe + ", infraccion=" + infraccion + ", lugar=" + lugar
				+ ", observaciones=" + observaciones + "]";
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
		Multa other = (Multa) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	

}

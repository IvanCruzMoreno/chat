package com.badbadcode.application.models.documents;

import java.io.Serializable;

public class Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Long fecha;
	
	
	public String getTexto() {
		return texto;
	}
	public Long getFecha() {
		return fecha;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	
}

package com.badbadcode.application.models.documents;

import java.io.Serializable;

public class Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Long fecha;
	private String username;
	private String tipo;
	private String color;
	
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
	public String getUsername() {
		return username;
	}
	public String getTipo() {
		return tipo;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}

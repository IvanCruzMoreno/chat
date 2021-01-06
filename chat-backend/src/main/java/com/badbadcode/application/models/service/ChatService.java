package com.badbadcode.application.models.service;

import java.util.List;

import com.badbadcode.application.models.documents.Mensaje;

public interface ChatService {

	public List<Mensaje> obtenerUltimos10Mensajes();
	public Mensaje guardar(Mensaje mensaje);
}

package com.badbadcode.application.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.badbadcode.application.models.documents.Mensaje;

@Controller
public class ChatController {

	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());
		mensaje.setTexto("Recibido por el broker: ".concat(mensaje.getTexto()));
		return mensaje;
	}
}

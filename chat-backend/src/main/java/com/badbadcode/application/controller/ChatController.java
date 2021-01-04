package com.badbadcode.application.controller;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.badbadcode.application.models.documents.Mensaje;

@Controller
public class ChatController {
	
	private Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	private String colores[] = {"red", "green", "blue", "magenta", "purple", "orange"};
	
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());

		if(mensaje.getTipo().equals("NUEVO_USUARIO")) {
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("nuevo usuario");
		}
		logger.info(mensaje.getTexto());
		logger.info(mensaje.getUsername());
		logger.info(mensaje.getTipo());
		return mensaje;
	}
}

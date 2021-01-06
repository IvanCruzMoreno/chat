package com.badbadcode.application.controller;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.badbadcode.application.models.documents.Mensaje;
import com.badbadcode.application.models.service.ChatService;

@Controller
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	private Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	private String colores[] = {"red", "green", "blue", "magenta", "purple", "orange"};
	
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());

		if(mensaje.getTipo().equals("NUEVO_USUARIO")) {
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("nuevo usuario");
		}else {
			chatService.guardar(mensaje);
		}
		
		logger.info(mensaje.getTexto());
		logger.info(mensaje.getUsername());
		logger.info(mensaje.getTipo());
		return mensaje;
	}
	@MessageMapping("/escribiendo")
	@SendTo("/chat/escribiendo")
	public String estaEscribiendo(String username) {
		return username.concat(" esta escribiendo...");
	}
	@MessageMapping("/historial")
	//@SendTo("/chat/historial") -- ya lo estamos haciendo con la instancia de SimpMessagingTemplate
	public void historial(String clienteId){
		logger.info(chatService.obtenerUltimos10Mensajes().get(3).getUsername());
		webSocket.convertAndSend("/chat/historial/" + clienteId, chatService.obtenerUltimos10Mensajes());
	}
}

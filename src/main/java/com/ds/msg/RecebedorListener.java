package com.ds.msg;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 
 * @author diego.soares
 * Classe listener que busca uma mensagem na fila
 */
@Component
@RabbitListener(queues = "teste-fila")
public class RecebedorListener {


	@RabbitHandler	
	public void metodoRecepitor(final @Payload UsuarioMessage message) {
		System.out.println(message.getNome());
	}
	
}

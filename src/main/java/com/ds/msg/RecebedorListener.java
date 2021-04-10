package com.ds.msg;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author diego.soares
 * Classe listener que busca uma mensagem na fila
 */
@Component
@RabbitListener
public class RecebedorListener {


	@RabbitHandler	
	public void metodoRecepitor(String message) {
		System.out.println(message);
	}
	
}

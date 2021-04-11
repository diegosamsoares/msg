package com.ds.msg;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author diego.soares
 * Classe que seta as configurações dos listeners
 */

@Configuration
public class MessagesConfiguration {

	static final String topicExchangeName = "teste-mensageria-exchange"; //NOME DO EXCHANGE
	static final String queueName = "teste-fila"; //NOME DA FILA

	@Bean
	Queue queue() {//CRIA A FILA
		return new Queue(queueName,false);
		
	}
	
	@Bean
	TopicExchange exchage() {//CRIA O EXCHANGE
		return new TopicExchange(topicExchangeName);
		
	}
	
	@Bean
	Binding binding(Queue queue , TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("chave.teste"); //FAZ O BINDING DA FILA COM EXCHANGE E A ROUTING KEY
		
	}
	
	
	
	
	
}

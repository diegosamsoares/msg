package com.ds.msg;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
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
	
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {//SETA A FILA DO LISTENER
		SimpleMessageListenerContainer container = new  SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(messageListenerAdapter);
		return container;
	}
	
	@Bean
	MessageListenerAdapter listenerAdapter(RecebedorListener receiver) {
		return new MessageListenerAdapter(receiver, "metodoRecepitor");//SETA A CLASSE RECEIVER COMO UM LISTENER E SETA O MÉTODO QUE VAI RECEBER
	}
}
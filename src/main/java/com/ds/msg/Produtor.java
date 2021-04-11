package com.ds.msg;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 
 * @author diego.soares
 * Classe que posta uma mensagem na fila
 */
@Component
public class Produtor implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;

  public Produtor(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("INICIO ENVIO DE MENSAGEM PARA A FILA...");
    UsuarioMessage usuario = new UsuarioMessage();
    usuario.setNome("DIEGO");
    rabbitTemplate.convertAndSend(MessagesConfiguration.topicExchangeName, "chave.teste" , usuario);
  }

}
package com.ds.msg;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;

  public Runner(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("INICIO ENVIO DE MENSAGEM PARA A FILA...");
    rabbitTemplate.convertAndSend(MsgApplication.topicExchangeName, "chave.teste", "ESSA MENSAGEM ESTA NA FILA!");
  }

}
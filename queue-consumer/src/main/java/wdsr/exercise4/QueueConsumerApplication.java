package wdsr.exercise4;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QueueConsumerApplication {

	private static final String JMS_BROKER_URL = "tcp://localhost:61616";
	
	@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(JMS_BROKER_URL);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(QueueConsumerApplication.class, args);
	}
}

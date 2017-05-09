package wdsr.exercise4;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TopicPublisherApplication {

	private static final String JMS_BROKER_URL = "tcp://localhost:61616";

	private static final Logger log = LoggerFactory.getLogger(TopicPublisherApplication.class);

	@Autowired
	private Publisher publisher;
	
	@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(JMS_BROKER_URL);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TopicPublisherApplication.class, args);
	}
	
	@PostConstruct
	private void send10000PersistentCommunicates() {
		long startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++){
			publisher.sendTextPersistent("test_" + i);
		}
		long stopTime = System.nanoTime();
		log.info("10000 persistent messages sent in " +  (stopTime - startTime)  + " milliseconds");
	} 
	
	@PostConstruct
	public void send10000NonPersistentCommunicates() {
		long startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++){
			publisher.sendTextNonPersistent("test_" + i);
		}
		long stopTime = System.nanoTime();
		log.info("10000 non-persistent messages sent in " +  (stopTime - startTime)  + " milliseconds");
	}
}

package wdsr.exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	private static final String TOPIC_NAME = "MWYG.TOPIC";

	public void sendTextPersistent(String text) {
		jmsTemplate.convertAndSend(TOPIC_NAME , text); 
	}
	
	public void sendTextNonPersistent(String text) {
		jmsTemplate.setDeliveryPersistent(false);
		jmsTemplate.convertAndSend(TOPIC_NAME, text);  
	}
	
}

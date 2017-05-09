package wdsr.exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	private static final String QUEUE_NAME = "MWYG.QUEUE";

	public void sendTextPersistent(String text) {
		jmsTemplate.convertAndSend(QUEUE_NAME, text); 
	}
	
	public void sendTextNonPersistent(String text) {
		jmsTemplate.setDeliveryPersistent(false);
		jmsTemplate.convertAndSend(QUEUE_NAME, text);  
	}

}

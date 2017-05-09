package wdsr.exercise4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

	private static final Logger log = LoggerFactory.getLogger(Listener.class);

	private static final String QUEUE_NAME = "MWYG.QUEUE";
	
	@JmsListener(destination = QUEUE_NAME)
	public void consume(String msg){
		log.info(msg);
	}
}

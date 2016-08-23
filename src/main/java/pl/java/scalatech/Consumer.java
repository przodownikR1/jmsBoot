package pl.java.scalatech;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Profile("normal")
@Component
@Slf4j
public class Consumer {

	@JmsListener(destination = JmsBootApplication.SAMPLE_QUEUE)
	public void receiveQueue(String text) {
		log.info("receive text : {}",text);
	}

}
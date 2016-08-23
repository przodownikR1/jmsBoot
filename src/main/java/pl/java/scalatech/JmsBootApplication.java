package pl.java.scalatech;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class JmsBootApplication {

  
    public static final String SAMPLE_QUEUE = "sample.queue";

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(SAMPLE_QUEUE);
}
    
    @Bean 
    JmsTransactionManager jmsTransationManager(final ConnectionFactory connectionFactory){
        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager(connectionFactory);
        return jmsTransactionManager;
    }
    
    @Bean
    JmsComponent jmsComponent(ConnectionFactory connectionFactory,final JmsTransactionManager jmsTransactionManager,@Value("${max.concurrent.consumer}")int maxConsumer){
        JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(connectionFactory,jmsTransactionManager);
        jmsComponent.setMaxConcurrentConsumers(maxConsumer);
        return jmsComponent ;
        
    }
    
	public static void main(String[] args) {
		SpringApplication.run(JmsBootApplication.class, args);
	}

}

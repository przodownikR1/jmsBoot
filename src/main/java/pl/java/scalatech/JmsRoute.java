package pl.java.scalatech;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JmsRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
       from("{{start.jms}}").transacted().log(LoggingLevel.INFO,log,"Receive:  ${body}").process(new Processor() {
        
        @Override
        public void process(Exchange exchange) throws Exception {
            log.info("+++ {}",exchange.getIn().getBody());
            
        }
    }).end();
        
    }

}

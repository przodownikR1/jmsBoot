package pl.java.scalatech;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile("camel")
@Component
public class JmsRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
       from("{{start.jms}}").transacted().log(LoggingLevel.INFO,log,"Receive:  ${body}").process(exchange -> log.info("+++ {}",exchange.getIn().getBody())).end();
        
    }

}

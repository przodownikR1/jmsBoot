package pl.java.scalatech.config;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MyAppConfig {
	@Autowired
	ApplicationContext appContext;

	@Bean
	CamelContextConfiguration contextConfiguration() {
		return new CamelContextConfiguration() {
			@Override
			public void beforeApplicationStart(CamelContext context) {
			    log.info("before context : {}",context);
			}

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                log.info("after context : {}",camelContext);
                
            }
		};
	}
}
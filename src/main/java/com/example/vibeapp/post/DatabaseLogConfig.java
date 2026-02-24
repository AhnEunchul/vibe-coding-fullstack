package com.example.vibeapp.post;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DatabaseLogConfig {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseLogConfig.class);

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.info("====================================================");
        logger.info("H2 Console JDBC URL: jdbc:h2:file:./data/testdb");
        logger.info("H2 User: sa / Password: (empty)");
        logger.info("====================================================");
    }
}

package org.gonzalez.finalprojectm320.config;

import org.gonzalez.finalprojectm320.repository.MongoDBRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    MongoDBRepository getMongoDBRepository() {
        return new MongoDBRepository();
    }
}

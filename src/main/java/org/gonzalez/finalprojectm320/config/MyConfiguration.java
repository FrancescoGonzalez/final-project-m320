package org.gonzalez.finalprojectm320.config;

import org.gonzalez.finalprojectm320.repository.MongoDBRepository;
import org.gonzalez.finalprojectm320.repository.RepositoryInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    RepositoryInterface getRepositoryInterface() {
        return new MongoDBRepository();
    }
}

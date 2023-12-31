package br.com.oriedroc.api.config;

import br.com.oriedroc.api.domain.User;
import br.com.oriedroc.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Danilo", "danilo@ori.com", "12300");
        User u2 = new User(null, "Ju", "juli@ori.com", "12300");

        userRepository.saveAll(List.of(u1,u2));
    }
}

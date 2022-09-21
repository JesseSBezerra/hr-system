package br.com.jdsb.userapi;

import br.com.jdsb.userapi.domain.User;
import br.com.jdsb.userapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@EnableEurekaClient
public class UserApiApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     userRepository.saveAll(List.of(new User(null,"Jesse Bezerra","jessebezerra@hotmail.com","123",20.0)
                                    ,new User(null,"Monique Franca","moniqueFranca@hotmail.com","123",20.0))
                                  );
    }
}

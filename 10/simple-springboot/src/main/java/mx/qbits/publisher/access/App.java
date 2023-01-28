package mx.qbits.publisher.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class App {    
    public static void main(String[] args) {
        log.info("Iniciando contexto de Spring with ID: {}", "0101");
        SpringApplication.run(App.class, args);
    }
}

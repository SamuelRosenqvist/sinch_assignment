package polish_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ExpressionRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new PolishExpression("+ + 0.5 1.5 * 4 10")));
            log.info("Preloading " + repository.save(new PolishExpression("+ 1")));
        };
    }
}
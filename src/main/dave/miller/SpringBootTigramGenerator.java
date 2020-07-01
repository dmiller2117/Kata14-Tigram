package dave.miller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTigramGenerator implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootTigramGenerator.class);

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringBootTigramGenerator.class);
        app.run(args);

    }

    @Override
    public void run(ApplicationArguments args) {

        logger.info("hello world");

    }
}

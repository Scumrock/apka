package ru.tversu.apka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.tversu.apka.config.ApplicationProperties;

@EnableAspectJAutoProxy
@EnableTransactionManagement
@EntityScan("ru.tversu.apka.domain")
@EnableJpaRepositories(basePackages = {"ru.tversu.apka.repository"})
@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class ApkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApkaApplication.class, args);
  }

}

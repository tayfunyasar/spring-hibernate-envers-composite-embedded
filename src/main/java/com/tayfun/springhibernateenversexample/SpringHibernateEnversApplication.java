package com.tayfun.springhibernateenversexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@Slf4j
public class SpringHibernateEnversApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateEnversApplication.class, args);
    }
}

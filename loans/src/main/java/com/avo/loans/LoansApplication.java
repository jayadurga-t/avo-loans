package com.avo.loans;

import com.avo.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Loans Microservice REST API Documentation",
                description = "Avo Bank Loans Microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Avo Bank Loans - Development Team",
                        email = "loans.dev@avo.com",
                        url = "http://localhost:8090/swagger-ui/index.html#/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://localhost:8090/swagger-ui/index.html#/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "External Documentation for Avo Bank Microservices REST API Documentation",
                url = "http://localhost:8090/swagger-ui/index.html#/"
        )
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}

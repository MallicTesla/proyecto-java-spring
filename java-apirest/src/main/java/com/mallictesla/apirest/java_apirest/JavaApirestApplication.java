package com.mallictesla.apirest.java_apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class JavaApirestApplication {

	public static void main(String[] args) {

        // Cargar el archivo .env
        Dotenv dotenv = Dotenv.configure()
                .directory("C:/Users/Mallic/Desktop/Programas/proyecto-java-spring/java-apirest")  // Ruta del archivo .env
                .load();

		// C:\Users\Mallic\Desktop\Programas\proyecto-java-spring\java-apirest\pom.xml

		SpringApplication.run(JavaApirestApplication.class, args);
	}

}

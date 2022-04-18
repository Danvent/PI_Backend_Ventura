package com.proyect.deparment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DeparmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeparmentApplication.class, args);
	}

	// public WebMvcConfigurer corsConfigurer(){
	// 	return new WebMvcConfigurer() {
	// 		public void addCorsMappings(CorsRegistry registry){
	// 			registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	// 		}
	// 	};
	// }

}

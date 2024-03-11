package homecare.mega;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import homecare.mega.dto.request.RegisterRequest;
import homecare.mega.enumerated.Role;
import homecare.mega.service.UserService;

@SpringBootApplication
public class MegaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegaApplication.class, args);
	}


	// @Bean
	// public CommandLineRunner commandLineRunner(UserService userService)
	// {
	// 	return args->{
	// 		var user=RegisterRequest.builder()
	// 		.name("Admin")
	// 		.email("admin@gmail.com")
	// 		.role("ADMIN")
	// 		.password("Admin@123")
	// 		.build();
	// 		userService.register(user);
	// 	};
	// }

}

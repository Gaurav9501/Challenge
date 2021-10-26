package Challenge.Challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import Challenge.Challenge.DAO.*;
@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
     SpringApplication.run(ChallengeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

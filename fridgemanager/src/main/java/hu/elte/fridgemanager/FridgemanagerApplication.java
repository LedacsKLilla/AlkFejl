package hu.elte.fridgemanager;

import hu.elte.fridgemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FridgemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FridgemanagerApplication.class, args);
	}
        
            @Autowired
            private UserRepository userRepository;

            @Autowired
            private BCryptPasswordEncoder passwordEncoder;

}

package store.zabbix.apartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SendWheatherMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendWheatherMailApplication.class, args);
	}

}

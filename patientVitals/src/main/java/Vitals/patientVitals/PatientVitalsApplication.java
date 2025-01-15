package Vitals.patientVitals;
  
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@SpringBootApplication
public class PatientVitalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientVitalsApplication.class, args);
	}

}

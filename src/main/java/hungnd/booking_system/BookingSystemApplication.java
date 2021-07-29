package hungnd.booking_system;

import hungnd.booking_system.global.ConfigInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

@SpringBootApplication
public class BookingSystemApplication {

    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put("server.port", ConfigInfo.SERVICE_PORT);

        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder()
                .sources(BookingSystemApplication.class)
                .properties(prop);
        applicationBuilder.run(args);
    }

}

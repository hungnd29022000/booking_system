package hungnd.booking_system;

import hungnd.booking_system.global.ConfigInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/login").allowedMethods("*");
            }
        };
    }

}

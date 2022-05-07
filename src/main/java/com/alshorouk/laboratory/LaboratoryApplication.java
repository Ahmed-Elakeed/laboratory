package com.alshorouk.laboratory;

import com.alshorouk.laboratory.Service.ArabPatientService;
import com.alshorouk.laboratory.Service.ForeignPatientService;
import com.alshorouk.laboratory.model.ArabPatient;
import com.alshorouk.laboratory.model.ForeignPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class LaboratoryApplication implements CommandLineRunner {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    public static void main(String[] args) {
        SpringApplication.run(LaboratoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

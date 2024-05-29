package com.patika.odev1;

import com.patika.odev1.service.ApplicationService;
import com.patika.odev1.service.Seed;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {
        ApplicationService service = new ApplicationService(new Seed());
        service.print();
    }
}



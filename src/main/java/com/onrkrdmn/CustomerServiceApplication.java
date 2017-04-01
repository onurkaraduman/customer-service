package com.onrkrdmn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("********************************************");
        System.out.println("*      customer-service BACKEND API        *");
        System.out.println("*      developed by Onur Karaduman         *");
        System.out.println("********************************************");
    }
}

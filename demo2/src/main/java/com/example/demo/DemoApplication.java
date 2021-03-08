package com.example.demo;

import com.example.demo.pojos.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private Result result;


    public static void main(String[] args)  {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        if (args.length == 2) {
            if(args[0].toString().endsWith("xlsx") | args[1].toString().endsWith("xlsx"))
                System.out.println("Files with xlsx extension will not be parsed");
            else if (args[0].toString().endsWith("csv") & args[1].toString().endsWith("json")){
                result.readCSV(args[0].toString());
                result.parseAnalizeJson(args[1].toString());
            }
            else if(args[1].toString().endsWith("csv") & args[0].toString().endsWith("json")) {
                result.readCSV(args[1].toString());
                result.parseAnalizeJson(args[0].toString());
                }
            else {
                System.out.println("files have no csv or json extensions");
            }
        }
        else {
            System.out.println("No files names as arguments were passed or gave less than 2 arguments");
        }

    }
}

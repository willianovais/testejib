package com.example.teste.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.*;

@RestController
public class demoController {

    @GetMapping("/teste")
    public String getTeste(@RequestParam(defaultValue = "Sucesso!") String response) {
        Object logger = null;
        System.out.println(response);
        return response;
    }
}

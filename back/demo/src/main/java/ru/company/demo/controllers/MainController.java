package ru.company.demo.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/unsequred")
    public String unsequredData(){
        return "Unsecured data";
    }

    @GetMapping("/sequred")
    public String sequredData(){
        return "Secured data";
    }

    @GetMapping("/admin")
    public String adminData(){
        return "Admin data";
    }

    @GetMapping("/info")
    public String userData(Principal principal){
        return principal.getName();
    }



}

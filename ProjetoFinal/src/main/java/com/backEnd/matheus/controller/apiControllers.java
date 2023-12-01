package com.backEnd.matheus.controller;

import com.backEnd.matheus.models.User;
import com.backEnd.matheus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class apiControllers {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String getPage(){

        return "<h1>Projeto Java: Matheus Alcantara / Rafhael Matias</h1>";

    }

    @GetMapping(value = "/usuarios")
    public List<User> obterUsuarios(){
        return userRepository.findAll();
    }

}

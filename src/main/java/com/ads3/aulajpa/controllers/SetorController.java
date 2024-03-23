package com.ads3.aulajpa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads3.aulajpa.entities.Setor;
import com.ads3.aulajpa.repository.SetoRepository;

@RestController
@RequestMapping("/setor")
public class SetorController {

    @Autowired

    SetoRepository repository;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(Setor setor) {

        repository.save(setor);

        return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.OK);

    }

    @GetMapping("/lista")
    public ResponseEntity<List<Setor>> listar() {
        List<Setor> setores = new ArrayList<>();
        setores = repository.findAll();

        return new ResponseEntity<>(setores, HttpStatus.OK);

    }

}
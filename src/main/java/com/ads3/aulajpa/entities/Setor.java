package com.ads3.aulajpa.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nome;

    @ManyToOne(cascade = CascadeType.REFRESH) // Quando na tabela for pra muito é ManyTo One
    private Empresa empresa;

    public Setor() {
    }

    public Setor(int id, String nome, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}

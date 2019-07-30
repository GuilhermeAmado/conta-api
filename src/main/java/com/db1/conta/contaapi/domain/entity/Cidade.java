package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Cidade {

    private Long id;

    private String nome;

    private Estado estado;

    public Cidade(String nome, Estado estado) {
        Assert.hasText(nome, "Nome é obrigatório");
        Assert.notNull(estado, "Estado é obrigatório");
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }
}
package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "cidade", uniqueConstraints = @UniqueConstraint(columnNames = { "nome", "estado" }))
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 2, nullable = false)
    private Estado estado;

    protected Cidade() {}               // construtor para o JPA

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
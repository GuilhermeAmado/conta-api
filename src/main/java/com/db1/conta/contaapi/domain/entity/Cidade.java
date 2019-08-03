package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "cidade", uniqueConstraints = @UniqueConstraint(columnNames = { "nome", "estado" }))  // nome de cidade não pode se repetir em um estado
public class Cidade {

    public static final String NOME_OBRIGATORIO = "Informar o nome da cidade é obrigatório";
    public static final String ESTADO_OBRIGATORIO = "Informar o nome do estado é obrigatório";
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
        Assert.hasText(nome, NOME_OBRIGATORIO);
        Assert.notNull(estado, ESTADO_OBRIGATORIO);
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
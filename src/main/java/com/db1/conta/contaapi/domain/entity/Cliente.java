package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = { "nome", "cpf" }))
public class Cliente {

    public static final String INFORMAR_NOME_OBRIGATORIO = "Informar o nome é obrigatorio";
    public static final String INFORMAR_ENDERECO_OBRIGATORIO = "Informar endereços é obrigatório";
    public static final String INFORMAR_CONTA_OBRIGATORIO = "Informar contas é obrigatório";
    public static final String INFORMAR_CPF_OBRIGATORIO = "Informar o CPF é obrigatório";
    public static final String CPF_INVALIDO = "CPF inválido";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @OneToMany
    @JoinColumn(name = "fk_listaEnderecos")
    private List<Endereco> listaEnderecos = new ArrayList<Endereco>();

    @OneToMany
    @JoinColumn(name = "fk_listaContas")
    private List<Conta> listaContas = new ArrayList<Conta>();

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    protected Cliente() {}               // construtor para o JPA


    public Cliente(String nome, String cpf) {
        Assert.hasText(nome, INFORMAR_NOME_OBRIGATORIO);
        Assert.notNull(listaEnderecos, INFORMAR_ENDERECO_OBRIGATORIO);
        Assert.notNull(listaContas, INFORMAR_CONTA_OBRIGATORIO);
        Assert.hasText(cpf, INFORMAR_CPF_OBRIGATORIO);
        Assert.isTrue(cpf.length() == 11, CPF_INVALIDO);

        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public String getCpf() {
        return cpf;
    }

    public long getId() {
        return id;
    }
}

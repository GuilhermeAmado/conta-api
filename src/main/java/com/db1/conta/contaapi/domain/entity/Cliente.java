package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    public static final String INFORMAR_NOME_OBRIGATORIO = "Informar o nome é obrigatorio";
    public static final String INFORMAR_CPF_OBRIGATORIO = "Informar o CPF é obrigatório";
    public static final String CPF_INVALIDO = "CPF inválido";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Endereco> listaEnderecos = new ArrayList<Endereco>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Conta> listaContas = new ArrayList<Conta>();

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    protected Cliente() {}               // construtor para o JPA


    public Cliente(String nome, String cpf) {
        Assert.hasText(nome, INFORMAR_NOME_OBRIGATORIO);
        Assert.hasText(cpf, INFORMAR_CPF_OBRIGATORIO);
        Assert.isTrue(cpf.length() == 11, CPF_INVALIDO);

        this.nome = nome;
        this.cpf = cpf;
    }

    public void addEndereco(Cliente cliente, String logradouro, String numero, String complemento, Cidade cidade, EnderecoTipo enderecoTipo, String cep) {
        Endereco endereco = new Endereco(this, logradouro, numero, complemento, cidade, enderecoTipo, cep);
        this.listaEnderecos.add(endereco);
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

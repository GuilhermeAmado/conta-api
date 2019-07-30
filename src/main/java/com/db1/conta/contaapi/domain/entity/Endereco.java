package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Endereco {

    private long id;
    private Cliente cliente;
    private String logradouro;
    private String numero;
    private Cidade cidade;
    private EnderecoTipo enderecoTipo;
    private String complemento;
    private String cep;

    public Endereco(Cliente cliente, String logradouro, String numero, String complemento, Cidade cidade, EnderecoTipo enderecoTipo, String cep) {
        Assert.notNull(cliente, "Informar o cliente é obrigatório");
        Assert.hasText(logradouro, "Informar o logradouro é obrigatório");
        Assert.hasText(numero, "Informar o número é obrigatório");
        Assert.notNull(cidade, "Informar a cidade é obrigatório");
        Assert.notNull(enderecoTipo, "Informar o tipo de endereço é obrigatório");
        Assert.isTrue(cep.length() == 8, "CEP inválido");

        this.cliente = cliente;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.enderecoTipo = enderecoTipo;
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public EnderecoTipo getEnderecoTipo() {
        return enderecoTipo;
    }

    public String getComplemento() {
        return complemento;
    }
}

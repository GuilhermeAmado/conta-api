package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Endereco {

    public static final String INFORMAR_CLIENTE_OBRIGATORIO = "Informar o cliente é obrigatório";
    public static final String INFORMAR_LOGRADOURO_OBRIGATORIO = "Informar o logradouro é obrigatório";
    public static final String INFORMAR_NUMERO_OBRIGATORIO = "Informar o número é obrigatório";
    public static final String INFORMAR_CIDADE_OBRIGATORIO = "Informar a cidade é obrigatório";
    public static final String INFORMAR_TIPO_ENDERECO_OBRIGATORIO = "Informar o tipo de endereço é obrigatório";
    public static final String INFORMAR_CEP_OBRIGATORIO = "Informar o CEP é obrigatório";
    public static final String CEP_INVALIDO = "CEP inválido";

    private long id;
    private Cliente cliente;
    private String logradouro;
    private String numero;
    private Cidade cidade;
    private EnderecoTipo enderecoTipo;
    private String complemento;
    private String cep;

    public Endereco(Cliente cliente, String logradouro, String numero, String complemento, Cidade cidade, EnderecoTipo enderecoTipo, String cep) {
        Assert.notNull(cliente, INFORMAR_CLIENTE_OBRIGATORIO);
        Assert.hasText(logradouro, INFORMAR_LOGRADOURO_OBRIGATORIO);
        Assert.hasText(numero, INFORMAR_NUMERO_OBRIGATORIO);
        Assert.notNull(cidade, INFORMAR_CIDADE_OBRIGATORIO);
        Assert.notNull(enderecoTipo, INFORMAR_TIPO_ENDERECO_OBRIGATORIO);
        Assert.hasText(cep, INFORMAR_CEP_OBRIGATORIO);
        Assert.isTrue(cep.length() == 8, CEP_INVALIDO);

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

    public String getCep() {
        return cep;
    }
}

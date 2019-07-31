package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    public static final String NUMERO_AGENCIA_OBRIGATORIO = "Número da agencia é obrigatório";
    public static final String DIGITO_AGENCIA_OBRIGATORIO = "Dígito da agencia é obrigatório";
    public static final String CIDADE_OBRIGATORIO = "É obrigatório informar a cidade";
    private Long id;
    private String numero;
    private String digito;
    private Cidade cidade;

    public Agencia(String numero, String digito, Cidade cidade) {
        Assert.hasText(numero, NUMERO_AGENCIA_OBRIGATORIO);
        Assert.hasText(digito, DIGITO_AGENCIA_OBRIGATORIO);
        Assert.notNull(cidade, CIDADE_OBRIGATORIO);
        this.numero = numero;
        this.digito = digito;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getDigito() {
        return digito;
    }

    public Cidade getCidade() {
        return cidade;
    }
}

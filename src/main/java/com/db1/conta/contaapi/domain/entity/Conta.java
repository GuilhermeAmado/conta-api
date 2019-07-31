package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    public static final String INFORMAR_AGENCIA_OBRIGATORIO = "Informar a agência é obrigatório";
    public static final String INFORMAR_TIPO_CONTA_OBRIGATORIO = "Informar o tipo de conta é obrigatório";
    public static final String INFORMAR_CONTA_OBRIGATORIO = "Informar o número da conta é obrigatório";
    public static final String INFORMAR_CLIENTE_OBRIGATORIO = "Informar o cliente é obrigatório";

    private Long id;
    private Agencia agencia;
    private ContaTipo contaTipo;
    private String numero;
    private Cliente cliente;
    private Double saldo;
    private List<Historico> listaContas = new ArrayList<Historico>();

    public Conta(Agencia agencia, ContaTipo contaTipo, String numero, Cliente cliente) {
        Assert.notNull(agencia, INFORMAR_AGENCIA_OBRIGATORIO);
        Assert.notNull(contaTipo, INFORMAR_TIPO_CONTA_OBRIGATORIO);
        Assert.hasText(numero, INFORMAR_CONTA_OBRIGATORIO);
        Assert.notNull(cliente, INFORMAR_CLIENTE_OBRIGATORIO);

        this.agencia = agencia;
        this.contaTipo = contaTipo;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.listaContas = new ArrayList<Historico>();
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public ContaTipo getContaTipo() {
        return contaTipo;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Historico> getListaContas() {
        return listaContas;
    }
}

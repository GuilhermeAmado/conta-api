package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private long id;
    private String nome;
    private List<Endereco> listaEnderecos = new ArrayList<Endereco>();
    private List<Conta> listaContas = new ArrayList<Conta>();
    private String cpf;

    public Cliente(String nome, List<Endereco> listaEnderecos, List<Conta> listaContas, String cpf) {

    }


}

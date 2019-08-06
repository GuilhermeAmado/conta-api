package com.db1.conta.contaapi.domain.dto;

import com.db1.conta.contaapi.domain.entity.Estado;

import java.io.Serializable;

public class CidadePersistDTO implements Serializable {

    private static final long serialVersionUID = 7041215295972851764L;      // se editar a classe precisa gerar novamente
    private String nome;
    private Estado estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

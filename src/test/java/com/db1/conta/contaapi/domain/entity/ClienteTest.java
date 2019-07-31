package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void deveRetornarExceptionQuandoNomeForNull() {
        String mensagem = null;
        List<Endereco> endereco = new ArrayList<Endereco>();
        List<Conta> conta = new ArrayList<Conta>();
        try {
            Cliente cliente = new Cliente(null, endereco, conta, "12345678900");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Cliente.INFORMAR_NOME_OBRIGATORIO, mensagem);
    }

}
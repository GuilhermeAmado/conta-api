package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void deveRetornarExceptionQuandoNomeForNull() {
        String mensagem = null;
        try {
            Cliente cliente = new Cliente(null, "12345678901");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Cliente.INFORMAR_NOME_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoCpfForNull() {
        String mensagem = null;
        try {
            Cliente cliente = new Cliente("Guilherme", null);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Cliente.INFORMAR_CPF_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoCpfForInvalido() {
        String mensagem = null;
        try {
            Cliente cliente = new Cliente("Guilherme", "123");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Cliente.CPF_INVALIDO, mensagem);
    }

    @Test
    public void deveCriarUmCliente() {
        String mensagem = null;
        Cliente cliente = null;
        try {
            cliente = new Cliente("Guilherme", "12345678901");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertNull(mensagem);
        Assert.assertEquals("Guilherme", cliente.getNome());
        Assert.assertEquals("12345678901", cliente.getCpf());
    }

}
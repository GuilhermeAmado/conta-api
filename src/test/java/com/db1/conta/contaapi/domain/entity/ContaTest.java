package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ContaTest {

    @Test
    public void deveRetornarExceptionQuandoAgenciaForNull() {
        String mensagem = null;
        Cliente cliente = Mockito.mock(Cliente.class);
        try {
            Conta conta = new Conta(null, ContaTipo.CORRENTE, "123456", cliente);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Conta.INFORMAR_AGENCIA_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoTipoContaForNull() {
        String mensagem = null;
        Cliente cliente = Mockito.mock(Cliente.class);
        Agencia agencia = Mockito.mock(Agencia.class);
        try {
            Conta conta = new Conta(agencia, null, "123456", cliente);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Conta.INFORMAR_TIPO_CONTA_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoNumeroContaForNull() {
        String mensagem = null;
        Cliente cliente = Mockito.mock(Cliente.class);
        Agencia agencia = Mockito.mock(Agencia.class);
        try {
            Conta conta = new Conta(agencia, ContaTipo.CORRENTE, null, cliente);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Conta.INFORMAR_CONTA_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoClienteForNull() {
        String mensagem = null;
        Agencia agencia = Mockito.mock(Agencia.class);
        try {
            Conta conta = new Conta(agencia, ContaTipo.CORRENTE, "123456", null);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Conta.INFORMAR_CLIENTE_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveCriarUmaConta() {
        String mensagem = null;
        Cliente cliente = Mockito.mock(Cliente.class);
        Agencia agencia = Mockito.mock(Agencia.class);
        Conta conta = null;
        try {
            conta = new Conta(agencia, ContaTipo.CORRENTE, "123456", cliente);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertNull(mensagem);
        Assert.assertEquals(agencia.getNumero(), conta.getAgencia().getNumero());
        Assert.assertEquals(ContaTipo.CORRENTE, conta.getContaTipo());
        Assert.assertEquals("123456", conta.getNumero());
        Assert.assertEquals(cliente.getNome(), conta.getCliente().getNome());
    }
}
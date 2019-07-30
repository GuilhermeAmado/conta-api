package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AgenciaTest {

    @Test
    public void deveRetornarExceptionQuandoNumeroAgenciaForNull() {
        String mensagem = null;
        // Cidade cidade = new Cidade("Arapongas", Estado.PR);      // método ok, mas o de baixo é melhor
        Cidade cidade = Mockito.mock(Cidade.class);                // faz mock-up de um objeto Cidade
        try {
            Agencia agencia = new Agencia(null, "5", cidade);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Agencia.NUMERO_AGENCIA_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoDigitoAgenciaForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        try {
            Agencia agencia = new Agencia("12345", null, cidade);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Agencia.DIGITO_AGENCIA_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoCidadeForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        try {
            Agencia agencia = new Agencia("12345", "6", null);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Agencia.CIDADE_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveCriarUmaAgencia() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Agencia agencia = null;                     // para o teste "feliz" declarar a variavel fora do try
        try {
            agencia = new Agencia("12345", "6", cidade);    // objeto dentro do try
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertNull(mensagem);
        Assert.assertEquals("12345", agencia.getNumero());
        Assert.assertEquals("6", agencia.getDigito());
        Assert.assertEquals(cidade, agencia.getCidade());           // testa se o objeto mock-up esta correto
    }

}
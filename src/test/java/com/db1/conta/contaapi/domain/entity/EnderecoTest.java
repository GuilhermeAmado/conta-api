package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class EnderecoTest {

    @Test
    public void deveRetornarExceptionQuandoClienteForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        EnderecoTipo enderecoTipo = null;
        try {
            Endereco endereco = new Endereco(null, "Rua Pavão", "811", null, cidade, EnderecoTipo.RESIDENCIAL, "86700050");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Endereco.INFORMAR_CLIENTE_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoLogradouroForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Cliente cliente = Mockito.mock(Cliente.class);
        EnderecoTipo enderecoTipo = null;
        try {
            Endereco endereco = new Endereco(cliente, null, "811", null, cidade, EnderecoTipo.RESIDENCIAL, "86700050");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Endereco.INFORMAR_LOGRADOURO_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoNumeroForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Cliente cliente = Mockito.mock(Cliente.class);
        EnderecoTipo enderecoTipo = null;
        try {
            Endereco endereco = new Endereco(cliente, "Rua Pavão", null, null, cidade, EnderecoTipo.RESIDENCIAL, "86700050");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Endereco.INFORMAR_NUMERO_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoCidadeForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Cliente cliente = Mockito.mock(Cliente.class);
        EnderecoTipo enderecoTipo = null;
        try {
            Endereco endereco = new Endereco(cliente, "Rua Pavão", "811", null, null, EnderecoTipo.RESIDENCIAL, "86700050");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Endereco.INFORMAR_CIDADE_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoEnderecoTipoForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Cliente cliente = Mockito.mock(Cliente.class);
        EnderecoTipo enderecoTipo = null;
        try {
            Endereco endereco = new Endereco(cliente, "Rua Pavão", "811", null, cidade, null, "86700050");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Endereco.INFORMAR_TIPO_ENDERECO_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoCepForNull() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Cliente cliente = Mockito.mock(Cliente.class);
        EnderecoTipo enderecoTipo = null;
        try {
            Endereco endereco = new Endereco(cliente, "Rua Pavão", "811", null, cidade, EnderecoTipo.RESIDENCIAL, null);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Endereco.INFORMAR_CEP_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoDigitosCepForDiferenteDeOito() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Cliente cliente = Mockito.mock(Cliente.class);
        EnderecoTipo enderecoTipo = null;
        try {
            Endereco endereco = new Endereco(cliente, "Rua Pavão", "811", null, cidade, EnderecoTipo.RESIDENCIAL, "1234567");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Endereco.CEP_INVALIDO, mensagem);
    }

    @Test
    public void deveCriarUmEndereco() {
        String mensagem = null;
        Cidade cidade = Mockito.mock(Cidade.class);
        Cliente cliente = Mockito.mock(Cliente.class);
        EnderecoTipo enderecoTipo = null;
        Endereco endereco = null;
        try {
            endereco = new Endereco(cliente, "Rua Pavão", "811", null, cidade, EnderecoTipo.RESIDENCIAL, "86700050");
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertNull(mensagem);
        Assert.assertEquals(cliente, endereco.getCliente());
        Assert.assertEquals("Rua Pavão", endereco.getLogradouro());
        Assert.assertEquals("811", endereco.getNumero());
        Assert.assertEquals(cidade, endereco.getCidade());
        Assert.assertEquals(EnderecoTipo.RESIDENCIAL, endereco.getEnderecoTipo());
        Assert.assertEquals("86700050", endereco.getCep());
    }
}
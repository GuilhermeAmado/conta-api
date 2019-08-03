package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HistoricoTest {
    // (HistoricoTipo historicoTipo, Double valor, Double valorResultante)

    @Test
    public void deveRetornarExceptionQuandoTipoHistoricoForNull() {
        String mensagem = null;
        try {
            Historico historico = new Historico(null, 50.00, 50.00);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Historico.INFORMAR_TIPO_HISTORICO_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoValorForNull() {
        String mensagem = null;
        try {
            Historico historico = new Historico(HistoricoTipo.ENTRADA, null, 50.00);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Historico.INFORMAR_VALOR_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoValorResultanteForNull() {
        String mensagem = null;
        try {
            Historico historico = new Historico(HistoricoTipo.ENTRADA, 50.00, null);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals(Historico.INFORMAR_VALOR_RESULTANTE_OBRIGATORIO, mensagem);
    }

    @Test
    public void deveCriarUmHistorico() {
        String mensagem = null;
        Historico historico = null;
        try {
            historico = new Historico(HistoricoTipo.ENTRADA, 50.00, 50.00);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        Assert.assertNull(mensagem);
        Assert.assertEquals(HistoricoTipo.ENTRADA, historico.getHistoricoTipo());
        Assert.assertEquals(50.00, historico.getValor(), 0.01);
        Assert.assertEquals(50.00, historico.getValorResultante(), 0.01);
    }

}
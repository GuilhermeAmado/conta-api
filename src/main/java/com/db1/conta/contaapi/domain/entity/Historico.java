package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import java.time.LocalDateTime;

public class Historico {

    public static final String INFORMAR_TIPO_HISTORICO_OBRIGATORIO = "Informar o tipo de histórico é obrigatório";
    public static final String INFORMAR_DATA_OBRIGATORIO = "Informar a data é obrigatório";
    public static final String INFORMAR_VALOR_OBRIGATORIO = "Informar o valor é obrigatório";
    public static final String INFORMAR_CONTA_OBRIGATORIO = "Informar a conta é obrigatório";
    public static final String VALOR_DEVE_SER_MAIOR_QUE_ZERO = "Valor deve ser maior que zero";

    private Long id;
    private HistoricoTipo historicoTipo;
    private LocalDateTime data;
    private Double valor;
    private Conta conta;
    private Double valorResultante;

    public Historico(HistoricoTipo historicoTipo, LocalDateTime data, Double valor, Conta conta) {
        Assert.notNull(historicoTipo, INFORMAR_TIPO_HISTORICO_OBRIGATORIO);
        Assert.notNull(data, INFORMAR_DATA_OBRIGATORIO);
        Assert.notNull(valor, INFORMAR_VALOR_OBRIGATORIO);
        Assert.notNull(conta, INFORMAR_CONTA_OBRIGATORIO);
        Assert.isTrue(valor > 0, VALOR_DEVE_SER_MAIOR_QUE_ZERO);

        this.historicoTipo = historicoTipo;
        this.data = LocalDateTime.now();
        this.valor = valor;
        this.conta = conta;
        this.valorResultante = conta.getSaldo();
    }

    public HistoricoTipo getHistoricoTipo() {
        return historicoTipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public Conta getConta() {
        return conta;
    }

    public Double getValorResultante() {
        return valorResultante;
    }
}

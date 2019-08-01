package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable
public class Historico {

    public static final String INFORMAR_TIPO_HISTORICO_OBRIGATORIO = "Informar o tipo de histórico é obrigatório";
    public static final String INFORMAR_DATA_OBRIGATORIO = "Informar a data é obrigatório";
    public static final String INFORMAR_VALOR_OBRIGATORIO = "Informar o valor é obrigatório";
    public static final String VALOR_DEVE_SER_MAIOR_QUE_ZERO = "Valor deve ser maior que zero";


    @Enumerated(EnumType.STRING)
    @Column(name = "historicoTipo", length = 20, nullable = false)
    private HistoricoTipo historicoTipo;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "valorResultante")
    private Double valorResultante;

    protected Historico() {}    // construtor para o JPA

    public Historico(HistoricoTipo historicoTipo, LocalDateTime data, Double valor) {
        Assert.notNull(historicoTipo, INFORMAR_TIPO_HISTORICO_OBRIGATORIO);
        Assert.notNull(data, INFORMAR_DATA_OBRIGATORIO);
        Assert.notNull(valor, INFORMAR_VALOR_OBRIGATORIO);
        Assert.isTrue(valor > 0, VALOR_DEVE_SER_MAIOR_QUE_ZERO);

        this.historicoTipo = historicoTipo;
        this.data = LocalDateTime.now();
        this.valor = valor;
        this.valorResultante = getValorResultante();
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

    public Double getValorResultante() {
        return valorResultante;
    }
}

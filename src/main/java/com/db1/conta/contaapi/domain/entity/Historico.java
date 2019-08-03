package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable
public class Historico {

    public static final String INFORMAR_TIPO_HISTORICO_OBRIGATORIO = "Informar o tipo de histórico é obrigatório";
    public static final String INFORMAR_VALOR_OBRIGATORIO = "Informar o valor é obrigatório";
    public static final String VALOR_DEVE_SER_MAIOR_QUE_ZERO = "Valor deve ser maior que zero";
    public static final String INFORMAR_VALOR_RESULTANTE_OBRIGATORIO = "Informar o valor resultante é obrigatorio";


    @Enumerated(EnumType.STRING)
    @Column(name = "historicoTipo", length = 20, nullable = false)
    private HistoricoTipo historicoTipo;

    @Column(name = "data", nullable = false, length = 30)
    private LocalDateTime data;

    @Column(name = "valor", nullable = false, precision = 14, scale = 2)    // precision = total de dígitos significativos, scale = casas decimais
    private Double valor;

    @Column(name = "valorResultante", nullable = false, precision = 14, scale = 2)
    private Double valorResultante;

    protected Historico() {}    // construtor para o JPA

    public Historico(HistoricoTipo historicoTipo, Double valor, Double valorResultante) {
        Assert.notNull(historicoTipo, INFORMAR_TIPO_HISTORICO_OBRIGATORIO);
        Assert.notNull(valor, INFORMAR_VALOR_OBRIGATORIO);
        Assert.notNull(valorResultante, INFORMAR_VALOR_RESULTANTE_OBRIGATORIO);
        Assert.isTrue(valor > 0, VALOR_DEVE_SER_MAIOR_QUE_ZERO);

        this.historicoTipo = historicoTipo;
        this.data = LocalDateTime.now();
        this.valor = valor;
        this.valorResultante = valorResultante;
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

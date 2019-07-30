package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

public class Historico {

    private Long id;
    private HistoricoTipo historicoTipo;
    private LocalDateTime data;
    private Double valor;
    private Conta conta;
    private Double valorResultante;
}

package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conta")
public class Conta {

    public static final String INFORMAR_AGENCIA_OBRIGATORIO = "Informar a agência é obrigatório";
    public static final String INFORMAR_TIPO_CONTA_OBRIGATORIO = "Informar o tipo de conta é obrigatório";
    public static final String INFORMAR_CONTA_OBRIGATORIO = "Informar o número da conta é obrigatório";
    public static final String INFORMAR_CLIENTE_OBRIGATORIO = "Informar o cliente é obrigatório";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_agencia", nullable = false)
    private Agencia agencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "contaTipo", nullable = false, length = 15)
    private ContaTipo contaTipo;

    @Column(name = "numero", length = 20, nullable = false, unique = true)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "saldo", nullable = false, precision = 14, scale = 2)
    private Double saldo;

    @ElementCollection
    @CollectionTable(name="historico", joinColumns=@JoinColumn(name="conta_id"))
    private List<Historico> historicos = new ArrayList<Historico>();

    protected Conta() {}               // construtor para o JPA

    public Conta(Agencia agencia, ContaTipo contaTipo, String numero, Cliente cliente) {
        Assert.notNull(agencia, INFORMAR_AGENCIA_OBRIGATORIO);
        Assert.notNull(contaTipo, INFORMAR_TIPO_CONTA_OBRIGATORIO);
        Assert.hasText(numero, INFORMAR_CONTA_OBRIGATORIO);
        Assert.notNull(cliente, INFORMAR_CLIENTE_OBRIGATORIO);

        this.agencia = agencia;
        this.contaTipo = contaTipo;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(Double valor) {
        this.saldo += valor;
        this.historicos.add(new Historico(HistoricoTipo.ENTRADA, valor, this.saldo));
    }

    public void sacar(Double valor) {
        this.saldo -= valor;
        this.historicos.add(new Historico(HistoricoTipo.SAIDA, valor, this.saldo));
    }

    public Long getId() {
        return id;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public ContaTipo getContaTipo() {
        return contaTipo;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }
}
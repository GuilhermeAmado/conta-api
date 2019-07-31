package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "agencia", uniqueConstraints = @UniqueConstraint(columnNames = { "numero", "fk_cidade" }))   // só pode ter um único número de agencia por cidade
public class Agencia {

    public static final String NUMERO_AGENCIA_OBRIGATORIO = "Número da agencia é obrigatório";
    public static final String DIGITO_AGENCIA_OBRIGATORIO = "Dígito da agencia é obrigatório";
    public static final String CIDADE_OBRIGATORIO = "É obrigatório informar a cidade";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", length = 10, nullable = false, unique = true)
    private String numero;

    @Column(name = "digito", length = 2, nullable = false)
    private String digito;

    @ManyToOne
    @JoinColumn(name = "fk_cidade", nullable = false)
    private Cidade cidade;

    protected Agencia() {}               // construtor para o JPA

    public Agencia(String numero, String digito, Cidade cidade) {
        Assert.hasText(numero, NUMERO_AGENCIA_OBRIGATORIO);
        Assert.hasText(digito, DIGITO_AGENCIA_OBRIGATORIO);
        Assert.notNull(cidade, CIDADE_OBRIGATORIO);
        this.numero = numero;
        this.digito = digito;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getDigito() {
        return digito;
    }

    public Cidade getCidade() {
        return cidade;
    }
}

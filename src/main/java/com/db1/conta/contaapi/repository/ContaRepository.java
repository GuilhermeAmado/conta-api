package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findContaByNumero(String numero);     // busca conta por numero
}

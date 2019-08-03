package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClienteByCpf(String cpf);       // busca um cliente por cpf
    Cliente findClienteByNome(String nome);     // busca um cliente por nome
}

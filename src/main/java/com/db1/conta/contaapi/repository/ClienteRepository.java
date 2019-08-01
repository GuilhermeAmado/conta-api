package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Conta;
import com.db1.conta.contaapi.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClienteByCpf(String cpf);       // busca um cliente por cpf
    Cliente findClienteByNome(String nome);     // busca um cliente por nome
}

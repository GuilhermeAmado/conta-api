package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByClienteNome(String nome);          // busca endereço por nome do cliente
}

package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Cidade findByNome(String nome);                 // busca uma cidade por nome
    List<Cidade> findByEstado(Estado estado);       // busca uma lista de cidades por estado
}

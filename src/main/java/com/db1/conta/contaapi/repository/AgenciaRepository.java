package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    Agencia findByNumero (String numero);           // busca uma agencia por numero
    List<Agencia> findByCidadeEstado(Estado estado);       // busca uma lista de cidades por estado
}

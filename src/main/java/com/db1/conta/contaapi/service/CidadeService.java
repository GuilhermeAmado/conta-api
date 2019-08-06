package com.db1.conta.contaapi.service;

import com.db1.conta.contaapi.adapter.CidadeAdapter;
import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service    // service não precisa "new Cidade" para acessar os metodos
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeResponseDTO salvarCidade(CidadePersistDTO dto) {
        Cidade cidade = new Cidade(dto.getNome(), dto.getEstado());
        cidadeRepository.save(cidade);
        return CidadeAdapter.entityToResponse(cidade);      // converte entidade em dto response
    }

    public CidadeResponseDTO atualizarCidade(Long cidadeId, CidadePersistDTO dto) {
        Optional<Cidade> optionalCidade = cidadeRepository.findById(cidadeId);
        if (optionalCidade.isPresent()) {
            Cidade cidade = optionalCidade.get();
            cidade.alterar(dto.getNome(), dto.getEstado());
            cidadeRepository.save(cidade);
            return CidadeAdapter.entityToResponse(cidade);
        }
        throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
    }

    public void deletarCidade(Long cidadeId) {
        Optional<Cidade> optionalCidade = cidadeRepository.findById(cidadeId);
        if (optionalCidade.isPresent()) {
            Cidade cidade = optionalCidade.get();
            cidadeRepository.delete(cidade);
        } else {
            throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
        }
    }

    public List<CidadeResponseDTO> buscarTodasCidades() {
        List<CidadeResponseDTO> cidadeResponseDTOList = new ArrayList<>();
        List<Cidade> listaCidades = cidadeRepository.findAll();
        for (Cidade cidade : listaCidades) {
            cidadeResponseDTOList.add(CidadeAdapter.entityToResponse(cidade));
        }
        return cidadeResponseDTOList;
    }


    public CidadeResponseDTO buscarCidadePorId(Long cidadeId) {
        Optional<Cidade> optionalCidade = cidadeRepository.findById(cidadeId);
        if (optionalCidade.isPresent()) {
            Cidade cidade = optionalCidade.get();
            return CidadeAdapter.entityToResponse(cidade);
        }
        throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
    }

    public CidadeResponseDTO buscarCidadePorNome(String nome) {
        Optional<Cidade> optionalCidade = cidadeRepository.findByNome(nome);
        if (optionalCidade.isPresent()) {
            Cidade cidade = optionalCidade.get();
            return CidadeAdapter.entityToResponse(cidade);
        }
        throw new RuntimeException("Cidade com nome  " + nome + " não encontrada");
    }
}

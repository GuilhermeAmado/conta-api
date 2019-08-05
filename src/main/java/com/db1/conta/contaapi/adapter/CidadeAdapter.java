package com.db1.conta.contaapi.adapter;

import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cidade;

public class CidadeAdapter {

    public static CidadeResponseDTO entityToResponse(Cidade cidade) {
        CidadeResponseDTO responseDTO = new CidadeResponseDTO();
        responseDTO.setId(cidade.getId());
        responseDTO.setNome(cidade.getNome());
        responseDTO.setEstado(cidade.getEstado());
        return responseDTO;

    }
}

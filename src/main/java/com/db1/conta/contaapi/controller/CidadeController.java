package com.db1.conta.contaapi.controller;

import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cidades")     // URI padrão de todos os métodos
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/todas-cidades")
    public List<CidadeResponseDTO> todasCidades() {
         return cidadeService.buscarTodasCidades();
    }

    @GetMapping
    public CidadeResponseDTO cidadePorNome(@RequestParam("nome") String nome) {
        return cidadeService.buscarCidadePorNome(nome);
    }

    // buscar por id é diferente, se usa path variable
    @GetMapping("{id}")
    public CidadeResponseDTO cidadePorId(@PathVariable("id") Long id) {
        return cidadeService.buscarCidadePorId(id);
    }

    // método para cadastrar uma nova cidade
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CidadeResponseDTO salvarCidade(@RequestBody CidadePersistDTO body) {
        return cidadeService.salvarCidade(body);
    }

    // método para atualizar atributo de cidade
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CidadeResponseDTO atualizarAtributosCidade(@PathVariable(value = "id") Long id, @RequestBody CidadePersistDTO body){
        return cidadeService.atualizarCidade(id, body);
    }

    // método para deletar uma cidade
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCidadePorId(@PathVariable("id") Long id) {
        cidadeService.deletarCidade(id);
    }
}

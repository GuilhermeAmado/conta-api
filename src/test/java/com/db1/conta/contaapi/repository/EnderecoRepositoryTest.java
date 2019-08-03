package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoRepositoryTest {


    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @After
    public void afterTest() {
        enderecoRepository.deleteAll();
        cidadeRepository.deleteAll();
        clienteRepository.deleteAll();
    }

    @Test
    public void deveSalvarUmEndereco() {
        Cidade cidade = new Cidade("Maringá", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Cliente cliente = new Cliente("Fulano de Tal", "99988877766");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Endereco endereco = new Endereco(clienteSalvo, "Rua Tal", "123", "Bloco B", cidadeSalva, EnderecoTipo.RESIDENCIAL, "87768909");
        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        Assert.assertNotNull(enderecoSalvo);
        Assert.assertEquals(clienteSalvo, enderecoSalvo.getCliente());
        Assert.assertEquals(cidadeSalva, enderecoSalvo.getCidade());
        Assert.assertEquals("Rua Tal", enderecoSalvo.getLogradouro());
        Assert.assertEquals("123", enderecoSalvo.getNumero());
        Assert.assertEquals("Bloco B", enderecoSalvo.getComplemento());
        Assert.assertEquals(EnderecoTipo.RESIDENCIAL, enderecoSalvo.getEnderecoTipo());
        Assert.assertEquals("87768909", enderecoSalvo.getCep());
    }
}


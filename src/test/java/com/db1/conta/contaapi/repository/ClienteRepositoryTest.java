package com.db1.conta.contaapi.repository;


import com.db1.conta.contaapi.domain.entity.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @After
    public void afterTest() {
        clienteRepository.deleteAll();           // deleta tudo ao final do teste
        enderecoRepository.deleteAll();
        contaRepository.deleteAll();
        cidadeRepository.deleteAll();
        agenciaRepository.deleteAll();
    }

    @Test
    public void deveSalvarUmClienteComEndereco() {
        Cliente cliente = new Cliente("Guilherme Amado", "12345678901");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Cidade cidade = new Cidade("Arapongas", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Endereco endereco = new Endereco(clienteSalvo, "Rua Pavão", "811", null, cidadeSalva, EnderecoTipo.RESIDENCIAL, "86700050");
        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());

    }
}

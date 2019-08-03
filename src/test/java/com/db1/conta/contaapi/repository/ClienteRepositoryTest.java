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

    @Before
    public void settUp() {
        enderecoRepository.deleteAll();
        cidadeRepository.deleteAll();
        clienteRepository.deleteAll();           // deleta tudo ao inicio do teste
        agenciaRepository.deleteAll();
        contaRepository.deleteAll();
    }

    @After
    public void afterTest() {
        enderecoRepository.deleteAll();
        cidadeRepository.deleteAll();
        clienteRepository.deleteAll();           // deleta tudo ao final do teste
        agenciaRepository.deleteAll();
        contaRepository.deleteAll();
    }

    @Test
    public void deveSalvarUmNovoCliente() {
        Cliente cliente = new Cliente("Fulano de Tal", "11122233344");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Assert.assertNotNull(clienteSalvo);
        Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
        Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
    }

    @Test
    public void deveSalvarUmClienteComEndereco() {
        Cliente cliente = new Cliente("Guilherme Amado", "12345678901");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Cidade cidade = new Cidade("Arapongas", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Endereco endereco = new Endereco(clienteSalvo, "Rua Pavão", "811", null, cidadeSalva, EnderecoTipo.RESIDENCIAL, "86700050");
        enderecoRepository.save(endereco);

        Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
        Assert.assertEquals(cliente.getListaEnderecos(), clienteSalvo.getListaEnderecos());
    }

    @Test
    public void deveSalvarUmClienteComEnderecoMetodoAlternativo() {
        Cidade cidade = cidadeRepository.save(new Cidade("Londrina", Estado.PR));
        Cliente cliente = new Cliente("Nome do Cliente", "11133322244");

        cliente.addEndereco(cliente, "Av. Brasil", "2400", null, cidade, EnderecoTipo.RESIDENCIAL, "88888888");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Assert.assertNotNull(clienteSalvo);
        Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
        Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
        Assert.assertEquals(1, clienteSalvo.getListaEnderecos().size());
        Assert.assertNotNull(clienteSalvo.getListaEnderecos().get(0));
    }
}

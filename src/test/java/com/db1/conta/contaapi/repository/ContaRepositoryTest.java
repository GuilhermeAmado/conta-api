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
public class ContaRepositoryTest {

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @After
    public void afterTest() {
    	contaRepository.deleteAll();
	    agenciaRepository.deleteAll();
	    clienteRepository.deleteAll();
	    cidadeRepository.deleteAll();
    }

    @Test
    public void deveSalvarUmaConta() {
        Cidade cidade = new Cidade("Maringá", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Cliente cliente = new Cliente("Fulano de Tal", "99988877766");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Agencia agencia = new Agencia("123456", "7", cidadeSalva);
        Agencia agenciaSalva = agenciaRepository.save(agencia);

        Conta conta = new Conta(agenciaSalva, ContaTipo.CORRENTE, "876678", clienteSalvo);
        Conta contaSalva = contaRepository.save(conta);

        Assert.assertNotNull(contaSalva);
        Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
    }

    @Test
    public void deveSalvarUmaContaEmUmHistorico() {
        Cidade cidade = new Cidade("Maringá", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Cliente cliente = new Cliente("Fulano de Tal", "99988877766");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Agencia agencia = new Agencia("123456", "7", cidadeSalva);
        Agencia agenciaSalva = agenciaRepository.save(agencia);

        Conta conta = new Conta(agenciaSalva, ContaTipo.CORRENTE, "876678", clienteSalvo);
        conta.depositar(50.00);
        Conta contaSalva = contaRepository.save(conta);

        Assert.assertNotNull(contaSalva);
        Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
        Assert.assertEquals(1, contaSalva.getHistoricos().size());
    }
}

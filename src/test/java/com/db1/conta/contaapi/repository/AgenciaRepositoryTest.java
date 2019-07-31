package com.db1.conta.contaapi.repository;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaRepositoryTest {

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @After
    public void afterTest() {
        agenciaRepository.deleteAll();
        cidadeRepository.deleteAll();
    }

    @Test
    public void deveSalvarUmaAgencia(){
        Cidade cidade = new Cidade("Arapongas", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Agencia agencia = new Agencia("12345", "6", cidadeSalva);
        Agencia agenciaSalva = agenciaRepository.save(agencia);

        Assert.assertNotNull(agenciaSalva.getId());
        Assert.assertEquals(agencia.getNumero(), agenciaSalva.getNumero());
        Assert.assertEquals(agencia.getDigito(), agenciaSalva.getDigito());
        Assert.assertEquals(agencia.getCidade().getNome(), agenciaSalva.getCidade().getNome());
    }

    @Test
    public void deveBuscarAgenciaPorNumero() {
        Cidade cidade = new Cidade("Arapongas", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Agencia agencia = new Agencia("12345", "6", cidadeSalva);
        Agencia agenciaSalva = agenciaRepository.save(agencia);

        Agencia agenciaBuscadaPorNumero = agenciaRepository.findByNumero("12345");

        Assert.assertNotNull(agenciaBuscadaPorNumero.getId());
        Assert.assertEquals(agencia.getNumero(), agenciaBuscadaPorNumero.getNumero());
    }

    @Test
    public void deveBuscarAgenciasEmUmEstado() {
        Cidade cidade = new Cidade("Londrina", Estado.PR);
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Agencia agencia = new Agencia("12345", "6", cidadeSalva);
        Agencia agenciaSalva = agenciaRepository.save(agencia);

        List<Agencia> agenciaBuscadaPorEstado = agenciaRepository.findByCidadeEstado(Estado.PR);

        Assert.assertEquals(1, agenciaBuscadaPorEstado.size());
    }
}

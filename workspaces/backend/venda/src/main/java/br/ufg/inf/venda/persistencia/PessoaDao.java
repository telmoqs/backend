package br.ufg.inf.venda.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.venda.entidade.Pessoa;

@Repository
public interface PessoaDao extends CrudRepository<Pessoa, Integer> {
	// public Iterable<Venda> findByQuantidadeGreaterThan(Integer quantidade);
}

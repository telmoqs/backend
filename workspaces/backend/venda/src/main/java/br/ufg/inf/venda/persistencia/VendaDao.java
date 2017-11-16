package br.ufg.inf.venda.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.venda.entidade.Venda;

@Repository
public interface VendaDao extends CrudRepository<Venda, Integer> {
	// public Iterable<Venda> findByQuantidadeGreaterThan(Integer quantidade);
}

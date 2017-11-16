package br.ufg.inf.venda.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.venda.entidade.Venda;
import br.ufg.inf.venda.persistencia.VendaDao;

@Service
public class VendaNeg {

	@Autowired
	VendaDao vendaRepository;

	public Venda salvar(Venda venda) {
		return vendaRepository.save(venda);
	}

	public Venda obter(Integer codigo) {
		return vendaRepository.findOne(codigo);
	}

	public Iterable<Venda> listar() {
		return vendaRepository.findAll();
	}

	// public Iterable<Venda> listarGrandesVendas() {
	// return vendaRepository.findByQuantidadeGreaterThan(20);
	// }

	public void remover(Integer codigo) {
		vendaRepository.delete(codigo);
	}

}

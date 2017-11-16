package br.ufg.inf.venda.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.venda.entidade.Pessoa;
import br.ufg.inf.venda.persistencia.PessoaDao;

@Service
public class PessoaNeg {

	@Autowired
	PessoaDao pessoaRepository;

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa obter(Integer codigo) {
		return pessoaRepository.findOne(codigo);
	}

	public Iterable<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public void remover(Integer codigo) {
		pessoaRepository.delete(codigo);
	}

}

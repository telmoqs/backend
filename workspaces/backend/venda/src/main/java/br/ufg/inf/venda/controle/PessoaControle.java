package br.ufg.inf.venda.controle;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.venda.entidade.Pessoa;
import br.ufg.inf.venda.negocio.PessoaNeg;

@RestController
@RequestMapping("/api/vendas")
@Scope(value = "session")
@Component(value = "PessoaControle")
@ELBeanName(value = "PessoaControle")
@Join(path = "/pessoa", to = "/pessoa.jsf")
public class PessoaControle {

	@Autowired
	PessoaNeg pessoaService;

	private Pessoa pessoa = new Pessoa();

	@PostMapping
	public String salvar(@RequestBody Pessoa pessoa) {
		pessoaService.salvar(pessoa);
		return "sucesso!";
	}

	@GetMapping
	@Deferred
	@RequestAction
	@IgnorePostback
	public Iterable<Pessoa> listar() {
		return pessoaService.listar();
	}

	// @GetMapping("/grande")
	// public Iterable<Venda> listarGrandesVendas() {
	// return vendaService.listarGrandesVendas();
	// }

	@GetMapping("/{codigo}")
	public Pessoa obter(@PathVariable("codigo") Integer codigo) {
		return pessoaService.obter(codigo);
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable("codigo") Integer codigo) {
		pessoaService.remover(codigo);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}

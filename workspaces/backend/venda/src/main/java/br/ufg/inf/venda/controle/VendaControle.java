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

import br.ufg.inf.venda.entidade.Produto;
import br.ufg.inf.venda.entidade.Venda;
import br.ufg.inf.venda.negocio.VendaNeg;

@RestController
@RequestMapping("/api/vendas")
@Scope(value = "session")
@Component(value = "vendaControle")
@ELBeanName(value = "vendaControle")
@Join(path = "/venda", to = "/venda.jsf")
public class VendaControle {

	@Autowired
	VendaNeg vendaService;

	private Venda venda = new Venda();

	public VendaControle() {
		Produto prod = new Produto();
		prod.setDescricao("tenis");
		prod.setNome("sapatenis");
		prod.setPreco(150.00);

		venda.getProdutos().add(prod);
	}

	@PostMapping
	public String salvar(@RequestBody Venda venda) {
		vendaService.salvar(venda);
		return "sucesso!";
	}

	@GetMapping
	@Deferred
	@RequestAction
	@IgnorePostback
	public Iterable<Venda> listar() {
		return vendaService.listar();
	}

	// @GetMapping("/grande")
	// public Iterable<Venda> listarGrandesVendas() {
	// return vendaService.listarGrandesVendas();
	// }

	@GetMapping("/{codigo}")
	public Venda obter(@PathVariable("codigo") Integer codigo) {
		return vendaService.obter(codigo);
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable("codigo") Integer codigo) {
		vendaService.remover(codigo);
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}

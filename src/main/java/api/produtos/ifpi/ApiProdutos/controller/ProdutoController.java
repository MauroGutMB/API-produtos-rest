package api.produtos.ifpi.ApiProdutos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.produtos.ifpi.ApiProdutos.services.ProdutoServices;
import api.produtos.ifpi.ApiProdutos.model.Produto;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  ProdutoServices produtoServices;

  public ProdutoController(ProdutoServices produtoServices) {
    this.produtoServices = produtoServices;
  }

  @GetMapping("/nome/{nome}")
  public Produto getProdutoByNome(@PathVariable String nome) {
    return produtoServices.getProdutoByNome(nome);
  }

  @GetMapping("{id}")
  public Produto getProdutoById(@PathVariable Long id) {
    return produtoServices.getProdutoById(id);
  }

  @GetMapping("/categoria/{categoria}")
  public List<Produto> getProdutosByCategory(@PathVariable String categoria) {
    return produtoServices.getProdutosByCategory(categoria);
  }

  @GetMapping()
  public List<Produto> getAllProdutos() {
    return produtoServices.getAllProdutos();
  }

  // url fica assim: .../produtos/preco?minPreco=10&maxPreco=100
  @GetMapping("/preco")
  public List<Produto> getProdutosByPrecoRange(@RequestParam Double minPreco, @RequestParam Double maxPreco) {
    return produtoServices.getProdutosByPrecoRange(minPreco, maxPreco);
  }


  @PostMapping
  public String addProduto(@RequestBody Produto produto) {
    return produtoServices.addProduto(produto);
  }

  @DeleteMapping("{id}")
  public String deleteProduto(@PathVariable Long id) {
    return produtoServices.deleteProduto(id);
  }

  @DeleteMapping("/nome/{nome}")
  public String deleteProdutoByNome(@PathVariable String nome) {
    return produtoServices.deleteProdutoByNome(nome);
  }

  @PutMapping
  public String updateProduto(@RequestBody Produto produto) {
    return produtoServices.updateProduto(produto);
  }

}

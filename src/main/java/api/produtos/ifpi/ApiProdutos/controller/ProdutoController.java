package api.produtos.ifpi.ApiProdutos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @GetMapping("{id}")
  public Produto getProdutoById(@PathVariable Long id) {
    return produtoServices.getProdutoById(id);
  }

  @GetMapping()
  public List<Produto> getAllProdutos() {
    return produtoServices.getAllProdutos();
  }

  @PostMapping
  public String addProduto(@RequestBody Produto produto) {
    return produtoServices.addProduto(produto);
  }

  @DeleteMapping("{id}")
  public String deleteProduto(@PathVariable Long id) {
    return produtoServices.deleteProduto(id);
  }

  @PutMapping
  public String updateProduto(@RequestBody Produto produto) {
    return produtoServices.updateProduto(produto);
  }

}

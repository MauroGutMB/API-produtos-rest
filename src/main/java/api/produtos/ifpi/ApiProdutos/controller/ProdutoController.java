package api.produtos.ifpi.ApiProdutos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.produtos.ifpi.ApiProdutos.services.ProdutoServices;
import api.produtos.ifpi.ApiProdutos.model.ProdutoModel;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  ProdutoServices produtoServices;

  public ProdutoController(ProdutoServices produtoServices) {
    this.produtoServices = produtoServices;
  }

  @GetMapping("{id}")
  public ProdutoModel getProdutoById(@PathVariable int id) {
    return produtoServices.getProdutoById(id);
  }

  @GetMapping()
  public String getAllProdutos() {
    return produtoServices.getAllProdutos().toString();
  }

  @PostMapping
  public String addProduto(ProdutoModel produto) {
    return produtoServices.addProduto(produto);
  }

  @DeleteMapping("{id}")
  public String deleteProduto(@PathVariable int id) {
    return produtoServices.deleteProduto(id);
  }

  @PutMapping
  public String updateProduto(ProdutoModel produto) {
    return produtoServices.updateProduto(produto);
  }

}

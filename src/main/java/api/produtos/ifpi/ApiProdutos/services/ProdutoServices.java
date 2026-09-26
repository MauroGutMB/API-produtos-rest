package api.produtos.ifpi.ApiProdutos.services;

import java.util.List;
import org.springframework.stereotype.Service;
import api.produtos.ifpi.ApiProdutos.model.Produto;

@Service
public interface ProdutoServices {
    public List<Produto> getAllProdutos();
    public String addProduto(Produto produto);
    public String updateProduto(Produto produto);
    public String deleteProduto(Long id);
    public Produto getProdutoById(Long id);
  }

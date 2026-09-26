package api.produtos.ifpi.ApiProdutos.services;

import java.util.List;
import org.springframework.stereotype.Service;
import api.produtos.ifpi.ApiProdutos.model.ProdutoModel;

@Service
public interface ProdutoServices {
    public List<ProdutoModel> getAllProdutos();
    public String addProduto(ProdutoModel produto);
    public String updateProduto(ProdutoModel produto);
    public String deleteProduto(int id);
    public ProdutoModel getProdutoById(int id);
  }

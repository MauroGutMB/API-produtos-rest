package api.produtos.ifpi.ApiProdutos.impl;

import api.produtos.ifpi.ApiProdutos.model.Produto;
import api.produtos.ifpi.ApiProdutos.services.ProdutoServices;
import api.produtos.ifpi.ApiProdutos.repository.ProdutoRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ProdutoImpl implements ProdutoServices {

    private final ProdutoRepository produtoRepository;

    public ProdutoImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public String addProduto(Produto produto) {
        produtoRepository.save(produto);
        return "Produto adicionado com sucesso!";
    }

    @Override
    public String updateProduto(Produto produto) {
        if (produtoRepository.existsById(produto.getId())) {
            produtoRepository.save(produto);
            return "Produto atualizado com sucesso!";
        } else {
            return "Produto não encontrado!";
        }
    }

    @Override
    public String deleteProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return "Produto deletado com sucesso!";
        } else {
            return "Produto não encontrado!";
        }
    }

    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto getProdutoByNome(String nome) {
      nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
      List<Produto> produtos = produtoRepository.findAll();
      for (Produto produto : produtos) {
        if (produto.getNome().equals(nome)) {
          return produto;
        }
      }
      return null;
    }

    @Override
    public String deleteProdutoByNome(String nome) {
      nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
      List<Produto> produtos = produtoRepository.findAll();
      for (Produto produto : produtos) {
        if (produto.getNome().equals(nome)) {
          produtoRepository.delete(produto);
          return "Produto deletado com sucesso!";
        }
      }
      return "Produto não encontrado!";
    }

    @Override
    public List<Produto> getProdutosByCategory(String category) {
        category = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
        List<Produto> produtos = produtoRepository.findAll();
        List<Produto> produtosByCategory = new java.util.ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCategoria().equals(category)) {
                produtosByCategory.add(produto);
            }
        }
        return produtosByCategory;
    }

    @Override
    public List<Produto> getProdutosByPrecoRange(Double minPreco, Double maxPreco) {
        List<Produto> produtos = produtoRepository.findAll();
        List<Produto> produtosByPrecoRange = new java.util.ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getPreco() >= minPreco && produto.getPreco() <= maxPreco) {
                produtosByPrecoRange.add(produto);
            }
        }
        return produtosByPrecoRange;
    }

    @Override
    public String deleteByPrecoRange(Double minPreco, Double maxPreco) {
        List<Produto> produtos = produtoRepository.findAll();
        List<Produto> produtosToDelete = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getPreco() >= minPreco && produto.getPreco() <= maxPreco) {
                produtosToDelete.add(produto);
            }
        }
        if (produtosToDelete.isEmpty()) {
            return "Nenhum produto encontrado no intervalo de preço especificado!";
        } else {
            produtoRepository.deleteAll(produtosToDelete);
            return "Produtos deletados com sucesso!";
        }
    }

    @Override
    public String addProdutos(List<Produto> produtos) {
        produtoRepository.saveAll(produtos);
        return "Produtos adicionados com sucesso!";
    }

    @Override
    public List<Produto> getProdutosByDestaque() {
        List<Produto> produtos = produtoRepository.findAll();
        List<Produto> produtosByDestaque = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getDestaque()) {
                produtosByDestaque.add(produto);
            }
        }
        return produtosByDestaque;
    }

}

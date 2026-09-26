package api.produtos.ifpi.ApiProdutos.impl;

import api.produtos.ifpi.ApiProdutos.model.Produto;
import api.produtos.ifpi.ApiProdutos.services.ProdutoServices;
import api.produtos.ifpi.ApiProdutos.repository.ProdutoRepository;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
}

package api.produtos.ifpi.ApiProdutos.impl;

import api.produtos.ifpi.ApiProdutos.model.ProdutoModel;
import api.produtos.ifpi.ApiProdutos.services.ProdutoServices;
import api.produtos.ifpi.ApiProdutos.repository.ProdutoRepository;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoImpl implements ProdutoServices {

    private final ProdutoRepository produtoRepository;

    public ProdutoImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoModel> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public String addProduto(ProdutoModel produto) {
        produtoRepository.save(produto);
        return "Produto adicionado com sucesso!";
    }

    @Override
    public String updateProduto(ProdutoModel produto) {
        if (produtoRepository.existsById(produto.getId())) {
            produtoRepository.save(produto);
            return "Produto atualizado com sucesso!";
        } else {
            return "Produto não encontrado!";
        }
    }

    @Override
    public String deleteProduto(int id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return "Produto deletado com sucesso!";
        } else {
            return "Produto não encontrado!";
        }
    }

    @Override
    public ProdutoModel getProdutoById(int id) {
        return produtoRepository.findById(id).orElse(null);
    }
}

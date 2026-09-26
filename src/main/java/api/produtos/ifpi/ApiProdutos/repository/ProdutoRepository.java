package api.produtos.ifpi.ApiProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.produtos.ifpi.ApiProdutos.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {

}

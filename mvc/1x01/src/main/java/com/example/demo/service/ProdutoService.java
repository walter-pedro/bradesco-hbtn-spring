package com.example.demo.service;


import com.example.demo.model.Produto;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();
    private Long contadorId = 1L;


    public List<Produto> listarProdutos() {
        return produtos;
    }


    public Produto adicionarProduto(Produto produto) {
        produto.setId(contadorId++);
    }


    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> atualizar = produtos.stream().filter(p -> p.id == id).findFirst();

        if (atualizar.isPresent()) {
            produtos.set(produtos.getIndexOf(atualizar), produtoAtualizado);
        }

        return produtos.get(produtos.getIndexOf(produtoAtualizado));
    }


    public boolean deletarProduto(Long id) {
        Optional<Produto> remover = produtos.stream().filter(p -> p.id == id).findFirst();

        if (remover.isEmpty()) {
            return false;
        } 
        
        produtos.remove(remover.get());
        return true;    
        
    }
}
package com.example.demo.controller;


import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final main.java.com.example.demo.service.ProdutoService produtoService;


    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }


    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }


    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }


    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        return produtoService.deletarProduto(id) ? "Produto Excluido": "Produto não Encontrado";
    }
}
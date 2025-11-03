package com.example.demo.service;


import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    Produto produto;

    @BeforeEach
    private void setUp() {
        produto = new Produto(1L, "Produto", 10.0);
    }

    @Test
    void deveRetornarProdutoQuandoIdExistir() {
      when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

      Produto p = produtoService.buscarPorId(1L);
      assertEquals(produto, p);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoExistir() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> produtoService.buscarPorId(1L));
    }
}
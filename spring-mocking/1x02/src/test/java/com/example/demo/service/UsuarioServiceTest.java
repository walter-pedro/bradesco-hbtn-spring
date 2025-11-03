package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

public class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository; 

    @Mock
    UsuarioService usuarioService;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarUsuarioQuandoIdExistir() {

        Usuario usuario = new Usuario(1L, "Usuario", "usuario@usuario.com");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario u = usuarioService.buscarPorId(1L);

        assertEquals(usuario, u);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExistir() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, (() -> usuarioService.buscarPorId(1L)));
    }

    @Test
    void deveSalvarUsuarioComSucesso() {
        Usuario usuario = new Usuario(1L, "Usuario", "usuario@usuario.com");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario u = usuarioRepository.save(usuario);
        assertEquals(usuario, u);

    }
}

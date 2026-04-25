package com.tecnologico.FruverLifes.Service.impl;

import com.tecnologico.FruverLifes.Service.GestorUsuarioService;
import com.tecnologico.FruverLifes.model.Usuario;
import com.tecnologico.FruverLifes.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements GestorUsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void registrarUsuarios(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorUsuario(String usuario) {
        return usuarioRepositorio.findByUsuario(usuario);
    }

  }

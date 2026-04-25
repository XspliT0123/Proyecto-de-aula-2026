package com.tecnologico.FruverLifes.Service;
import com.tecnologico.FruverLifes.model.Usuario;
import java.util.Optional;

public interface GestorUsuarioService {

        void registrarUsuarios(Usuario usuario);

        Optional<Usuario> buscarPorUsuario(String usuario);

}
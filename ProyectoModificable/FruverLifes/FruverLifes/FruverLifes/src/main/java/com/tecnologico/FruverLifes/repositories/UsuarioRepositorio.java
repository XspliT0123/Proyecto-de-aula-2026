package com.tecnologico.FruverLifes.repositories;
import com.tecnologico.FruverLifes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

        Optional<Usuario> findByUsuario(String usuario);

}

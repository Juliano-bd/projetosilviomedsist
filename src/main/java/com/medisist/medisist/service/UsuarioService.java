package com.medisist.medisist.service;

import com.medisist.medisist.entity.Usuario;
import com.medisist.medisist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void salvarNovoUsuario(Usuario usuario) {

        usuario.setSenhaUsuario(passwordEncoder.encode(usuario.getSenhaUsuario()));

        usuario.setRole("ROLE_USER");

        usuarioRepository.save(usuario);
    }
}
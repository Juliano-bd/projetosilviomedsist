package com.medisist.medisist.service;

import com.medisist.medisist.entity.Usuario;
import com.medisist.medisist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("--- [Security] Tentando carregar usuário: " + login);

        Usuario usuario = usuarioRepository.findByLoginUsuario(login)
                .orElseThrow(() -> {

                    System.out.println("--- [Security] Usuário NÃO encontrado: " + login);
                    return new UsernameNotFoundException("Usuário não encontrado: " + login);
                });

        System.out.println("--- [Security] Usuário ENCONTRADO: " + usuario.getLoginUsuario());

        return new UserDetailsImpl(usuario);
    }
}
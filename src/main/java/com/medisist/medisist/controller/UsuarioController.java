package com.medisist.medisist.controller;

import com.medisist.medisist.entity.Usuario;
import com.medisist.medisist.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/criar")
    public String mostrarFormularioDeCriacao(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario-usuario";
    }


    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvarNovoUsuario(usuario);
        return "redirect:/login?cadastro=sucesso";
    }
}
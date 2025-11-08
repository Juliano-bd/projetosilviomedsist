package com.medisist.medisist.controller;

import com.medisist.medisist.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendaController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/agenda")
    public String verAgendaCompleta(Model model) {
        model.addAttribute("medico", medicoRepository.findAll());
        return "agenda-completa";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/agenda";
    }
}
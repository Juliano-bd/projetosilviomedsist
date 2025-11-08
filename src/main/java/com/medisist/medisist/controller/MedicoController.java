package com.medisist.medisist.controller;

import com.medisist.medisist.entity.Medico;
import com.medisist.medisist.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public String listarMedicos(Model model) {
        model.addAttribute("medico", medicoRepository.findAll());
        return "list-medico";
    }

    @GetMapping("/novo")
    public String novoMedicoForm(Model model) {
        model.addAttribute("medico", new Medico());
        return "form-medico";
    }

    @PostMapping("/salvar")
    public String salvarMedico(@ModelAttribute Medico medico) {
        medicoRepository.save(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String editarMedicoForm(@PathVariable Integer id, Model model) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Médico inválido:" + id));
        model.addAttribute("medico", medico);
        return "form-medico";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMedico(@PathVariable Integer id) {
        medicoRepository.deleteById(id);
        return "redirect:/medicos";
    }
}
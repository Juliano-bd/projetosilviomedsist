package com.medisist.medisist.controller;

import com.medisist.medisist.entity.Paciente;
import com.medisist.medisist.service.ExameService;
import com.medisist.medisist.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private ExameService exameService;

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll());
        return "list-paciente";
    }

    @GetMapping("/novo")
    public String novoPacienteForm(Model model) {
        model.addAttribute("paciente", new Paciente());
        model.addAttribute("listaExames", exameService.findAll());
        return "form-paciente";
    }

    @PostMapping("/salvar")
    public String salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String editarPacienteForm(@PathVariable Integer id, Model model) {
        Paciente paciente = pacienteService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Paciente inválido:" + id));
        model.addAttribute("paciente", paciente);
        model.addAttribute("listaExames", exameService.findAll());
        return "form-paciente";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPaciente(@PathVariable Integer id) {
        pacienteService.deleteById(id);
        return "redirect:/pacientes";
    }
}

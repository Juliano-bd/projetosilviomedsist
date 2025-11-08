package com.medisist.medisist.controller;

import com.medisist.medisist.entity.Consulta;
import com.medisist.medisist.repository.ConsultaRepository;
import com.medisist.medisist.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaRepository.findAll());
        return "list-consulta";
    }

    @GetMapping("/nova")
    public String novaConsultaForm(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("medico", medicoRepository.findAll());
        return "form-consulta";
    }

    @PostMapping("/salvar")
    public String salvarConsulta(@ModelAttribute Consulta consulta) {
        consultaRepository.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/editar/{id}")
    public String editarConsultaForm(@PathVariable Integer id, Model model) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Consulta inválido:" + id));
        model.addAttribute("consulta", consulta);
        model.addAttribute("medico", medicoRepository.findAll());
        return "form-consulta";
    }

    @GetMapping("/excluir/{id}")
    public String excluirConsulta(@PathVariable Integer id) {
        consultaRepository.deleteById(id);
        return "redirect:/consultas";
    }
}
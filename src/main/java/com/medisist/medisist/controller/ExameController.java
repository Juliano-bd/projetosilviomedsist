package com.medisist.medisist.controller;

import com.medisist.medisist.entity.Exame;
import com.medisist.medisist.service.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @GetMapping
    public String listarExames(Model model) {
        model.addAttribute("exames", exameService.findAll());
        return "list-exame";
    }

    @GetMapping("/novo")
    public String novoExameForm(Model model) {
        model.addAttribute("exame", new Exame());
        return "form-exame";
    }

    @PostMapping("/salvar")
    public String salvarExame(@ModelAttribute Exame exame) {
        exameService.save(exame);
        return "redirect:/exames";
    }

    @GetMapping("/excluir/{id}")
    public String excluirExame(@PathVariable Integer id) {
        exameService.deleteById(id);
        return "redirect:/exames";
    }
}
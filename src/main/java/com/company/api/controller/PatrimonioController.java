package com.company.api.controller;

import com.company.api.model.Patrimonio;
import com.company.api.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class PatrimonioController {
    @Autowired
    private PatrimonioService service;

    @PostMapping("/patrimonios/create")
    public String created(@ModelAttribute("patrimonio") Patrimonio patrimonio){
        service.created(patrimonio);
        return "redirect:/patrimonios";
    }

    @PutMapping("/patrimonios/{patrimonioId}")
    public Patrimonio updated(@PathVariable("patrimonioId") Long patrimonioId,
                         @RequestBody Patrimonio patrimonio){
        return service.updated(patrimonio, patrimonioId);
    }

    @GetMapping("/patrimonio/delete/{patrimonioId}")
    public String deleted(@PathVariable("patrimonioId") Long patrimonioId){
        Patrimonio patrimonio = service.getById(patrimonioId);
        service.deleted(patrimonio);
        return "redirect:/patrimonios";
    }

    @GetMapping("/patrimonio/{patrimonioId}")
    public String getById(Model model, @PathVariable("patrimonioId") Long patrimonioId){
        Patrimonio patrimonio = service.getById(patrimonioId);
        model.addAttribute("patrimonio", patrimonio);
        return "patrimonio/form";
    }

    @GetMapping("/patrimonios/create")
    public String patrimonioCreate(@ModelAttribute("patrimonio") Patrimonio patrimonio){
        return "patrimonio/form";
    }

    @GetMapping("/patrimonios")
    public String getAll(Model model){
        List<Patrimonio> patrimonios = service.getAll();
        model.addAttribute("patrimonios", patrimonios);
        return "patrimonio/index";
    }

    @GetMapping("/createPatrimoniosPdf")
    public String getCreatePdfFileService() throws FileNotFoundException {
        service.createPdfPatrimonios();
        return "redirect:/patrimonios";
    }
}

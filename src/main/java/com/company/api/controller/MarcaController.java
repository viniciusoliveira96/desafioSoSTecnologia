package com.company.api.controller;

import com.company.api.model.Marca;
import com.company.api.model.Patrimonio;
import com.company.api.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class MarcaController {
    @Autowired
    MarcaService service;

/*    @PostMapping
    @ResponseBody
    public Marca created(@RequestBody Marca marca){
        return service.created(marca);
    }*/

    /*
    @PutMapping("/{marcaId}")
    @ResponseBody
    public Marca updated(@PathVariable("marcaId") Long marcaId,
                                @RequestBody Marca marca){
        return service.updated(marca, marcaId);
    }

    @DeleteMapping("/{marcaId}")
    @ResponseBody
    public String deleted(@PathVariable("marcaId") Long marcaId){
        return service.deleted(marcaId);
    }

    @GetMapping("/{marcaId}")
    @ResponseBody
    public Marca getById(@PathVariable("marcaId") Long marcaId){
        return service.getById(marcaId);
    }

    @GetMapping
    @ResponseBody
    public List<Marca> getAll(){
        return service.getAll();
    }

    @GetMapping("/{marcaId}/patrimonios")
    @ResponseBody
    public List<Patrimonio> getPatriminiosOfMarca(@PathVariable("marcaId") Long marcaId){
        return service.getPatriminiosOfMarca(marcaId);
    }*/

    @PostMapping("marcas/create")
    public String created(@ModelAttribute("marca") Marca marca){
        service.created(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/marca/delete/{marcaId}")
    public String deleted(@PathVariable("marcaId") Long marcaId){
        Marca marca = service.getById(marcaId);
        service.deleted(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/marca/{marcaId}")
    public String getById(Model model, @PathVariable("marcaId") Long marcaId){
        Marca marca = service.getById(marcaId);
        model.addAttribute("marca", marca);
        return "marca/form";
    }

    @GetMapping("/marcas/create")
    public String marcaCreate(@ModelAttribute("marca") Marca marca){
        return "marca/form";
    }

    @GetMapping("/marcas")
    public String getAll(Model model){
        List<Marca> marcas = service.getAll();
        model.addAttribute("marcas", marcas);
        return "marca/index";
    }

    @GetMapping("/marca/{marcaId}/patrimonios")
    public String getPatriminiosOfMarca(Model model, @PathVariable("marcaId") Long marcaId){
        List<Patrimonio> patrimonios = service.getPatriminiosOfMarca(marcaId);
        model.addAttribute("patrimonios", patrimonios);
        return "marca/patrimonios";
    }

    @GetMapping("/createMarcasPdf")
    public String getCreatePdfFileService() throws FileNotFoundException {
        service.createPdfMarcas();
        return "redirect:/marcas";
    }
}

package com.company.api.service;

import com.company.api.model.Marca;
import com.company.api.model.Patrimonio;
import com.company.api.repositoy.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MarcaService {
    private static final Map<Long, Patrimonio> patrimonios = new HashMap<>();
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca created(Marca marca){;
        marcaRepository.save(marca);
        return marca;
    }

    public Marca updated(Marca marca, Long marcaId){
        marca.setId(marcaId);
        marcaRepository.save(marca);
        return marca;
    }

    public String deleted(Marca marca){
        marcaRepository.delete(marca);
        return "Deleted";
    }

    public Marca getById(Long marcaId){
        return marcaRepository.findById(marcaId).get();
    }

    public List<Marca> getAll(){
        return new ArrayList<>(marcaRepository.findAll());
    }

    public List<Patrimonio> getPatriminiosOfMarca(Long marcaId){
        return new ArrayList<>(patrimonios.values().
                stream()
                .filter(patrimonio -> patrimonio.getMarcaId().equals(marcaId))
                .collect(Collectors.toList()));
    }
}


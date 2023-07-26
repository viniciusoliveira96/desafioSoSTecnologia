package com.company.api.service;

import com.company.api.model.Patrimonio;
import com.company.api.repositoy.MarcaRepository;
import com.company.api.repositoy.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatrimonioService {
    @Autowired
    private PatrimonioRepository patrimonioRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    public Patrimonio created(Patrimonio patrimonio){
        boolean marca = marcaRepository.existsById(patrimonio.getMarcaId());
        patrimonio.setNumTombo(patrimonio.geradorNumTombo());
        if(marca) {
            patrimonioRepository.save(patrimonio);
            return patrimonio;
        }
        return patrimonio;
    }

    public Patrimonio updated(Patrimonio patrimonio, Long patrimonioId){
        patrimonio.setId(patrimonioId);
        patrimonioRepository.save(patrimonio);
        return patrimonio;
    }

    public String deleted(Patrimonio patrimonio){
        patrimonioRepository.delete(patrimonio);
        return "Deleted";
    }

    public Patrimonio getById(Long patrimonioId){
        return patrimonioRepository.findById(patrimonioId).get();
    }

    public List<Patrimonio> getAll(){
        return new ArrayList<>(patrimonioRepository.findAll());
    }
}

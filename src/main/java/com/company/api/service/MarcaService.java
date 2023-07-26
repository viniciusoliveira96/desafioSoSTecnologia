package com.company.api.service;

import com.company.api.model.Marca;
import com.company.api.model.Patrimonio;
import com.company.api.repositoy.MarcaRepository;
import com.company.api.repositoy.PatrimonioRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
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

    @Autowired
    private PatrimonioRepository patrimonioRepository;

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
        return new ArrayList<>(patrimonioRepository.findByMarcaId(marcaId));
    }

    public void createPdfMarcas() throws FileNotFoundException {
        String outputFolder = System.getProperty("user.home") + File.separator + "marcas.pdf";
        OutputStream outputStream = new FileOutputStream(outputFolder);
        List<Marca> marcas = marcaRepository.findAll();

        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        Paragraph p1 = new Paragraph("Marcas Cadastradas");
        float[] columnWidth = {100f, 200f};
        Table table = new Table(columnWidth);
        table.addCell(new Cell().add("ID"));
        table.addCell(new Cell().add("Name"));
        for(Marca marca: marcas){
            table.addCell(new Cell().add(String.valueOf(marca.getId())));
            table.addCell(new Cell().add(marca.getNome()));
        }
        document.add(p1);
        document.add(table);
        document.close();
    }
}


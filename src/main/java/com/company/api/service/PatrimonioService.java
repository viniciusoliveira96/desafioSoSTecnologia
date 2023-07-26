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

    public void createPdfPatrimonios() throws FileNotFoundException {
        String outputFolder = System.getProperty("user.home") + File.separator + "patrimonios.pdf";
        OutputStream outputStream = new FileOutputStream(outputFolder);
        List<Patrimonio> patrimonios = patrimonioRepository.findAll();

        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        Paragraph p1 = new Paragraph("Patrimonios Cadastrados");
        float[] columnWidth = {100f, 200f, 200f, 100f, 200f};
        Table table = new Table(columnWidth);
        table.addCell(new Cell().add("ID"));
        table.addCell(new Cell().add("Name"));
        table.addCell(new Cell().add("Descrição"));
        table.addCell(new Cell().add("Marca"));
        table.addCell(new Cell().add("Numero Tombo"));

        for(Patrimonio patrimonio: patrimonios){
            table.addCell(new Cell().add(String.valueOf(patrimonio.getId())));
            table.addCell(new Cell().add(patrimonio.getNome()));
            table.addCell(new Cell().add(patrimonio.getDescricao()));
            table.addCell(new Cell().add(String.valueOf(patrimonio.getMarcaId())));
            table.addCell(new Cell().add(String.valueOf(patrimonio.getNumTombo())));
        }
        document.add(p1);
        document.add(table);
        document.close();
    }
}

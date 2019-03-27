package com.wsiiz.gamemanager.controller;

import com.wsiiz.gamemanager.domain.Game;
import com.wsiiz.gamemanager.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/raport")
public class RaportController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping(value = "/games", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getGameRaport() throws DocumentException {
        List<Game> games = gameRepository.findAll();
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 17, BaseColor.BLACK);
        Chunk chunk = new Chunk("Lista gier", font);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 2, 2, 4, 2, 2});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        Paragraph paragraph = new Paragraph();
        paragraph.setSpacingAfter(18);

        paragraph.setFirstLineIndent(72);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Id", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Nazwa gry", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Wydawca", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Opis", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Tryb gry", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Data wydania", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        for (Game game : games) {

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(game.getId().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(game.getName())));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(game.getAuthor())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setPaddingRight(5);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(game.getDescription())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setPaddingRight(5);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(game.getGameMode())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setPaddingRight(5);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(game.getReleaseDate().toString().substring(0,11))));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setPaddingRight(5);
            table.addCell(cell);
        }

        document.add(chunk);
        document.add(paragraph);
        document.add(table);
        document.close();

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(new ByteArrayInputStream(out.toByteArray())));
    }

}

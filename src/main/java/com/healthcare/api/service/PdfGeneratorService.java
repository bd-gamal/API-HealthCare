package com.healthcare.api.service;

import com.healthcare.api.dto.MedicalFileResponseDTO;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfGeneratorService {
    public ByteArrayInputStream generateMedicalFilePdf(MedicalFileResponseDTO medicalFile) {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, Color.BLUE);
            Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.DARK_GRAY);
            Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);

            Paragraph title = new Paragraph("Dossier Médical - HealthCare+", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(30);
            document.add(title);

            document.add(new Paragraph("Informations du Patient", sectionFont));
            document.add(new Paragraph("Nom complet : " + medicalFile.getPatientCompleteName(), textFont));
            document.add(new Paragraph("ID Patient : " + medicalFile.getPatientId(), textFont));
            document.add(new Paragraph("Dossier créé le : " + medicalFile.getCreationDate(), textFont));

            Paragraph space = new Paragraph(" ");
            space.setSpacingAfter(20);
            document.add(space);

            document.add(new Paragraph("Détails Cliniques", sectionFont));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(2); // Tableau à 2 colonnes
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 3});

            Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);

            PdfPCell hcell1 = new PdfPCell(new Phrase("Rubrique", tableHeaderFont));
            hcell1.setBackgroundColor(Color.GRAY);
            hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell1.setPadding(8);
            table.addCell(hcell1);

            PdfPCell hcell2 = new PdfPCell(new Phrase("Description", tableHeaderFont));
            hcell2.setBackgroundColor(Color.GRAY);
            hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell2.setPadding(8);
            table.addCell(hcell2);

            table.addCell(createCell("Diagnostic", true));
            table.addCell(createCell(medicalFile.getDiagnosis() != null ? medicalFile.getDiagnosis() : "Non renseigné", false));

            table.addCell(createCell("Observations", true));
            table.addCell(createCell(medicalFile.getObservation() != null ? medicalFile.getObservation() : "Non renseigné", false));

            document.add(table);

            document.close();

        } catch (DocumentException e) {
            throw new RuntimeException("Erreur lors de la génération du fichier PDF", e);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private PdfPCell createCell(String content, boolean isHeader) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12);
        if (isHeader) {
            font.setStyle(Font.BOLD);
        }
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setPadding(8);
        return cell;
    }
}
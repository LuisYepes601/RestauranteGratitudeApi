/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.GestionPdfs.GestionarReportesPdf;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarReportesPdfservice implements GestionarReportesPdf {

    private UsuarioRepository usuarioRepo;

    @Override
    public byte[] usuariosRegistrados() {

        List<Usuario> usuarios = usuarioRepo.findAll();

        if (usuarios.isEmpty()) {
            throw new NoDatosQueMostrarExecption(
                    "Error lista vacia,  no hay usuarios registrados aun.");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter pdfWriter = new PdfWriter(baos);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        Document document = new Document(pdfDocument, PageSize.LEGAL.rotate());

        Table table = new Table(6);

        table.addCell(new Cell().add(new Paragraph("Nombre")
                .setFontSize(13)))
                .setBold()
                .setTextAlignment(TextAlignment.JUSTIFIED);

        table.addCell(new Cell().add(new Paragraph("Primer Apellido")));
        table.addCell(new Cell().add(new Paragraph("Correo")));
        table.addCell(new Cell().add(new Paragraph("Estado de cuenta")));
        table.addCell(new Cell().add(new Paragraph("Rol")));
        table.addCell(new Cell().add(new Paragraph("Fecha de registro")));

        for (Usuario usuario : usuarios) {

            table.addCell(new Cell().add(new Paragraph(usuario.getPrimerNombre())));
            table.addCell(new Cell().add(new Paragraph(usuario.getPrimerApellido())));
            table.addCell(new Cell().add(new Paragraph(usuario.getEmail())));
            table.addCell(new Cell().add(new Paragraph(usuario.getEstado_cuenta().getNombre())));
            table.addCell(new Cell().add(new Paragraph(usuario.getRol().getNombre())));
            table.addCell(new Cell().add(new Paragraph(usuario.getFechaRegistro().toString())));
        }

        document.add(table);

        document.close();

        return baos.toByteArray();
    }

}

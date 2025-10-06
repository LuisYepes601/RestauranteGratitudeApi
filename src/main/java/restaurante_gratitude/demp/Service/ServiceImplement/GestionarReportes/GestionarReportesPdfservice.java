/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.GestionPdfs.GestionarReportesPdf;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes.EstilosPdfService.EstilosCeldasServices;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarReportesPdfservice implements GestionarReportesPdf {

    private UsuarioRepository usuarioRepo;
    private EstilosCeldasServices estiloCeldas;

    @Autowired
    public GestionarReportesPdfservice(UsuarioRepository usuarioRepo, EstilosCeldasServices estiloCeldas) {
        this.usuarioRepo = usuarioRepo;
        this.estiloCeldas = estiloCeldas;
    }

    public GestionarReportesPdfservice() {
    }

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

        Table table = new Table(7);

        try {
            table.addCell(estiloCeldas.celdasTitularesBasico()
                    .add(new Paragraph("Primer nombre")));
            table.addCell(estiloCeldas.celdasTitularesBasico()
                    .add(new Paragraph("Primer Apellido")));
            table.addCell(estiloCeldas.celdasTitularesBasico()
                    .add(new Paragraph("Correo")));
            table.addCell(estiloCeldas.celdasTitularesBasico()
                    .add(new Paragraph("Numero de identificación")));
            table.addCell(estiloCeldas.celdasTitularesBasico()
                    .add(new Paragraph("Estado de cuenta")));
            table.addCell(estiloCeldas.celdasTitularesBasico()
                    .add(new Paragraph("Rol")));
            table.addCell(estiloCeldas.celdasTitularesBasico()
                    .add(new Paragraph("Fecha de registro")));

        } catch (IOException ex) {
            Logger.getLogger(GestionarReportesPdfservice.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Usuario usuario : usuarios) {

            table.addCell(estiloCeldas.celdasBasicas()
                    .add(new Paragraph(usuario.getPrimerNombre())));
            table.addCell(estiloCeldas.celdasBasicas()
                    .add(new Paragraph(usuario.getPrimerApellido())));
            table.addCell(estiloCeldas.celdasBasicas()
                    .add(new Paragraph(usuario.getEmail())));
            table.addCell(estiloCeldas.celdasBasicas()
                    .add(new Paragraph(usuario.getIdentificacion().getNumero())));
            table.addCell(estiloCeldas.celdasBasicas()
                    .add(new Paragraph(usuario.getEstado_cuenta().getNombre())));
            table.addCell(estiloCeldas.celdasBasicas()
                    .add(new Paragraph(usuario.getRol().getNombre())));
            table.addCell(estiloCeldas.celdasBasicas()
                    .add(new Paragraph(usuario.getFechaRegistro().toString())));
        }

        document.add(table);

        document.close();

        return baos.toByteArray();
    }

}

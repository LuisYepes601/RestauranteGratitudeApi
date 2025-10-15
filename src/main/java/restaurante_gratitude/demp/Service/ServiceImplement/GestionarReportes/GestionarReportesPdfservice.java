/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Response.Productos.ObtnerProductoDto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.GestionPdfs.GestionarReportesPdf;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes.FontsServicePdf.FontServicePdf;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes.EstilosPdfService.EstilosCeldasServices;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.ObtenerProductosService;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarReportesPdfservice implements GestionarReportesPdf {

    private UsuarioRepository usuarioRepo;
    private EstilosCeldasServices estiloCeldas;
    private ObtenerProductosService productosService;
    private ProductoRepository productoRepository;
    private FontServicePdf fontServicePdf;

    public GestionarReportesPdfservice() {
    }

    @Autowired
    public GestionarReportesPdfservice(UsuarioRepository usuarioRepo, EstilosCeldasServices estiloCeldas, ObtenerProductosService productosService, ProductoRepository productoRepository, FontServicePdf fontServicePdf) {
        this.usuarioRepo = usuarioRepo;
        this.estiloCeldas = estiloCeldas;
        this.productosService = productosService;
        this.productoRepository = productoRepository;
        this.fontServicePdf = fontServicePdf;
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

    @Override
    public byte[] productosValidos() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(baos);

        PdfDocument pdfDocument = new PdfDocument(writer);

        Document document = new Document(pdfDocument, PageSize.LEGAL.rotate());

        List<ObtnerProductoDto> productos = productosService.ObtenerProductosDtoDatosBasicosActivos(productoRepository.findAll());

        Paragraph titulo = new Paragraph("Nuestros poductos")
                .setBold()
                .setFontSize(20)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(15)
                .setFont(fontServicePdf.Roboto());

        float[] columnWidths = {2f, 2f, 4f, 1.5f, 2f};
        Table table = new Table(columnWidths);
        table.setWidth(UnitValue.createPercentValue(100));
        table.setVerticalAlignment(VerticalAlignment.MIDDLE);

        try {
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Nombre")));
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Imagen")));
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Descripcion")));
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Precio")));
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Categoria")));

            for (ObtnerProductoDto producto : productos) {

                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getNombre())));

                ImageData imageData = ImageDataFactory.create(producto.getImagen());

                Image image = new Image(imageData);
                image.setWidth(100);
                image.setHeight(100);

                table.addCell(new Cell().add(image));
                table.addCell(estiloCeldas.celdasBasicas().setKeepTogether(false).add(new Paragraph(producto.getDescripcion())));
                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getPrecio().toString())));
                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getCategoria())));
            }

        } catch (IOException ex) {
            Logger.getLogger(GestionarReportesPdfservice.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.add(titulo);
        document.add(table);

        document.close();

        return baos.toByteArray();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Response.Productos.ObtnerProductoDto;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Service.GestionReportes.ObtenerReportesProductos;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes.FontsServicePdf.FontServicePdf;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes.EstilosPdfService.EstilosCeldasServices;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.ObtenerProductosService;

/**
 *
 * @author Usuario
 */
@Service
public class ObtenerReporteProductosService implements ObtenerReportesProductos {

    private EstilosCeldasServices estiloCeldas;
    private ObtenerProductosService productosService;
    private ProductoRepository productoRepository;
    private FontServicePdf fontServicePdf;

    @Autowired
    public ObtenerReporteProductosService(EstilosCeldasServices estiloCeldas, ObtenerProductosService productosService, ProductoRepository productoRepository, FontServicePdf fontServicePdf) {
        this.estiloCeldas = estiloCeldas;
        this.productosService = productosService;
        this.productoRepository = productoRepository;
        this.fontServicePdf = fontServicePdf;
    }

    @Transactional(rollbackFor = Exception.class)
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

                table.addCell(estiloCeldas.celdasBasicas()
                        .setBold()
                        .setFontSize(15)
                        .add(new Paragraph(producto.getNombre())));

                ImageData imageData = ImageDataFactory.create(producto.getImagen());

                Image image = new Image(imageData);
                image.setWidth(100);
                image.setHeight(100);
                image.setAutoScale(true);

                table.addCell(new Cell()
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setPadding(20)
                        .add(image));

                table.addCell(estiloCeldas.celdasBasicas().setKeepTogether(false).add(new Paragraph(producto.getDescripcion())));
                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getPrecio().toString())));
                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getCategoria())));
            }

        } catch (IOException ex) {

        }

        document.add(titulo);
        document.add(table);

        document.close();

        return baos.toByteArray();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public byte[] productosByCategoria(String categoria) {

        List<ObtnerProductoDto> productos = productosService.ObtenerProductosDtoDatosBasicosActivos(productoRepository
                .findByCategoria_nobre(categoria));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter pdfWriter = new PdfWriter(baos);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        Document document = new Document(pdfDocument, PageSize.LEGAL.rotate());

        Color colorTituloFondo = new DeviceRgb(46, 125, 50);
        Color colorTitulo = new DeviceRgb(255, 255, 255);

        Paragraph titulo = new Paragraph("Categoria: " + categoria)
                .setFont(fontServicePdf.Roboto())
                .setBold()
                .setBackgroundColor(colorTitulo)
                .setFontColor(colorTitulo)
                .setPadding(20);

        float[] columnWidths = {2f, 4f, 3f, 1.5f};
        Table table = new Table(columnWidths);
        table.setWidth(UnitValue.createPercentValue(100));
        table.setVerticalAlignment(VerticalAlignment.MIDDLE);

        try {
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Nombre")));
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Imagen")));
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Descripcion")));
            table.addCell(estiloCeldas.celdasTitularesBasico().add(new Paragraph("Precio")));

            for (ObtnerProductoDto producto : productos) {

                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getNombre())));

                ImageData imageData = ImageDataFactory.create(producto.getImagen());
                Image image = new Image(imageData);
                image.setAutoScale(true);
                image.setWidth(150);
                image.setHeight(150);

                table.addCell(estiloCeldas.celdasBasicas().add(image));
                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getDescripcion())));
                table.addCell(estiloCeldas.celdasBasicas().add(new Paragraph(producto.getPrecio().toString())));

            }

        } catch (IOException ex) {

        }

        document.add(titulo);
        document.add(table);
        document.close();
        return baos.toByteArray();
    }

}

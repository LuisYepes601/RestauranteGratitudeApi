/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoInvalidoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.Request.Inventario.StockDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.ContenidoDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Entidades.Productos.Contenido;
import restaurante_gratitude.demp.Entidades.Productos.ProductImage;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Productos.TipoContenidoProducto;
import restaurante_gratitude.demp.Helpers.Cloudinary.CloudinaryFileHelpers;
import restaurante_gratitude.demp.Repositorys.Inventario.StockProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.CategoriaProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.ContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Productos.ImageProduct;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.TipoContenidoProductoRepository;
import restaurante_gratitude.demp.Service.Inventario.IInventario;
import restaurante_gratitude.demp.Service.Productos.AdministrarProducts;
import restaurante_gratitude.demp.Service.Productos.Contenido.IContenidoProduct;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.CargarFileService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.FileCloudinary;
import restaurante_gratitude.demp.Utils.AuditableUtils;

/**
 *
 * @author Usuario
 */
@Service
public class CrearProductoService implements AdministrarProducts {

    private ProductoRepository productoRepository;
    private CargarFileService cargarFileService;
    private ImageProduct imageProductRepo;
    private CategoriaProductoRepository categoriaProductoRepository;
    private IContenidoProduct contenidoService;
    private IInventario iInventarioService;

    @Autowired
    public CrearProductoService(ProductoRepository productoRepository, CargarFileService cargarFileService, ImageProduct imageProductRepo, CategoriaProductoRepository categoriaProductoRepository, IContenidoProduct contenidoService, IInventario iInventarioService) {
        this.productoRepository = productoRepository;
        this.cargarFileService = cargarFileService;
        this.imageProductRepo = imageProductRepo;
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.contenidoService = contenidoService;
        this.iInventarioService = iInventarioService;
    }

    public CrearProductoService() {
    }

    @CacheEvict(value = "products", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto createProduct(
            MultipartFile primary,
            List<MultipartFile> gallery,
            CrearProductoDto productoDto) {

        if (primary.isEmpty()) {

            throw new DatoInvalidoException("La imagen principal del producto no puede quedar vacia.");
        }

        Optional<Producto> optional = productoRepository.findByNombreIgnoreCase(productoDto.getNombre()
                .trim());

        Producto producto;

        if (optional.isPresent()) {

            producto = optional.get();

            if (producto.isIsDelete()) {

                AuditableUtils.activate(producto, "prueba", "prueba");
                productoRepository.save(producto);
            } else {
                throw new DatoYaExistenteException("El producto ya existe en el sistema");
            }

        }

        producto = new Producto();

        producto.setNombre(productoDto.getNombre().trim());

        if (productoDto.getDescripcion() != null) {

            producto.setDescripcion(productoDto.getDescripcion().trim());
        }

        producto.setCategoria(categoriaProductoRepository
                .findById(productoDto.getId_categoria())
                .orElseThrow(
                        () -> new DatoNoExistenteEcxeption("La categoria seleccionada no existe en e sistema")));

        producto.setPrecio(productoDto.getPrecio());

        producto.setImagen(cargarFilePrimary(primary));

        if (gallery != null) {

            if (gallery.size() > 5) {
                throw new DatoInvalidoException("Las imagenes del producto asociado no pueden superar la cantidad de 5");

            }
        }

        Contenido contenido = contenidoService.create(new ContenidoDto(producto.getId(),
                productoDto.getId_tipo_contenido(),
                productoDto.getValorcontenido())
        );

        producto.setContenido(contenido);

        AuditableUtils.create(
                producto,
                "prueba",
                "prueba");
        productoRepository.save(producto);

        iInventarioService.addProduct(new StockDto(producto.getId(),
                productoDto.getCantidadMax(),
                productoDto.getCantidadMin(),
                productoDto.getCantidad()));

        return new BasicResponseDto("El prodcuto ha sido creado exitosamente");

    }

    public String cargarFilePrimary(MultipartFile file) {

        FileCloudinary fileCloudinary = new FileCloudinary();
        fileCloudinary.setFile(file);
        fileCloudinary.setObjectUtils(CloudinaryFileHelpers.prymaryFileProduct(file.getOriginalFilename()));

        return cargarFileService.cargarArchivo(fileCloudinary);

    }

    public void cargarGalleryProducts(List<MultipartFile> files, Producto producto) {

        for (MultipartFile file : files) {
            ProductImage image = new ProductImage();
            image.setProducto(producto);

            FileCloudinary fileCloudinary = new FileCloudinary();
            fileCloudinary.setFile(file);
            fileCloudinary.setObjectUtils(CloudinaryFileHelpers.galleryFileProduct(file.getOriginalFilename()));

            image.setUrl(cargarFileService.cargarArchivo(fileCloudinary));

            imageProductRepo.save(image);

        }

    }

}

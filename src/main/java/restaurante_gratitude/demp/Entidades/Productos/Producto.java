/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Productos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Auditory.Auditable;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Promociones.Promocion;
import restaurante_gratitude.demp.Entidades.Pedidos.DetallePedido;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.CalficacionProducto;

/**
 *
 * @author Usuario
 */
@Table(
        name = "producto",
        indexes = {
            @Index(name = "idx_precio", columnList = "precio"),
            @Index(name = "idx_categoria_id", columnList = "id_categoria"),
            @Index(name = "idx_comp", columnList = "nombre,precio,isDelete")
        })
@Entity
public class Producto extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre",
            unique = true,
            nullable = false,
            length = 50)
    private String nombre;

    @Column(
            name = "precio",
            nullable = false)
    private double precio;

    @Column(name = "description",
            nullable = false,
            length = 200)
    private String descripcion;

    @Column(name = "image",
            nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToOne()
    @JoinColumn(name = "id_contenido")
    private Contenido contenido;

    @ManyToOne
    @JoinColumn(name = "id_promocion")
    private Promocion promocion;

    @OneToOne(mappedBy = "producto")
    private StockProducto stockProducto;

    @OneToMany(mappedBy = "producto")
    private List<CalficacionProducto> calficacionProductos;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

    @OneToMany(mappedBy = "producto")
    private List<ProductosFavoritos> productosFavoritos;

    public Producto(int id, String nombre, double precio, String descripcion, String imagen, Categoria categoria, Contenido contenido, Promocion promocion, StockProducto stockProducto, List<CalficacionProducto> calficacionProductos, List<DetallePedido> detallePedidos, List<ProductosFavoritos> productosFavoritos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
        this.contenido = contenido;
        this.promocion = promocion;
        this.stockProducto = stockProducto;
        this.calficacionProductos = calficacionProductos;
        this.detallePedidos = detallePedidos;
        this.productosFavoritos = productosFavoritos;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public StockProducto getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(StockProducto stockProducto) {
        this.stockProducto = stockProducto;
    }

    public List<CalficacionProducto> getCalficacionProductos() {
        return calficacionProductos;
    }

    public void setCalficacionProductos(List<CalficacionProducto> calficacionProductos) {
        this.calficacionProductos = calficacionProductos;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public List<ProductosFavoritos> getProductosFavoritos() {
        return productosFavoritos;
    }

    public void setProductosFavoritos(List<ProductosFavoritos> productosFavoritos) {
        this.productosFavoritos = productosFavoritos;
    }

}

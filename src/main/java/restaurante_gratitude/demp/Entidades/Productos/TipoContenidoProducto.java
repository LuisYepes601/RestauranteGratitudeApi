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
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import restaurante_gratitude.demp.Entidades.Auditory.Auditable;

/**
 *
 * @author Usuario
 */
@Table(name = "tipo_contenido_producto",
        indexes = {
            @Index(name = "idx_tipo_contenido_producto_name", columnList = "nombre")
        })
@Entity
public class TipoContenidoProducto extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
            name = "nombre",
            nullable = false,
            length = 50)
    private String nombre;

    @Column(
            name = "description",
            length = 200)
    private String description;

    public TipoContenidoProducto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoContenidoProducto(int id, String nombre, String description) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
    }

    public TipoContenidoProducto(int id, String nombre, String description, LocalDateTime createAt, LocalDateTime updateAt, LocalDateTime deleteAt, boolean isDelete, String createBy, String creatorName, String updateBy, String updateName, String deleteBy, String deleteName) {
        super(createAt, updateAt, deleteAt, isDelete, createBy, creatorName, updateBy, updateName, deleteBy, deleteName);
        this.id = id;
        this.nombre = nombre;
        this.description = description;
    }

    public TipoContenidoProducto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

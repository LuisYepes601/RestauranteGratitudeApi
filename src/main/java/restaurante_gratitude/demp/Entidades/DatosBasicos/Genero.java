/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.DatosBasicos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Auditory.Auditable;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author User
 */
@Entity
@Table(name = "genero", indexes = {
    @Index(name = "idx_genero_nombre", columnList = "nombre", unique = true),
    @Index(name = "idx_comp_genero_nombre_isDelete", columnList = "nombre,is_delete")
})
public class Genero extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "description",
            length = 200)
    private String description;

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    public Genero(LocalDateTime createAt, LocalDateTime updateAt, LocalDateTime deleteAt, boolean isDelete) {
        super(createAt, updateAt, deleteAt, isDelete);
    }

    public Genero(int id, String nombre, String description, List<Usuario> usuarios, LocalDateTime createAt, LocalDateTime updateAt, LocalDateTime deleteAt, boolean isDelete) {
        super(createAt, updateAt, deleteAt, isDelete);
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.usuarios = usuarios;
    }

    public Genero() {
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}

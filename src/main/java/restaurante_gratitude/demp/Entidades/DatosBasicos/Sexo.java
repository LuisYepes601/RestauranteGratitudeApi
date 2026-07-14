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
@Table(name = "sexo", indexes = {
    @Index(name = "idx_sexo_nombre", columnList = "nombre", unique = true),
    @Index(name = "idx_comp_nombre_isdelete", columnList = "nombre,is_delete")

})
public class Sexo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
            name = "nombre",
            nullable = false,
            length = 25
    )
    private String nombre;

    @Column(
            name = "description",
            length = 200)
    private String description;

    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    public Sexo() {
    }

    public Sexo(int id, String nombre, String description, List<Usuario> usuarios, LocalDateTime createAt, LocalDateTime updateAt, LocalDateTime deleteAt, boolean isDelete, String createBy, String creatorName, String updateBy, String updateName, String deleteBy, String deleteName) {
        super(createAt, updateAt, deleteAt, isDelete, createBy, creatorName, updateBy, updateName, deleteBy, deleteName);
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.usuarios = usuarios;
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

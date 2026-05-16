/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.DatosBasicos;

import restaurante_gratitude.demp.Entidades.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import restaurante_gratitude.demp.Entidades.Usuarios.Admin;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author User
 */
@Entity
@Table(name = "sexo", indexes = {
    @Index(name = "idx_sexo_nombre", columnList = "nombre"),
    @Index(name = "idx_sexo_usuario_sexos", columnList = "modiefied_by"),
    @Index(name = "idx_sexo_usuario_sexosCreated", columnList = "created_by"),
    @Index(name = "idx_sexo_usuario_sexos", columnList = "modifiedBy"),
    @Index(name = "idx_sexo_usuario_sexosDelete", columnList = "deletedBy")

})
public class Sexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 25)
    private String nombre;

    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private boolean isDelete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private Usuario created_by;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime lastModified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modifiedBy", nullable = false)
    private Usuario modifiedBy;

    @UpdateTimestamp
    private LocalDateTime deleteDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deletedBy")
    private Usuario deletedBy;

    public Sexo(int id, String nombre, List<Usuario> usuarios, LocalDateTime createDate, boolean isDelete, Usuario created_by, LocalDateTime lastModified, Usuario modifiedBy, LocalDateTime deleteDate, Usuario deletedBy) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.createDate = createDate;
        this.isDelete = isDelete;
        this.created_by = created_by;
        this.lastModified = lastModified;
        this.modifiedBy = modifiedBy;
        this.deleteDate = deleteDate;
        this.deletedBy = deletedBy;
    }

    public Sexo() {
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.ReportesProblema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Entity
public class ReporteProblema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String archivo_adjunto;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaProblema categoriaProblema;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoProblema estadoProblema;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public ReporteProblema(int id, String titulo, String descripcion, String archivo_adjunto, CategoriaProblema categoriaProblema, Date fecha, EstadoProblema estadoProblema, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.archivo_adjunto = archivo_adjunto;
        this.categoriaProblema = categoriaProblema;
        this.fecha = fecha;
        this.estadoProblema = estadoProblema;
        this.usuario = usuario;
    }

    public ReporteProblema() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivo_adjunto() {
        return archivo_adjunto;
    }

    public void setArchivo_adjunto(String archivo_adjunto) {
        this.archivo_adjunto = archivo_adjunto;
    }

    public CategoriaProblema getCategoriaProblema() {
        return categoriaProblema;
    }

    public void setCategoriaProblema(CategoriaProblema categoriaProblema) {
        this.categoriaProblema = categoriaProblema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoProblema getEstadoProblema() {
        return estadoProblema;
    }

    public void setEstadoProblema(EstadoProblema estadoProblema) {
        this.estadoProblema = estadoProblema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

}

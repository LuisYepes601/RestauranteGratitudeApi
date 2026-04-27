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
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author User
 */
@Entity
public class CategoriaProblema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "categoriaProblema")
    private List<ReporteProblema> reporteProblemas;

    public CategoriaProblema(int id, String nombre, List<ReporteProblema> reporteProblemas) {
        this.id = id;
        this.nombre = nombre;
        this.reporteProblemas = reporteProblemas;
    }

    public CategoriaProblema() {
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

    public List<ReporteProblema> getReporteProblemas() {
        return reporteProblemas;
    }

    public void setReporteProblemas(List<ReporteProblema> reporteProblemas) {
        this.reporteProblemas = reporteProblemas;
    }

}

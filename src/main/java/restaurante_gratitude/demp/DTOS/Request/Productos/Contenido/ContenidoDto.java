/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos.Contenido;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author luis
 */
public class ContenidoDto {

    @Schema(
            description = "Representación del registro en la entidad",
            example = "1252",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer id_prouduct;

    @Schema(
            description = "Representación del registro en la entidad",
            example = "1252",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer id_type_product;

    @Schema(
            description = "Representación del valor de contenido",
            example = "1000, 1, 2.5",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String value;

    public ContenidoDto(Integer id_prouduct, Integer id_type_product, String value) {
        this.id_prouduct = id_prouduct;
        this.id_type_product = id_type_product;
        this.value = value;
    }

    public ContenidoDto() {
    }

    public Integer getId_prouduct() {
        return id_prouduct;
    }

    public void setId_prouduct(Integer id_prouduct) {
        this.id_prouduct = id_prouduct;
    }

    public Integer getId_type_product() {
        return id_type_product;
    }

    public void setId_type_product(Integer id_type_product) {
        this.id_type_product = id_type_product;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

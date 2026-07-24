/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Response.Inventario;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 *
 * @author luis
 */
public class InventarioDetailsDtoResp {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime deleteAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String creatorName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String updateBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String updateName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String deleteBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String deleteName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updateAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String createBy;

    private String descriptionProduct;

    private String category;

    private String imagen;

    public InventarioDetailsDtoResp(LocalDateTime deleteAt, String creatorName, String updateBy, String updateName, String deleteBy, String deleteName, LocalDateTime updateAt, String createBy, String descriptionProduct, String category, String imagen) {
        this.deleteAt = deleteAt;
        this.creatorName = creatorName;
        this.updateBy = updateBy;
        this.updateName = updateName;
        this.deleteBy = deleteBy;
        this.deleteName = deleteName;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.descriptionProduct = descriptionProduct;
        this.category = category;
        this.imagen = imagen;
    }

    public InventarioDetailsDtoResp() {
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public String getDeleteName() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}

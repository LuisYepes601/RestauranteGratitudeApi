/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Response.Productos.Categoria;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 *
 * @author luis
 */
public class CategoryDetailsDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY,
            example = "20/17/2025")
    private LocalDateTime deleteAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String creatorName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String updateBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String updateName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String deleteName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String deleteBy;

    public CategoryDetailsDto(LocalDateTime deleteAt, String creatorName, String updateBy, String updateName, String deleteName, String deleteBy) {
        this.deleteAt = deleteAt;
        this.creatorName = creatorName;
        this.updateBy = updateBy;
        this.updateName = updateName;
        this.deleteName = deleteName;
        this.deleteBy = deleteBy;
    }

    public CategoryDetailsDto() {
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

    public String getDeleteName() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }
    
    
}

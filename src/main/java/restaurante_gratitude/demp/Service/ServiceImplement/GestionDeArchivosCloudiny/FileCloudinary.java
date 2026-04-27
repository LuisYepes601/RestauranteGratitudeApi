/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
public class FileCloudinary {

    private Map<String, Object> objectUtils;
    private MultipartFile file;

    public FileCloudinary(Map<String, Object> objectUtils, MultipartFile file) {
        this.objectUtils = objectUtils;
        this.file = file;
    }

    public Map<String, Object> getObjectUtils() {
        return objectUtils;
    }

    public void setObjectUtils(Map<String, Object> objectUtils) {
        this.objectUtils = objectUtils;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}

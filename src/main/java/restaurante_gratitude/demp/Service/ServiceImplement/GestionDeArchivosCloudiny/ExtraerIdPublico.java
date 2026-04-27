/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny;

/**
 *
 * @author User
 */
public class ExtraerIdPublico {

    public static String extraerPublicId(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        int uploadIndex = url.indexOf("/upload/");
        if (uploadIndex == -1) {
            return null;
        }

        // Extrae todo después de /upload/
        String parteDespuesDeUpload = url.substring(uploadIndex + 8);

        // Elimina versión si existe (v1234567890/)
        if (parteDespuesDeUpload.startsWith("v")) {
            int primerSlash = parteDespuesDeUpload.indexOf("/");
            if (primerSlash != -1) {
                parteDespuesDeUpload = parteDespuesDeUpload.substring(primerSlash + 1);
            }
        }

        // Quita extensión (.jpg, .png, etc.)
        int punto = parteDespuesDeUpload.lastIndexOf(".");
        if (punto != -1) {
            parteDespuesDeUpload = parteDespuesDeUpload.substring(0, punto);
        }

        // 🔧 Normalización robusta
        parteDespuesDeUpload = parteDespuesDeUpload
                .replace("%20", " ") // convierte %20 en espacio real
                .replaceAll("_+", "_") // reduce múltiples _ a uno solo
                .trim();

        return parteDespuesDeUpload;
    }

}

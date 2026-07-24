/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Helpers.Cloudinary;

import com.cloudinary.Transformation;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luis
 */
public class CloudinaryFileHelpers {

    public static Map<String, Object> ProfilePhtotoUser(String nameUser) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "usuarios/perfil_/".concat(nameUser));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(400)
                .height(400));

        return utils;

    }

    public static Map<String, Object> prymaryFileProduct(String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "products/primary_/".concat(nameFile));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(400)
                .height(400));

        return utils;

    }

    public static Map<String, Object> galleryFileProduct(String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "products/gallery/".concat(nameFile));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(400)
                .height(400));

        return utils;

    }
}

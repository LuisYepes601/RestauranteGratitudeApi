/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Helpers.Cloudinary;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luis
 */
public class CloudinaryFileUtils {
    
    public static Map<String, Object> ProfileFhtotho(String nameProduct) {
        
        Map<String, Object> utils = new HashMap<>();
        
        utils.put("public_id", "productos/".concat(nameProduct));
        
        return utils;
        
    }
;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class CrearProductoDto {

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Papas a la francesa")
    @Size(
            min = 3,
            max = 50,
            message = "El nombre debe de tener almenos 3 caracteres y un máximo de 50.")
    @NotBlank(message = "El nombre del producto no puede quedar vacio."
            + " Le invitamos a rellenarlo, por Ejemplo; Nombre : Hamburguesa")
    private String nombre;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "16,000")
    @NotNull(message = "El precio del producto no puede quedar vacio. Le invitamos a rellenar el "
            + " campo precio del producto. Po ejemplo, Precio: 12500")
    @PositiveOrZero(message = "El campo precio solo acepta positivos o cero 0")
    private Double precio;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Este plato lleva carne de venado.")
    @Size(
            min = 10,
            max = 200,
            message = "la descripcon debe de tener almenos 10 caracteres y maximo 200.")
    @NotBlank(message = "La descripción del producto no puede quedar vacia."
            + " Le invitamos a colocarle una descripión a el producto.")
    private String descripcion;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Id de la categoria elegida",
            example = "Panaderia")
    @NotBlank(message = "El campo categoria no puede quedar vacio, le invitamos a escoger una opción"
            + " , por ejemplo; Categoria: Postres")
    private Integer id_categoria;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1005",
            description = "representa la cantidad de conteido que contiene el producto..")
    @NotBlank(message = "El campo valor de contenido, no puede quedar vacio, le invitamos a rellenarlo"
            + " por ejemplo: 500 ml")
    private String Valorcontenido;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El campo tipo de contenido no puede quedar vacio, le invitamos"
            + " a ingresar "
            + "una opción, por ejemplo Mililitos(Ml)")
    private Integer id_tipo_contenido;

    @Schema(
            description = "Representa la cantidad inicial que tendra el producto en el sistema.",
            example = "25",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El campo cantidad actual no puede quedar vacio. Le invitamos a ingresar"
            + " una cantidad inicial, por ejemplo; Cantidad actual: 15 ")
    @PositiveOrZero(message = "La cantidad ingresada debe ser cero 0 o mayor a el."
            + "Por ejemplo; Cantidad: 15")
    private int cantidad;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El campo cantidad máxima no puede quedar vacio, le invitamos a que rellene el campo."
            + "Por ejemplo: Cantidad máxima = 120 ")
    @PositiveOrZero(message = "La cantidad ingresada debe ser cero 0 o mayor a el. "
            + "Por ejemplo; Cantidad: 120")
    private int cantidadMax;

    @NotBlank(message = "El campo cantidad minima no puede quedar vacio, le invitamos a que rellene el campo."
            + "Por ejemplo: Cantidad minima = 12 ")
    @PositiveOrZero(message = "La cantidad ingresada debe ser cero 0 o mayor a el. "
            + "Por ejemplo; Cantidad: 12")
    private int cantidadMin;

}

package com.crud_cliente.crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Clase que representa la entidad Cliente y se mapea a la tabla 'tbl_clientes' en la base de datos.
 */
@Data
@Entity
@Table(name = "tbl_clientes") // Especifica el nombre de la tabla en la base de datos
public class Cliente {
    @Id // Define la clave primaria de la entidad
    private String doc; // Documento de identificación único del cliente

    private String tipoDoc; // Tipo de documento (CC, TI, CE, etc.)
    private String nombres;
    private String apellidos;
    private String genero; // Género del cliente (Masculino, Femenino, Otro)
    private LocalDate fecNacimiento;
    private String email;
    private String password;
    private String telefono;
    private String ciudad;
    private String barrio;
    private String direccion;

}

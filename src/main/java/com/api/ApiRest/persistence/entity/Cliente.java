package com.api.ApiRest.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nombre;

    private String apellido;

    @Column(nullable = true)
    private Integer celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;


}

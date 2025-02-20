/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Usuarios")
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tipo_documento")
    private String tipo_documento;
    @Column(name = "documento")
    private int documento;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "rol")
    private String rol;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "fecha_alta")
    private String fecha_alta;
    @Column(name = "fecha_baja")
    private String fecha_baja;
    @Column(name = "estado")
    private boolean estado;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoD.offiapp.controladores;


import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pulaf
 */

    @Controller
@RequestMapping ("/proveedor")
public class ProveedorControlador {
    @GetMapping ("/registro")
    public String Registro(){
        return "registro_proveedor.html";
    }
    @PostMapping ("/registrar")
    public String Registrar(@RequestParam String id, String nombreProv, String contrasenia, int telefono, String servicio, int precioHora, String descripcion, String email, int calificacion, String reseña){
        return "index.html";
    }

    }

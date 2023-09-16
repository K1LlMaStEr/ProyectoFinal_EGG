/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoD.offiapp.controladores;


import com.grupoD.offiapp.enumeraciones.Rol;
import com.grupoD.offiapp.excepciones.MiException;
import com.grupoD.offiapp.servicios.UsuarioServicio;
import static java.lang.System.console;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping ("/usuario")
public class UsuarioControlador {
  
@Autowired
private UsuarioServicio usuarioServicio;

    @GetMapping ("/registro")
    public String Registro(){
        System.out.println("estoy en el regristrar");
        return "registro_usuario.html";
    }
    @PostMapping ("/registrar")
    public String Registrar(@RequestParam String nombreUser, int idUser, String direccion, String email, String contrasenia, Rol rol) throws MiException {
     try{
        usuarioServicio.registrar(nombreUser, email, contrasenia, contrasenia);
     }catch(MiException ex){
         Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
         return "registro_usuario.html";
     }
        return "index.html";
    }
}


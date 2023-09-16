/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoD.offiapp.controladores;




import com.grupoD.offiapp.enumeraciones.Rol;
import com.grupoD.offiapp.excepciones.MiException;
import com.grupoD.offiapp.servicios.UsuarioServicio;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
//        modelo.put("exito", "Usted se ha registrado correctamente");
     }catch(MiException ex){

         Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);

//        modelo.put("error", ex.getMessage());

         return "registro_usuario.html";
     }
        return "index.html";
    }
}


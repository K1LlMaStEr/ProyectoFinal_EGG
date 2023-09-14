/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Calificacion;
import Entidades.Comentario;
import com.grupoD.offiapp.UsuarioServicio;
import enumeraciones.Rol;
import excepciones.MiException;
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

    @GetMapping ("/registrar")
    public String Registrar(){
        return "usuario_form.html";
    }
    @PostMapping ("/registro")
    public String Registro(@RequestParam String nombreUser, int idUser, String direccion, String email, String contrasenia, Rol rol, Comentario comentario, Calificacion calificacion) throws MiException {
     try{
        usuarioServicio.registrar(nombreUser, email, contrasenia, contrasenia);
     }catch(MiException ex){
         Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
         return "usuario_form.html";
     }
        return "index.html";
    }
}


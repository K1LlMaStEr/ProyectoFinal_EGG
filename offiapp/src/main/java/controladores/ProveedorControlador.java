/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import excepciones.MiException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicios.ProveedorServicio;

/**
 *
 * @author pulaf
 */

    @Controller
@RequestMapping ("/provedor")
public class ProveedorControlador {
        @Autowired 
        private ProveedorServicio proveedorServicio;
    @GetMapping ("/registrar")
    public String Registrar(){
        return "registro_provedor.html";
    }
    @PostMapping ("/registro")
    public String Registro(@RequestParam String id, @RequestParam String nombreProv, @RequestParam String contrasenia,@RequestParam
            int telefono,@RequestParam String servicio, @RequestParam int precioHora,
            @RequestParam (required=false)String descripcion,@RequestParam String email,ModelMap modelo){
      
      try{
        proveedorServicio.crearProveedor( nombreProv,  descripcion, telefono, servicio);
        modelo.put("exito", "Usted se registro correctamente");
     }catch(MiException ex){
          modelo.put("error", ex.getMessage());
         return "registro_usuario.html";
     }
        return "index.html";
    }
    }
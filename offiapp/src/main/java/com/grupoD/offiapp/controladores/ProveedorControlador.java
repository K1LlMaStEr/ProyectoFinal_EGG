/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoD.offiapp.controladores;



import com.grupoD.offiapp.excepciones.MiException;
import com.grupoD.offiapp.servicios.ProveedorServicio;
import java.util.ArrayList;
import java.util.logging.Level;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

        @Autowired 
        private ProveedorServicio proveedorServicio;
    @GetMapping ("/registrar")
    public String proveedorRegistrar(){
       
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
         return "registro_provedor.html";
     }
        return "index.html";
    }
    }
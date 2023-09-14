/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Servicio;
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
@RequestMapping ("/provedor")
public class ProvedorControlador {
    @GetMapping ("/registrar")
    public String Registrar(){
        return "Proveedor_form.html";
    }
    @PostMapping ("/registro")
    public String Registro(@RequestParam String nombreProv, int idProv, int telefono, ArrayList<Servicio> servicio, int precioHora, String descripcion, Servicio servicios){
        return "index.html";
    }

    }

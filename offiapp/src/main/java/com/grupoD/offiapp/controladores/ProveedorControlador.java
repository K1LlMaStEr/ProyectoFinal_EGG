package com.grupoD.offiapp.controladores;

import com.grupoD.offiapp.excepciones.MiException;
import com.grupoD.offiapp.servicios.ProveedorServicio;
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

@Controller
@RequestMapping("/proveedor")
public class ProveedorControlador {
    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/registro")
    public String Registro() {
        return "registro_proveedor.html";
    }

    @PostMapping("/registrar")
    public String Registrar(@RequestParam String nombreProv, @RequestParam String email,
            @RequestParam String password, @RequestParam String password2, @RequestParam int telefono, @RequestParam String servicio,
            @RequestParam int precioHora, @RequestParam(required = false) String descripcion, ModelMap modelo) {

        try {
            proveedorServicio.crearProveedor(nombreProv, email, password, password2, telefono, servicio, precioHora, descripcion);
            
            modelo.put("exito", "Usted se registró correctamente");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "registro_proveedor.html";
        }
        return "index.html";
    }
}

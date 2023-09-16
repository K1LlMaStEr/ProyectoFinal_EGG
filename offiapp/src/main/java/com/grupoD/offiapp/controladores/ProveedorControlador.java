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
@RequestMapping("/provedor")
public class ProveedorControlador {
    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/registrar")
    public String Registrar() {
        return "registro_provedor.html";
    }

    @PostMapping("/registro")
    public String Registro(@RequestParam String nombreProv,
            @RequestParam String contrasenia, @RequestParam int telefono, @RequestParam String servicio,
            @RequestParam int precioHora, @RequestParam(required = false) String descripcion,
            @RequestParam String email, ModelMap modelo) {

        try {
            proveedorServicio.crearProveedor(nombreProv, descripcion, telefono, servicio);
            modelo.put("exito", "Usted se registró correctamente");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "registro_usuario.html";
        }
        return "index.html";
    }
}

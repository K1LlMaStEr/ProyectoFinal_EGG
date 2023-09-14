package servicios;

import Entidades.Proveedor;
import Entidades.Usuario;
import enumeraciones.Rol;
import excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repositorios.ProveedorRepositorio;
import repositorios.UsuarioRepositorio;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Transactional


    public void crearProveedor(String nombreProv, String descripcion, int telefono, String servicio) throws MiException {
        validar(nombreProv, servicio);


        Proveedor proveedor = new Proveedor();

        proveedor.setNombreProv(nombreProv);
        proveedor.setDescripcion(descripcion);
        proveedor.setTelefono(telefono);

      

        //proveedor.setFecha(new Date());

        proveedorRepositorio.save(proveedor);

    }

    public List<Proveedor> listarProveedores() {

        List<Proveedor> proveedor = new ArrayList();

        proveedor = proveedorRepositorio.findAll();
        return proveedor;
    }


    public void modificarProveedor(String nombreProv, String descripcion, int telefono, String servicioOfrecidos, String id) throws MiException {
        validar(nombreProv, servicioOfrecidos);

        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);
        Proveedor proveedor = new Proveedor();
        if (respuesta.isPresent()) {

            proveedor = respuesta.get();
            proveedor.setNombreProv(nombreProv);
            proveedor.setDescripcion(descripcion);
            proveedor.setTelefono(telefono);

        

            proveedor.setServicio(descripcion);     //VER QUE VAMOS HACER YA QUE NO LO TENGO EN LA ENTIDAD


            proveedorRepositorio.save(proveedor);
        }
    }

    public void eliminarProveedor(String id) throws MiException {

        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Proveedor proveedor = respuesta.get();
            proveedorRepositorio.deleteById(id);
        }
    }

    private void validar(String nombre, String servicioOfrecidos) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede estar vacio");
        }
        if (servicioOfrecidos.isEmpty() || servicioOfrecidos == null) {
            throw new MiException("el servicio no puede estar vacio");
        }
    }

    public Proveedor getOne(String id) {
        return proveedorRepositorio.getOne(id);

    }

}

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
    public void crearProovedor(String nombre, String descripcion, int telefono, String servicioOfrecidos) throws MiException {
        validar(nombre, servicioOfrecidos);

        Proveedor proveedor = new Proveedor();

        proveedor.setNombre(nombre);
        proveedor.setDescripcion(descripcion);
        proveedor.setTelefono(telefono);
        proveedor.setServicioOfrecido(servicioOfrecidos);

        //proveedor.setFecha(new Date());
        proveedorRepositorio.save(proveedor);

    }

    public List<Proveedor> listarNoticias() {

        List<Proveedor> proveedor = new ArrayList();

        proveedor = proveedorRepositorio.findAll();
        return proveedor;
    }

    public void modificarNoticia(String nombre, String descripcion, int telefono, String servicioOfrecidos, String id) throws MiException {
        validar(nombre, servicioOfrecidos);
        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);
        Proveedor proveedor = new Proveedor();
        if (respuesta.isPresent()) {

            proveedor = respuesta.get();
            proveedor.setNombre(nombre);
            proveedor.setDescripcion(descripcion);
            proveedor.setTelefono(telefono);
            proveedor.setServicioOfrecido(servicioOfrecidos);

            proveedorRepositorio.save(proveedor);
        }
    }

    public void eliminarNoticia(String id) throws MiException {

        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Proveedor noticia = respuesta.get();
            proveedorRepositorio.deleteById(id);
        }
    }

    private void validar(String nombre, String servicioOfrecidos) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el cuerpo no puede estar vacio");
        }
        if (servicioOfrecidos.isEmpty() || servicioOfrecidos == null) {
            throw new MiException("el titulo no puede estar vacio");
        }
    }

    public Proveedor getOne(String id) {
        return proveedorRepositorio.getOne(id);

    }

}

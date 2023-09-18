package com.grupoD.offiapp.servicios;

import com.grupoD.offiapp.Entidades.Proveedor;

import com.grupoD.offiapp.excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.grupoD.offiapp.repositorios.ProveedorRepositorio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Transactional

    public void crearProveedor(String nombreProv, String email, String password, String password2, int telefono, String servicio, int precioHora, String descripcion) throws MiException {
        validar(nombreProv, email, password, password2, servicio);

        Proveedor proveedor = new Proveedor();

        proveedor.setNombreProv(nombreProv);
        proveedor.setEmail(email);
        proveedor.setContrasenia(new BCryptPasswordEncoder().encode(password));
        proveedor.setTelefono(telefono);
        proveedor.setServicio(servicio);
        proveedor.setPrecioHora(precioHora);
        proveedor.setDescripcion(descripcion);

        //proveedor.setFecha(new Date());
        proveedorRepositorio.save(proveedor);

    }

    public List<Proveedor> listarProveedores() {

        List<Proveedor> proveedor = new ArrayList();

        proveedor = proveedorRepositorio.findAll();
        return proveedor;
    }

    @Transactional
    public void modificarProveedor(String nombreProv, String email, String password, String password2, int telefono, String servicio, int precioHora, String descripcion) throws MiException {
        validar(nombreProv, email, password, password2, servicio);

   /*     Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);
        Proveedor proveedor = new Proveedor();
        if (respuesta.isPresent()) {

            proveedor = respuesta.get();
            proveedor.setNombreProv(nombreProv);
            proveedor.setDescripcion(descripcion);
            proveedor.setTelefono(telefono);

            proveedor.setServicio(descripcion);     //VER QUE VAMOS HACER YA QUE NO LO TENGO EN LA ENTIDAD

            proveedorRepositorio.save(proveedor);
        }
*/
    }

    @Transactional
    public void eliminarProveedor(String id) throws MiException {

        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Proveedor proveedor = respuesta.get();
            proveedorRepositorio.deleteById(id);
        }
    }


    public void validar(String nombreProv, String email, String password, String password2, String servicio) throws MiException {
        if (nombreProv == null || nombreProv.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío");
        }
        if (email == null || email.isEmpty()) {
            throw new MiException("El email no puede estar vacío");
        }
        if (password == null || password.isEmpty() || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía y debe tener al menos 6 caracteres");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas no coinciden");
        }
        if (servicio.isEmpty() || servicio == null) {
            throw new MiException("el servicio no puede estar vacio");
        }
    }

    public Proveedor getOne(String id) {
        return proveedorRepositorio.getOne(id);

    }

}

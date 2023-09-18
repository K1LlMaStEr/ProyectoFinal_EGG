package com.grupoD.offiapp.servicios;

import com.grupoD.offiapp.Entidades.Usuario;
import com.grupoD.offiapp.enumeraciones.Rol;
import com.grupoD.offiapp.excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import com.grupoD.offiapp.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

//asi tiene que estar en el thymelife
    @Transactional
    public void registrar(String nombreUser, String direccion, String email, String password, String password2) throws MiException {

        validar(nombreUser, direccion, email, password, password2);
        Usuario usuario = new Usuario();
        usuario.setNombreUser(nombreUser);
        usuario.setDireccion(direccion);
        usuario.setEmail(email);
        usuario.setContrasenia(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);

    }

    public void validar(String nombreUser, String direccion, String email, String password, String password2) throws MiException {
        if (nombreUser == null || nombreUser.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new MiException("La dirección no puede estar vacía");
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
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permisos.add(p);
            return new User(usuario.getEmail(), usuario.getContrasenia(), permisos);

        } else {
            return null;
        }

    }

}

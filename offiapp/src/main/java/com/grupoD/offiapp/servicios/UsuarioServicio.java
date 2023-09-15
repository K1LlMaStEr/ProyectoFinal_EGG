
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.grupoD.offiapp.repositorios.UsuarioRepositorio;



@Service
public class UsuarioServicio implements UserDetailsService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException{
       
        System.out.println("Holas");
        validar(nombre, email, password, password2);
        Usuario usuario= new Usuario();
        usuario.setNombreUser(nombre);
        usuario.setEmail(email);
        usuario.setContrasenia(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);
        System.out.println("Hola");
        
    }

    
     public void validar(String nombre, String email, String password, String password2) throws MiException  {

        
         if(nombre.isEmpty()||nombre==null){
        throw new MiException("el nombre no puede estar vacio");
    }    
    if(email.isEmpty()||email==null){
        throw new MiException("el email no puede estar vacio");
    }
     if(password.isEmpty()||password==null|| password.length()<=5){
        throw new MiException("el password no puede estar vacio y tener menos de 5 digitos");
    }    
     if(!password.equals(password2)){
          throw new MiException("los passwords no pueden ser distintos");
     }
        
    }
     
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario= usuarioRepositorio.buscarPorEmail(email);
        if(usuario!=null){
            List<GrantedAuthority> permisos= new ArrayList();
            GrantedAuthority p= new SimpleGrantedAuthority("ROLE_"+ usuario.getRol().toString());
            permisos.add(p);
            return new User(usuario.getEmail(),usuario.getContrasenia(),permisos);
        
    }else{
            return null;
        }
       
    }
    
    }
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import Entidades.Usuario;
import enumeraciones.Rol;
import excepciones.MiException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repositorios.UsuarioRepositorio;

/**
 *
 * @author gonza
 */
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException{
        validar(nombre, email, password, password2);
        Usuario usuario= new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);
        
        
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
    
}

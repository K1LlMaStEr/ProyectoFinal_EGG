/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import enumeraciones.Rol;      // va en minuscula px la carpeta esta en minuscula 
///import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
///import javax.persistence.Temporal;
///import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
//import javax.persistence.OneToMany;
/**
 *
 * @author pulaf
 */
@Entity
public class Usuario {
     @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2") 
    private String id;
    private String nombreUser;
    private String direccion;
    private String email;
    private String contrasenia;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private Proveedor proveedor;
   

    public Usuario() {
    }

    public Usuario(String id, String nombreUser, String direccion, String email, String contrasenia, Rol rol, Proveedor proveedor) {
        this.id = id;
        this.nombreUser = nombreUser;
        this.direccion = direccion;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.proveedor = proveedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
   
      
}

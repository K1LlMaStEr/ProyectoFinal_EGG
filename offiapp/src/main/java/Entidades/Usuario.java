/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import enumeraciones.Rol;      // va en minuscula px la carpeta esta en minuscula 
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
     private int idUser;
     private String direccion;
     private String email;
     private String contrasenia;
      @Enumerated(EnumType.STRING)
      private Rol rol;
      
      //@OnetoMany                         //VER ESO YA QUE ME DICE QUE ME FALTA EL REPOSITORIO

      private Comentario comentario;
      
      //@OnetoMany                        //VER ESO YA QUE ME DICE QUE ME FALTA EL REPOSITORIO

      private Calificacion calificacion;

    public Usuario() {
    }

    public Usuario(String id, String nombreUser, int idUser, String direccion, String email, String contrasenia, Rol rol, Comentario comentario, Calificacion calificacion) {
        this.id = id;
        this.nombreUser = nombreUser;
        this.idUser = idUser;
        this.direccion = direccion;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.comentario = comentario;
        this.calificacion = calificacion;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    
      
}

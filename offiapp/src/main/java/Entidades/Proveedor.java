/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gonza
 */
@Entity
public class Proveedor {
      @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2") 
    private String id;
     private String nombre;
     private String descripcion;
     private int telefono;
     private String servicioOfrecido;

    public Proveedor() {
    }

    public Proveedor(String id, String nombre, String descripcion, int telefono, String servicioOfrecido) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.servicioOfrecido = servicioOfrecido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getServicioOfrecido() {
        return servicioOfrecido;
    }

    public void setServicioOfrecido(String servicioOfrecido) {
        this.servicioOfrecido = servicioOfrecido;
    }
     
     
     
     
    
}

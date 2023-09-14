
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
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
    private String nombreProv;
 
    private int telefono;
    private ArrayList<Servicio>servicio;
    private int precioHora;
    private String descripcion;
   
     // @OnetoMany                 //VER ESO YA QUE ME DICE QUE ME FALTA EL REPOSITORIO
    private Servicio servicios;          //Le coloque "servicio" dado que la palabra servio ya esta ocupada en el ArrayList     

    public Proveedor() {
    }

    public Proveedor(String id, String nombreProv, int idProv, int telefono, ArrayList<Servicio> servicio, int precioHora, String descripcion, Servicio servicios) {
        this.id = id;
        this.nombreProv = nombreProv;
        
        this.telefono = telefono;
        this.servicio = servicio;
        this.precioHora = precioHora;
        this.descripcion = descripcion;
        this.servicios = servicios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Servicio> getServicio() {
        return servicio;
    }

    public void setServicio(ArrayList<Servicio> servicio) {
        this.servicio = servicio;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Servicio getServicios() {
        return servicios;
    }

    public void setServicios(Servicio servicios) {
        this.servicios = servicios;
    }
    
     
}
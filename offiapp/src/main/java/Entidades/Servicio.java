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
 * @author hplap
 */
@Entity
public class Servicio {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid")
    private String Id;
    private int idServ;
    private String nombreserv;
    private String descripcion;

    public Servicio() {
    }

    public Servicio(String Id, int idServ, String nombreserv, String descripcion) {
        this.Id = Id;
        this.idServ = idServ;
        this.nombreserv = nombreserv;
        this.descripcion = descripcion;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int idServ) {
        this.idServ = idServ;
    }

    public String getNombreserv() {
        return nombreserv;
    }

    public void setNombreserv(String nombreserv) {
        this.nombreserv = nombreserv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
